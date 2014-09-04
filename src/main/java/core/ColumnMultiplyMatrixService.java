package core;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(targetNamespace = "multiply.matrix")
public class ColumnMultiplyMatrixService implements MultiplyMatrix {

	private final SimpleLogger logger = new SimpleLoggerImpl(
			"/tmp/MultiplyMatrixImpl.log");

	public ColumnMultiplyMatrixService() throws RemoteException {
		super();
	}

	@Override
	public double[][] multiply(double[][] A, double[][] B, int n, int min,
			int max) throws RemoteException, InterruptedException,
			ExecutionException {
		double[][] M = new double[n][n];
		int cores = Runtime.getRuntime().availableProcessors();
		final List<Future<MultiplicationResult>> futureResults = new ArrayList<Future<MultiplicationResult>>();
		final ExecutorService executorService = Executors
				.newFixedThreadPool(cores);
		logger.info("Receveing request: " + n + " " + min + " " + max);
		for (int i = 0; i < n; i++) {
			for (int j = min; j < max; j++) {
				ColumnMultiplication cm = new ColumnMultiplication(A, B, i, j,
						n);
				Future<MultiplicationResult> result = executorService
						.submit(cm);
				futureResults.add(result);
			}
		}
		executorService.shutdown();
		while (!executorService.awaitTermination(6000, TimeUnit.SECONDS))
			;
		for (Future<MultiplicationResult> f : futureResults) {
			MultiplicationResult r = f.get();
			M[r.i][r.j] = r.value;
		}
		logger.info("returning");
		return M;
	}

	public static void main(String[] args) throws Exception {
		Endpoint endpoint = Endpoint.create(new ColumnMultiplyMatrixService());
		endpoint.publish("http://0.0.0.0:1234/MultiplyMatrixService");
	}

}

class ColumnMultiplication implements Callable<MultiplicationResult> {

	double[][] A, B;
	int i, j, n;

	public ColumnMultiplication(double[][] A, double[][] B, int i, int j, int n) {
		this.A = A;
		this.B = B;
		this.i = i;
		this.j = j;
		this.n = n;
	}

	@Override
	public MultiplicationResult call() throws Exception {
		double m = 0.0;

		for (int k = 0; k < n; k++) {
			m += A[i][k] * B[k][j];
		}
		return new MultiplicationResult(m, i, j);
	}

}

class MultiplicationResult {
	double value;
	int i, j;

	public MultiplicationResult(double value, int i, int j) {
		super();
		this.value = value;
		this.i = i;
		this.j = j;
	}

}
