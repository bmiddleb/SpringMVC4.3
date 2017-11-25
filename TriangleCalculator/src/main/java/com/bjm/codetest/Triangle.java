package com.bjm.codetest;

public class Triangle implements Shape {
	private double side1 = 0.0;
	private double side2 = 0.0;
	private double side3 = 0.0;
	private double area = 0.0;
	private double circumference = 0.0;
	private int numberOfSides = 0;

	public Triangle() {
		this.setNumberOfSides(3);
	}

	public Triangle(double side1, double side2, double side3) {
		this.setNumberOfSides(3);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.setCircumference(side1 + side2 + side3);
		this.setArea(this.calcArea(side1, side2, side3));
	}

	private double calcArea(double side1, double side2, double side3) {
		double halfPerim = this.getCircumference()/2.0;

		return Math.sqrt
				(halfPerim
					*(halfPerim-side1)
					*(halfPerim-side2)
					*(halfPerim-side3)
				);
	}

	public double getCircumference() {
		return this.circumference;
	}


	public int getNumberOfSides() {
		return this.numberOfSides;
	}
	public void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public double getArea() { return this.area; }
	public void setArea(double area) {
		this.area = area;
	}

	public void setCircumference(double circumference) {
		this.circumference = circumference;
	}

}
