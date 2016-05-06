//-----------------------------------------------------
// Title: Node
// Author: Hilal Köktürk
// ID: 49093709988
// Section: 1
// Assignment: 4
// Description: This class describes the Binary Search Tree Nodes
//-----------------------------------------------------


public class Node {
    
	public String value;
    public Node left;
    public Node right;
    public int key;
    
    public Node(String value, int key) {
    	
    	//--------------------------------------------------------
   	 // Summary: Here is constructor
   	 // Precondition: value is a string
   	 //--------------------------------------------------------
   	
    	
   
    this.value = value;
    this.key = key;
    
    }
}