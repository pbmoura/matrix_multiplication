package core;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface MultiplyMatrix {
	
	@WebMethod
	public double[][] multiply(double[][] A, double[][] B, int n, int min, int max) throws RemoteException, InterruptedException, ExecutionException;
}
