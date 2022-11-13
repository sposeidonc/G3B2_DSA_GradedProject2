package com.gl.dsa.project2.question2.bst_to_skewed;

import java.util.LinkedList;
import java.util.Queue;

public class BstToSkewedTreeForAnMncImplementation {

	// Declaring nodes for traversing through the BST
	static Node prevNode = null;
	static Node headNode = null;

	// Defining a class Node
	static class Node {
		int key;
		Node left;
		Node right;
	}

	// Method to create a new node every time a user inputs a value
	static Node newNode(int value) {
		Node temp = new Node();
		temp.key = value;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	// Method to insert the Values input by user to a BST.
	static Node insert(Node root, int key) {
		Node newNode = newNode(key);
		Node x = root;
		Node currentParent = null;
		while (x != null) {
			currentParent = x;
			if (key < x.key) {
				x = x.left;
			} else if (key > x.key) {
				x = x.right;
			} else {
				System.out.println("Value already exists!!");
				return newNode;

			}
		}
		if (currentParent == null) {
			currentParent = newNode;
		} else if (key < currentParent.key) {
			currentParent.left = newNode;
		} else {
			currentParent.right = newNode;
		}
		return currentParent;

	}

	// Method for converting the BST to a increasing skewed tree.
	void conversionOfBstToSkewed(Node root) {

		if (root == null) {
			return;
		}
		// Recursing to the left subtree first to get the smaller values first
		conversionOfBstToSkewed(root.left);

		Node rightNode = root.right;

		// Condition to check if the root Node of the skewed tree is not defined
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			// If not headNode not null, inserting to the right child
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		// Similarly recursing for the right subtree
		conversionOfBstToSkewed(rightNode);

	}

	// Function to traverse the right skewed tree using recursion
	void skewedTreeRepresentation(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + " ");
		skewedTreeRepresentation(root.right);
	}

	// Method for traversing the BST
	void levelOrderTraversalForBST(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node tempNode = q.poll();
			System.out.print(tempNode.key + " ");
			if (tempNode.left != null) {
				q.add(tempNode.left);
			}
			if (tempNode.right != null) {
				q.add(tempNode.right);
			}
		}
		System.out.println();
	}
}
