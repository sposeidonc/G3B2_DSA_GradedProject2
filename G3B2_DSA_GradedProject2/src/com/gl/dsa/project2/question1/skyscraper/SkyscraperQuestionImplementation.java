package com.gl.dsa.project2.question1.skyscraper;

import java.util.Scanner;

public class SkyscraperQuestionImplementation {
	Scanner sc = new Scanner(System.in);

	public void OrderOfConstruction(int floors) {
		// Declaring an array to store the size of each floor
		int day[] = new int[floors + 1];
		// Iterating through the no. of floors
		for (int i = 1; i <= floors; i++) {

			// Accepting the floor number
			System.out.println("Enter the floor given on day " + i + " :");
			int floorNo = sc.nextInt();
			// Rejecting the floor if 0 is given as an input.
			if (floorNo == 0) {
				System.out.println("Please enter a valid floor!");
				i -= 1;
				continue;
			}
			// Rejecting the floor if given floor size is greater than the total no. of
			// floors

			if (floorNo > floors) {
				System.out.println("Floor not valid! Please try again!");
				i -= 1;
				continue;
			}
			// Rejecting the floor if that floor was already received.
			if (checkDuplicate(day, floorNo)) {
				System.out.println("Floor already received! Please try again!");
				i -= 1;
				continue;
			}
			// Storing the iteration no.(i) at the index of the floor no. in day array
			day[floorNo] = i;
		}
		// Declaring a temporary variable
		int temp = floors;
		// Declaring a flag variable to check the condition when required.
		int flag;
		System.out.println("The order of construction is as follows ");
		// Iterating through the no. of floors
		for (int i = 1; i <= floors; i++) {
			// Initialize flag to 0 for each iteration
			flag = 0;
			System.out.println("Day " + i + " :");
			// Finding the floor with the highest size available
			while (temp >= 1 && day[temp] <= i) {
				// Updating the flag
				flag = 1;
				// Printing the floor
				System.out.print(temp + " ");
				// Finding the next highest floor available
				temp--;
			}
			// Proceeding to next day if flag is updated
			if (flag == 1)
				System.out.println();
		}
		// Closing the Scanner element
		sc.close();
	}

	// Method checking if there are duplicate values entered by user
	protected boolean checkDuplicate(int[] arr, int value) {
		if (arr[value] == 0) {
			return false;
		} else {
			return true;
		}
	}
}
