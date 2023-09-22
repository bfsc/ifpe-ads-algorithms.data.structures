package trees;

public class MainClass {

	public static void main(String[] args) {
		BinaryTree bst = new BinarySearchTree();
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(3);
		bst.add(8);
		bst.add(13);
		
		bst.preOrderTraversal();
		System.out.println();
		bst.inOrderTraversal();
		System.out.println();
		bst.postOrderTraversal();
	}
	
}
