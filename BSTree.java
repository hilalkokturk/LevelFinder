//-----------------------------------------------------
// Title: Binary Search
// Author: Hilal Köktürk
// ID: 49093709988
// Section: 1
// Assignment: 4
// Description: This class describes the Binary Search Tree
//-----------------------------------------------------

public class BSTree {
    private Node root;
    
    

    public Node FindINBst(String value) {
    	
    	//--------------------------------------------------------
    	 // Summary: find value in the tree
    	 // Precondition: value is a string
    	 // Postcondition: value will be found in the tree
    	 //--------------------------------------------------------
    	
    	
        Node r = root;
        while(r != null) {
            int val = value.compareTo(r.value);
            if (val < 0) {
                r = r.left;
            }
            else if (val > 0) {
                r = r.right;
            }
            else {
                return r;
            }
        }
        return null;
    }

    public void insert(String value) {
        root = insert(root, value);
    }

    private Node insert(Node r, String value) {
    	
    //--------------------------------------------------------
   	 // Summary: inserting new value
   	 // name is given.
   	 // Precondition: value is a string, r is a node
   	 // Postcondition: new value will be inserted a node
   	 //--------------------------------------------------------
   	
    	
    	
        if (r == null) {
            return new Node(value,1);
        }
        int cmp = value.compareTo(r.value);
        if (cmp < 0) {
            r.left = insert(r.left, value);
        }
        else if (cmp > 0) {
            r.right = insert(r.right, value);
        }
        else {
            r.value = value;
        }
        r.key = size(r.left) + size(r.right) + 1;
        return r;
    }

    private int size(Node r) {
        if (r == null) {
            return 0;
        }
        else {
            return r.key;
        }
    }
    public int position(Node n) {
    	
    	//--------------------------------------------------------
   	 // Summary: decide the pozition of the value
   	 // Precondition: n is node
   	 // Postcondition: the pozition of the value will be found
   	 //--------------------------------------------------------
   	
    	
        Node r = root;
        int count = 1;
        while(r != n && r != null){
            if(n.value.compareTo(r.value) < 0) {
                r = r.left;
                count++;
            }
            else if(n.value.compareTo(r.value) > 0) {
                r = r.right;
                count++;
            }
        }
        return count;
    }

}


