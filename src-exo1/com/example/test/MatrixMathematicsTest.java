package com.example.test;


import com.example.exception.NoSquareException;
import com.example.model.Matrix;
import com.example.service.MatrixMathematics;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class MatrixMathematicsTest {


	@Test
	public void testTranspose() {
	double [][] data = {{1,2},{3,4},{5,6}};
	double [][] res = {{1,3,5},{2,4,6}};
   
	Matrix matrix =new Matrix (data);
	assertArrayEquals(res,MatrixMathematics.transpose(matrix).getValues());
	}
	/*Tester la methode Inverse qui inverse une matrice*/
	@Test
	public void testInverse() throws NoSquareException {
		double [][] data = {{1,2},{3,4}};
		double [][] res = {{-2,1},{1.5,-0.5}};
		
		Matrix matrix =new Matrix (data);
		assertArrayEquals(res,MatrixMathematics.inverse(matrix).getValues());
	}
	/*Tester la methode determinant qui retourne le determinant d'une matrice*/
	@Test
	public void testDeterminant_1() throws NoSquareException {
		double [][] data = {{1,2},{3,4}};
		Matrix matrix =new Matrix (data);
		assertEquals(-2.0,MatrixMathematics.determinant(matrix),0.1);
		
	}
	
	/*Tester la methode determinant d'une facon à provoquer une exception car la matrice n'est pas carrée*/
	@Test (expected=NoSquareException.class)
	public void testDeterminant_2() throws NoSquareException  {
		double [][] data2 = {{1,2},{3,4},{5,6}};
		Matrix matrix2 =new Matrix (data2);
		MatrixMathematics.determinant(matrix2);
		
	}
	/*Tester la methode determinant avec une matrice (3,3) pour utiliser un block de code precis pour couvrir tout le code de la methode*/
	@Test
	public void testDeterminant_3() throws NoSquareException {
		double [][] data = {{1,2,3},{4,5,6},{7,8,10}};
		Matrix matrix =new Matrix (data);
		assertEquals(-3.0,MatrixMathematics.determinant(matrix),0.1);
		
	}
	
	/*Tester la methode determinant avec une matrice à un element*/
	@Test
	public void testDeterminant_4() throws NoSquareException {
		double [][] data = {{1}};
		Matrix matrix =new Matrix (data);
		assertEquals(1.0,MatrixMathematics.determinant(matrix),0.1);
		
	}

	

	@Test
	public void testCofactor() throws NoSquareException {
		
		double [][] data = {{1,2,3},{4,5,6},{7,8,9}};
		double [][] res = {{-3,6,-3},{6,-12,6},{-3,6,-3}};
		Matrix matrix =new Matrix (data);
		assertArrayEquals(res,MatrixMathematics.cofactor(matrix).getValues());
			
	}

}
