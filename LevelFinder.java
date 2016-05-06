//-----------------------------------------------------
// Title: LevelFinder
// Author: Hilal Köktürk
// ID: 49093709988
// Section: 1
// Assignment: 4
// Description: This class describes Tester
//-----------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LevelFinder {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(
				"C:\\Users\\Lilo\\workspace\\AlgoOdev4\\src\\query.txt");  //reading data from the txt file
		Scanner kb = new Scanner(file);
		BSTree bstree = new BSTree(); //creating new bst tree object

		AVLTree avltree = new AVLTree();  // creating new avl tree object
		while (kb.hasNext()) {
			String str = kb.nextLine();
			bstree.insert(str);
			avltree.insert(str);
		}

		file = new File("C:\\Users\\Lilo\\workspace\\AlgoOdev4\\src\\query.txt");  //reading data from the txt file
		kb = new Scanner(file);
		File file2 = new File(
				"C:\\Users\\Lilo\\workspace\\AlgoOdev4\\src\\output.txt");   //reading data from the txt file
		PrintWriter printer = new PrintWriter(file2);
		while (kb.hasNext()) {
			String str = kb.nextLine();
			if (bstree.FindINBst(str) != null) {

				double beginningtime = System.nanoTime() / 1000;   //calculating milisecond to find "the position str in avltree using nanotime 
				int avlnodeposition = avltree.position(str);
				double endtime = System.nanoTime() / 1000;
				double avltime = (endtime - beginningtime);

				double beginningtime2 = System.nanoTime() / 1000;    //calculating milisecond to find the position str in binary search tree using nanotime 
				int binarynodeposition = bstree.position(bstree.FindINBst(str));
				double endtime2 = System.nanoTime() / 1000;
				double binarysearchtime = (endtime2 - beginningtime2);

				printer.println(binarynodeposition + " " + avlnodeposition   //printing the second for binary search tree
						+ " " + str);
				System.out.println("Query " + str + " found in "
						+ binarysearchtime + " ms in BST");

				System.out.println("Query" + str + "fount in" + avltime    //printing the second for avl tree
						+ " ms in AVL");
			} else {   // else condition for the possibility that we cant find str in the tree
				printer.println("0 0 " + str);
				System.out.println("Query " + str
						+ " not found in BST");
				System.out.println("Query"+str+"not found in AVL");
				
			}
		}
		printer.close();
	}
}
