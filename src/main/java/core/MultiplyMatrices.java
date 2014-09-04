package core;
import javax.xml.ws.Endpoint;


public class MultiplyMatrices {

	public static void main(String[] args) {
		Endpoint endpoint = Endpoint.create(new MatrixMultiplicationCoordinator());
		endpoint.publish("http://0.0.0.0:1235/MultiplyMatrices");
	}
}
