package core;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import matrix.multiply.MultiplyMatrixImplService;
import net.java.dev.jaxb.array.DoubleArray;

public class MultiplyColumn extends Thread {

	private final SimpleLogger logger = new SimpleLoggerImpl("/tmp/MultiplyColumn.log");
	
	private double[][] A;
	private double[][] B;
	private double[][] C;
	private int n;
	private int min;
	private int max;
	private String uri;

	public MultiplyColumn(double[][] A, double[][] B, int n, int min, int max, double[][] C, String uri) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.n = n;
		this.min = min;
		this.max = max;
		this.uri = uri;
	}

	
	private void copyMatrix(List<DoubleArray> M) {
		for (int i = 0; i < n; i++) {
			for (int j = min; j < max; j++) {
				C[i][j] = M.get(i).getItem().get(j);
			}
		}
	}

	public double[][] getC() {
		return C;
	}

	@Override
	public void run() {
		List<DoubleArray> M = null;
        try {  
//        	MultiplyMatrix m = (MultiplyMatrix) Naming.lookup( "rmi://" + ip + ":1099/MultiplyMatrixService" );  
//            M = m.multiply(A, B, n, min, max);
            
            MultiplyMatrixImplService mms = new MultiplyMatrixImplService(new URL(uri+"?wsdl"), new QName("multiply.matrix", "MultiplyMatrixImplService"));
            matrix.multiply.MultiplyMatrixImpl m = mms.getMultiplyMatrixImplPort();
            M = m.multiply(toList(A), toList(B), n, min, max);
        }  
        
        catch( Exception e ) {  
            logger.error("Exception: " + e.toString(), e);  
        } 
		copyMatrix(M);
	}
	
	private List<DoubleArray> toList(double[][] matrix) {
		List<DoubleArray> result = new ArrayList<DoubleArray>();
		for(int i = 0; i < matrix.length; i++) {
			DoubleArray array = new DoubleArray();
			for(int j = 0; j < matrix[i].length; j++) {
				array.getItem().add(matrix[i][j]);
			}
			result.add(array);
		}
		return result;
	}
	
}
