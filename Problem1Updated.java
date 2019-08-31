import java.util.ArrayList;
import java.util.List;

public class CC8New {
	
	static List<Integer> result = new ArrayList<Integer>();
	static int rootData=0;
	static class Node{
		int data;
		Node left,right;
		Node(int x){
			this.data = x;
		}
	}
	
	public static void main(String[] args){
		
		Node root = new Node(1);													//				   1
		//root.left = new Node(2);										          	//           /           \
		root.right = new Node(3);										          	//          2             3
		//root.left.left = new Node(4); root.right.left = new Node(6);    		  	//        /   \         /    \
		//root.left.right = new Node(5); 
		root.right.right = new Node(7);             								//       4     5       6      7
		//root.left.left.left = new Node(8); root.left.right.left = new Node(10);     //      / \  /   \    / \    / \
		//root.left.left.right= new Node(9); root.left.right.right = new Node(11);    //     8   9 10  11  12 13  14 15
		//root.right.left.left = new Node(12);
		root.right.right.left = new Node(14);
		//root.right.left.right= new Node(13);
		root.right.right.right = new Node(15);
		
//		Node root = new Node(1);													//				   1
//		root.left = new Node(2);										          	//           /           \
//		root.right = new Node(3);										          	//          2             3
//		root.left.left = new Node(4); root.right.left = new Node(6);    		  	//        /   \         /    \
//		root.left.right = new Node(5); 
//		root.right.right = new Node(7);             								//       4     5       6      7
//		root.left.left.left = new Node(8); root.left.right.left = new Node(10);     //      / \  /   \    / \    / \
//		root.left.left.right= new Node(9); root.left.right.right = new Node(11);    //     8   9 10  11  12 13  14 15
//		root.right.left.left = new Node(12);
//		root.right.right.left = new Node(14);
//		root.right.left.right= new Node(13);
//		root.right.right.right = new Node(15);
		
		printBorders(root);
	}

	private static void printBorders(Node root) {
		// idea is print the borders only of the tree
		// first prints left borders
		// second print the leaf nodes
		// third print the right border from bottom up.
		if(root!=null ) rootData = root.data;
		result.add(root.data);
		System.out.print(root.data+" ");
		printLeft(root.left);
		printLeaf(root);
		printRightfromBottomUp(root.right);
		System.out.println("\n"+result);
		
	}
	
private static void printRightfromBottomUp(Node root) {
		
		if(root == null) return;
		
		if(root.right!=null){
			printRightfromBottomUp(root.right);
			result.add(root.data);
			System.out.print(root.data+" ");
		}
		else if(root.left!=null){
			printRightfromBottomUp(root.left);
			result.add(root.data);
			System.out.print(root.data+" ");
		}
		
	}

	private static void printLeaf(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		
		if(root.left == null && root.right== null)
		{
			result.add(root.data);
			System.out.print(root.data+" ");
		}
		printLeaf(root.left);
		printLeaf(root.right);
		
	}

	private static void printLeft(Node root) {
		if(root == null) return;
		
		if(root.left!=null){
			result.add(root.data);
			System.out.print(root.data+" ");
			printLeft(root.left);
		}
			
		else if(root.right!=null){
			result.add(root.data);
			System.out.print(root.data+" ");
			printLeft(root.right);
		}
	}
	

}
