package com.gl.dsa.project2.question1.skyscraper;

import java.util.Scanner;

public class DriverClass {
	// Driver class
	public static void main(String[] args) {
		// Scanner element for accepting user input
		Scanner sc = new Scanner(System.in);
		// Accepting the total floors from the user
		System.out.println("Enter the total number floors in the building : ");
		int floors = sc.nextInt();
		// Creating an object for calling the function OrderOfConstruction
		SkyscraperQuestionImplementation obj = new SkyscraperQuestionImplementation();
		obj.OrderOfConstruction(floors);
		sc.close();
	}
}
