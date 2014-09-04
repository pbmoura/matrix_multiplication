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
public class SerialMultiplyMatrixService implements MultiplyMatrix {

	private final SimpleLogger logger = new SimpleLoggerImpl(
			"/tmp/MultiplyMatrixImpl.log");

	public SerialMultiplyMatrixService() throws RemoteException {
		super();
	}

	@Override
	public double[][] multiply(double[][] A, double[][] B, int n, int min,
			int max) throws RemoteException, InterruptedException,
			ExecutionException {
		double[][] M = new double[n][n];
		logger.info("Receveing request: " + n + " " + min + " " + max);
		for (int i = 0; i < n; i++) {
			for (int j = min; j < max; j++) {
				M[i][j] = 0;
				for (int k = 0; k < n; k++) {
					M[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		logger.info("returning");
		return M;
	}

	public static void main(String[] args) throws Exception {
		Endpoint endpoint = Endpoint.create(new SerialMultiplyMatrixService());
		endpoint.publish("http://0.0.0.0:1234/MultiplyMatrixService");
	}

}
