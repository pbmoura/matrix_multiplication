package core;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(targetNamespace="matrix.client")
public class MatrixMultiplicationCoordinator {
    private static final int MOD = 8;
    
    private List<String> serversIP = new ArrayList<String>();
    
    private final SimpleLogger logger = new SimpleLoggerImpl("/tmp/MultiplyMatrixClient.log");
    
    
    public static void runInstance(String url) {
    	Endpoint endpoint = Endpoint.create(new MatrixMultiplicationCoordinator());
		endpoint.publish(url);
    }

    @WebMethod
    public double[][] multiply(double[][] A, double[][]B) throws InterruptedException {
    	return multiplyMatrix(A, B, B.length, serversIP.size());
    }
    
    @WebMethod
	public String multiplyMatrices(int size, String output) throws InterruptedException {
		boolean print = output.equals("true");
		createMatricesAndCallRemotes(size, print);
		return "Ok";
    }
    
    @WebMethod
    public void addServer(String ip) {
    	serversIP.add(ip);
    }
    
    @WebMethod
    public void clearServices() {
    	serversIP.clear();
    }
    
    @WebMethod
    public List<String> listServices() {
    	return serversIP;
    }
    
	private void createMatricesAndCallRemotes(final Integer n, boolean print) throws InterruptedException  {
		double[][] A = createMatrix(n);
		double[][] B = createMatrix(n);
		Long m1 = System.currentTimeMillis();
		double[][] C = multiplyMatrix(A, B, n, serversIP.size());
		Long m2 = System.currentTimeMillis();
		//printMatrix(A, n);
		//printMatrix(B, n);
		if(print)
			printMatrix(C, n);
		Long mf = m2 - m1;
		logger.info("time: " + mf.toString());
	}


	private double[][] createMatrix(int n) {
		double[][] M = new double[n][n];

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				M[i][j] = MOD/2 - ((i+j)%MOD);
			}
		}
		return M;
	}
	
	private double[][] multiplyMatrix(double[][] A, double[][] B, int n, int threads) throws InterruptedException {
		double[][] C = new double[n][n];
		List<MultiplyColumn> mcs = new ArrayList<MultiplyColumn>();
		
		logger.info("Multiplying matrices: " + n + " " + threads);
		
		final int interval = n/threads;
		int min=0;
		for(int i=0;i<threads-1;i++) {
			mcs.add(new MultiplyColumn(A, B, n, min, min+interval, C, serversIP.get(i)));
			min+=(interval);
		}
		mcs.add(new MultiplyColumn(A, B, n, min, n, C, serversIP.get(threads-1)));
		
		for (MultiplyColumn multiplyColumn : mcs) {
			multiplyColumn.start();
		}
		
		for (MultiplyColumn multiplyColumn : mcs) {
			multiplyColumn.join();
		}
		
		return C;
	}
	
	private void printMatrix(double[][] M, int n) {
		printMatrix(M, n, n);
	}
	
	private void printMatrix(double[][] M, int n, int m) {
		logger.info("---------------------------------"+n);
		String line;
		for(int i=0; i<n; i++) {
			line = "";
			for(int j=0; j<m; j++) {
				line += (M[i][j] + " ");
			}
			logger.info(line);
		}
	}
}
