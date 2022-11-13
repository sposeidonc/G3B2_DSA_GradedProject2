package com.gl.dsa.project2.question2.bst_to_skewed;

import java.util.Scanner;

public class DriverClass extends BstToSkewedTreeForAnMncImplementation {
	// Driver Code
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BstToSkewedTreeForAnMncImplementation obj = new BstToSkewedTreeForAnMncImplementation();
		Node root = null;
		Node result = null;

		System.out.println("Enter the Number of Elements to insert into BST: ");
		int size = input.nextInt();
		for (int i = 0; i < size; i++) {
			// Accepting input from user and creating a BST
			System.out.println("Enter element " + (i + 1) + " : ");
			int value = input.nextInt();
			if (root == null) {
				root = insert(root, value);
			} else {
				result = insert(root, value);
				if (result.key == value)
					i -= 1;
			}
		}
		System.out.println("The level order representation of BST before conversion into a Skewed tree: ");
		obj.levelOrderTraversalForBST(root);
		System.out.println();
		System.out.println("----------Converting the BST to a Skewed tree----------");
		System.out.println();
		// Converting the BST to a skewed tree
		obj.conversionOfBstToSkewed(root);
		System.out.println("The representation of the new converted skewed tree: ");
		obj.skewedTreeRepresentation(headNode);

		input.close();
	}
}
