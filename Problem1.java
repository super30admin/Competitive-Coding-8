//Question  : Print the borders of the Tree.
import java.util.ArrayList;
import java.util.List;

public class CC8 {
	
	static List<Integer> result = new ArrayList<Integer>();
	static int rootData=0;
	static class Node{
		int data;
		Node left,right;
		Node(int x){
			this.data = x;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		generateTree(root);
		System.out.println("InOrder:");inOrder(root);  		// left --> ROOT --> right 
		System.out.println("\nPreOrder:");preOrder(root);   // ROOT --> left --> right
		System.out.println("\nPostOrder:");postOrder(root); // left --> right --> ROOT
		
		printBorders(root);

	}

	private static void printBorders(Node root) {
		// idea is print the borders only of the tree
		// first prints left borders
		// second print the leaf nodes
		// third print the right border from bottom up.
		if(root!=null ) rootData = root.data;
		printLeft(root);
		printLeaf(root);
		printRightfromBottomUp(root);
		System.out.println("\n"+result);
	}

	private static void printRightfromBottomUp(Node root) {
		
		if(root == null) return;
		
		if(root.right!=null){
			printRightfromBottomUp(root.right);
			if(rootData != root.data) result.add(root.data); // avoid reinserting the root value again.
		}
		
	}

	private static void printLeaf(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		if(root.left == null && root.right== null)
		{
			result.add(root.data);
		}
		printLeaf(root.left);
		printLeaf(root.right);
		
	}

	private static void printLeft(Node root) {
		if(root == null) return;
		if(root.left!=null){
			result.add(root.data);
			printLeft(root.left);
		}
	}

	private static void postOrder(Node root) {
		//checking if root is null
		if(root == null) return;
		postOrder(root.left);  // recursively Call the left first
		postOrder(root.right); // recursively Call the right last
		System.out.print(root.data +" "); //print root data last

		
	}

	private static void preOrder(Node root) {
		//checking if root is null
		if(root == null) return;
		System.out.print(root.data +" "); //print root data first
		preOrder(root.left);  // recursively Call the left first
		preOrder(root.right); // recursively Call the right last
		
	}

	private static void inOrder(Node root) {
		//checking if root is null
		if(root == null) return;
		inOrder(root.left); // recursively Call the left first
		System.out.print(root.data +" ");
		inOrder(root.right); // recursively Call the right last
	}

	public static void generateTree(Node root) {						   //	              1
		root.left = new Node(2);							   //           /           \
		root.right = new Node(3);							   //          2             3
		root.left.left = new Node(4); root.right.left = new Node(6);    		   //        /   \         /    \
		root.left.right = new Node(5); root.right.right = new Node(7);             	   //       4     5       6      7
		root.left.left.left = new Node(8); root.left.right.left = new Node(10);            //      / \  /   \    / \    / \
		root.left.left.right= new Node(9); root.left.right.right = new Node(11);           //     8   9 10  11  12 13  14 15
		root.right.left.left = new Node(12); root.right.right.left = new Node(14);
		root.right.left.right= new Node(13); root.right.right.right = new Node(15);
	}
	

}
