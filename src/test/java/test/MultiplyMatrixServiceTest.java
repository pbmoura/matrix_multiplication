package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.MultiplyMatrix;
import core.MultiplyMatrixService;
import core.SerialMultiplyMatrixService;

public class MultiplyMatrixServiceTest {

	@Test
	public void test1() throws Exception {
		MultiplyMatrix service = new MultiplyMatrixService();
		double[][] A = {{1, 2}, {3, 4}};
		double[][] B = {{1, 1}, {1, 1}};
		double[][] M = {{3, 3},{7, 7}};
		double[][] C = service.multiply(A, B, 2, 0, 2);
		assertEquals(M, C);
	}
	
	@Test
	public void test1s() throws Exception {
		MultiplyMatrix service = new SerialMultiplyMatrixService();
		double[][] A = {{1, 2}, {3, 4}};
		double[][] B = {{1, 1}, {1, 1}};
		double[][] M = {{3, 3},{7, 7}};
		double[][] C = service.multiply(A, B, 2, 0, 2);
		assertEquals(M, C);
	}
	
	@Test
	public void test2() throws Exception {
		MultiplyMatrix service = new MultiplyMatrixService();
		double[][] A = {{1, 2}, {3, 4}};
		double[][] B = {{1, 2}, {1, 2}};
		double[][] M = {{0, 6},{0, 14}};
		double[][] C = service.multiply(A, B, 2, 1, 2);
		assertEquals(M, C);
	}

	@Test
	public void test3() throws Exception {
		MultiplyMatrix service = new MultiplyMatrixService();
		final int SIZE = 400;
		double[][] A = new double[SIZE][SIZE];
		double[][] M = new double[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++)
				M[i][j] = SIZE * (A[i][j] = 1);
		double[][] C = service.multiply(A, A, SIZE, 0, SIZE);
		assertEquals(M, C);
	}
	
	@Test
	public void test4() throws Exception {
		MultiplyMatrix service = new SerialMultiplyMatrixService();
		final int SIZE = 400;
		double[][] A = new double[SIZE][SIZE];
		double[][] M = new double[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++)
				M[i][j] = SIZE * (A[i][j] = 1);
		double[][] C = service.multiply(A, A, SIZE, 0, SIZE);
		assertEquals(M, C);
	}
}
