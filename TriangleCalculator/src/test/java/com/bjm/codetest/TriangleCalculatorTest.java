package com.bjm.codetest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TriangleCalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTriangleInstantiation() {
		Shape shape = new Triangle();
		assertTrue(shape !=  null);
	}

	@Test
	public void testTriangleSidesAccessor() {
		int numberOfSides = 3;
		Shape shape = new Triangle();

		assertTrue( numberOfSides == shape.getNumberOfSides() );
	}

	@Test
	public void testTriangleCircumferenceAccessor() {
		Shape shape = new Triangle(3,4,5);
		double circumference = 3+4+5;

		assertTrue( circumference == shape.getCircumference() );
	}

	@Test
	public void testTriangleAreaCalculation() {
		Shape shape = new Triangle(3,4,5);
		double testArea = .5*3*4;

		assertTrue( testArea == shape.getArea() );
	}

}
