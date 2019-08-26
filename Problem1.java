//Question  : Print the borders of the Tree.


public class CC8 {
	
	
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
		inOrder(root);
		
		

	}

	private static void inOrder(Node root) {
		// TODO Auto-generated method stub
		
	}

	public static void generateTree(Node root) {
												          //       	       1 
 		root.left = new Node(2);										          //           /            \
		root.right = new Node(3);										          //         2              3
		root.left.left = new Node(4); root.right.left = new Node(6);    		  //        /   \          /    \
		root.left.right = new Node(5); root.right.right = new Node(7);             //      4     5        6       7
		root.left.left.left = new Node(4); root.right.right.left = new Node(6);    //      / \  /   \     /  \    /  \
		root.left.left.right= new Node(5); root.right.right.right = new Node(7);   //     8   9 10  11   12  13  14   15
	
	}
	
	
	
	
	

}
