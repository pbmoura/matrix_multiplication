package core;

import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(targetNamespace = "multiply.matrix")
public class MultiplyMatrixService implements MultiplyMatrix {

	private int poolSize;
	private final SimpleLogger logger = new SimpleLoggerImpl(
			"/tmp/MultiplyMatrixImpl.log");

	public MultiplyMatrixService() throws RemoteException {
		this(Runtime.getRuntime().availableProcessors());
	}
	
	public MultiplyMatrixService(int poolSize) {
		super();
		this.poolSize = poolSize;
	}

	public static Endpoint runInstance(String url) throws RemoteException {
		Endpoint endpoint = Endpoint.create(new MultiplyMatrixService());
		endpoint.publish(url);
		return endpoint;
	}
		
	public static Endpoint runInstance(String url, int poolSize) throws RemoteException {
    	Endpoint endpoint = Endpoint.create(new MultiplyMatrixService(poolSize));
		endpoint.publish(url);
		return endpoint;
    }
	
	@WebMethod
	public int getPoolSize() {
		return poolSize;
	}

	@WebMethod
	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

	@Override
	public double[][] multiply(double[][] A, double[][] B, int n, int min,
			int max) throws RemoteException, InterruptedException,
			ExecutionException {
		double[][] M = new double[n][n];
		int cols = max - min;
		int colsPerThread = cols / poolSize;
		final ExecutorService executorService = Executors
				.newFixedThreadPool(poolSize);
		logger.info("Receveing request: " + n + " " + min + " " + max);

		int from = min;
		if (colsPerThread > 0)
			for (int i = 0; i < poolSize-1; i++) {
				Multiplicator cm = new Multiplicator(A, B, from, (from+=colsPerThread), n, M);
				executorService.execute(cm);
			}
		Multiplicator cm = new Multiplicator(A, B, from, max, n, M);
		executorService.execute(cm);
		
	
		executorService.shutdown();
		while (!executorService.awaitTermination(60, TimeUnit.SECONDS))
			;
		
		logger.info("returning");
		return M;
	}

	public static void main(String[] args) throws Exception {
		String port = "1234";
		int cores = 4;

		if(args.length > 0)
			port = args[0];
		if(args.length > 1)
			cores = Integer.parseInt(args[1]);
		
		runInstance("http://0.0.0.0:" + port + "/MultiplyMatrixService",cores);
	}

}

class Multiplicator implements Runnable {

	double[][] A, B, C;
	int min, max, n;

	public Multiplicator(double[][] A, double[][] B, int min, int max, int n, double[][] C) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.n = n;
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
			for (int j = min; j < max; j++) {
				C[i][j] = 0;
				for (int k = 0; k < n; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}

}