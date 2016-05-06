//-----------------------------------------------------
// Title: AVL Tree class
// Author: Hilal Köktürk
// ID: 49093709988
// Section: 1
// Assignment: 4
// Description: This class describes the AVL tree nodes
//-----------------------------------------------------


public class AvlNode{
	
	AvlNode left;
	AvlNode right;
	AvlNode parent;
	String key;
	int balance;

	public AvlNode(String k) {  //here is constructor
		left = right = parent = null;
		balance = 0;
		key = k;
	}
	public String toString() { //toString method to print key
		return "" + key;
	}
	
}

	


