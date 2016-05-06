//-----------------------------------------------------
// Title: AVL Tree class
// Author: Hilal Köktürk
// ID: 49093709988
// Section: 1
// Assignment: 4
// Description: This class describes the Avl Tree
//-----------------------------------------------------
import java.util.ArrayList;


public class AVLTree {

	protected AvlNode root; // the root node

	public void insert(String str) {
		// create new node
		AvlNode n = new AvlNode(str);
		// start procedure to insert the node
		insertAVL(this.root,n);
	}
	public void insertAVL(AvlNode x, AvlNode x2) {
		
		//--------------------------------------------------------
   	 // Summary: inserting a new value in AVL tree
   	 // Precondition: x and x2 are node
   	 // Postcondition: node of x and x2 will insert in AVL tree
   	 //--------------------------------------------------------
   	
		
		
		if(x==null) {
			this.root=x2;
		} else {
			// If compare node is smaller, continue with the left node
			if(x2.key.charAt(0)<x.key.charAt(0)) {
				if(x.left==null) {
					x.left = x2;
					x2.parent = x;

					// Node is inserted now, continue checking the balance
					Balance(x);
				} else {
					insertAVL(x.left,x2);
				}
			} else if(x2.key.charAt(0)>x.key.charAt(0)) {
				if(x.right==null) {
					x.right = x2;
					x2.parent = x;

					// Node insert now, continue checking the balance
					Balance(x);
				} else {
					insertAVL(x.right,x2);
				}
			} 
		}
	}
	public int position(String value) {
		
		//--------------------------------------------------------
	   	 // Summary: decide the pozition of the value in Avl tree
	   	 // Precondition: n is node
	   	 // Postcondition: the pozition of the value will be found in Avl tree
	   	 //--------------------------------------------------------
		
		
		AvlNode x = root;
		int position = 0;
		while(!(x == null)) {
			int cmp = value.compareToIgnoreCase(x.key);
			if (cmp < 0) {
				x = x.left;
				position += 1;
			}
			else if (cmp > 0) {
				x = x.right;
				position +=1;
			}
			else {
				return position;
			}
		}
		return 0;
	}
	public void Balance(AvlNode cur) {
		//--------------------------------------------------------
	   	 // Summary: checking the balance
	   	 // Precondition: cur is an avl tree node
	   	 // Postcondition: the pozition of the value will be found
	   	 //--------------------------------------------------------
		
		// we do not use the balance in this class, but the store it anyway
		setBalance(cur);
		int balance = cur.balance;
		// check the balance
		if(balance==-2) {
			if(height(cur.left.left)>=height(cur.left.right)) {
				cur = rotateRight(cur);
			} else {
				cur = doubleRotateLeftRight(cur);
			}
		} else if(balance==2) {
			if(height(cur.right.right)>=height(cur.right.left)) {
				cur = rotateLeft(cur);
			} else {
				cur = doubleRotateRightLeft(cur);
			}
		}
		// we did not reach the root yet
		if(cur.parent!=null) {
			Balance(cur.parent);
		} else {
			this.root = cur;
			System.out.println("Balance have finished");
		}
	}
	
	public AvlNode rotateLeft(AvlNode n) {
		
		  //--------------------------------------------------------
	   	 // Summary: rotating left
	   	 // Precondition: n is avl node
	   	 // Postcondition: we will rotate the left avl tree with respect to node of n
	   	 //--------------------------------------------------------
	   	

		AvlNode v = n.right;
		v.parent = n.parent;
		n.right = v.left;

		if(n.right!=null) {
			n.right.parent=n;
		}
		v.left = n;
		n.parent = v;

		if(v.parent!=null) {
			if(v.parent.right==n) {
				v.parent.right = v;
			} else if(v.parent.left==n) {
				v.parent.left = v;
			}
		}
		setBalance(n);
		setBalance(v);
		return v;
	}
	public AvlNode rotateRight(AvlNode n) {

		 //--------------------------------------------------------
	   	 // Summary: rotating right
	   	 // Precondition: n is avl node
	   	 // Postcondition: we will rotate the right avl tree with respect to node of n
	   	 //--------------------------------------------------------
		
		AvlNode v = n.left;
		v.parent = n.parent;
		n.left = v.right;
		if(n.left!=null) {
			n.left.parent=n;
		}
		v.right = n;
		n.parent = v;

		if(v.parent!=null) {
			if(v.parent.right==n) {
				v.parent.right = v;
			} else if(v.parent.left==n) {
				v.parent.left = v;
			}
		}
		setBalance(n);
		setBalance(v);
		return v;
	}
	public AvlNode doubleRotateLeftRight(AvlNode u) {
		 //--------------------------------------------------------
	   	 // Summary: making double rotate to right
	   	 // Precondition: n is avl node
	   	 // Postcondition: we will make double rotate the right avl tree with respect to node of n
	   	 //--------------------------------------------------------
		
		u.left = rotateLeft(u.left);
		return rotateRight(u);
	}
	public AvlNode doubleRotateRightLeft(AvlNode u) {
	
		 //--------------------------------------------------------
	   	 // Summary: making double rotate to left
	   	 // Precondition: n is avl node
	   	 // Postcondition: we will make double rotate the left avl tree with respect to node of n
	   	 //--------------------------------------------------------
		
		u.right = rotateRight(u.right);
		return rotateLeft(u);
	}
	
	private int height(AvlNode cur) {
		 //--------------------------------------------------------
	   	 // Summary: calculating height 
	   	 // Precondition: cur is avl node
	   	 // Postcondition: we will calculate the height
	   	 //--------------------------------------------------------
		
		
		if(cur==null) {
			return -1;
		}
		if(cur.left==null && cur.right==null) {
			return 0;
		} else if(cur.left==null) {
			return 1+height(cur.right);
		} else if(cur.right==null) {
			return 1+height(cur.left);
		} else {
			return 1+maximum(height(cur.left),height(cur.right));
		}
	}
	private int maximum(int a, int b) {
		if(a>=b) {
			return a;
		} else {
			return b;
		}
	}
	private void setBalance(AvlNode cur) {
		cur.balance = height(cur.right)-height(cur.left);
	}
	final protected ArrayList<AvlNode> inorder() {
		ArrayList<AvlNode> ret = new ArrayList<AvlNode>();
		inorder(root, ret);
		return ret;
	}
	final protected void inorder(AvlNode n, ArrayList<AvlNode> io) {
		//--------------------------------------------------------
	   	 // Summary: making inorder trevarsal
	   	 // Precondition: n is node, io is the array list
	   	 //--------------------------------------------------------
	   	
		
		
		if (n == null) {
			return;
		}
		inorder(n.left, io);
		io.add(n);
		inorder(n.right, io);
	}
}
