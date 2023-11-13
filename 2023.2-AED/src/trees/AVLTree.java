package trees;

public class AVLTree implements BinaryTree {

	private Node root;
	private int size;
	
	@Override
	public void add(int value) {
		this.root = addInternal(value, this.root);
	}
	
	private Node addInternal(int value, Node node) {
		if (node == null) {
			return new Node(value);
		} else if (value < node.value) {
			node.left = addInternal(value, node.left);
		} else if (value > node.value) {
			node.right = addInternal(value, node.right);
		}
		return node;
	}

	@Override
	public boolean contains(int element) {
		return false;
	}

	@Override
	public void remove(int element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preOrderTraversal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inOrderTraversal() {
		
	}

	@Override
	public void postOrderTraversal() {
		
	}
	
	private class Node {
		
		private static final int RIGHT_HEAVY = 1;
		private static final int BALANCED = 0;
		private static final int LEFT_HEAVY = -1;
		
		private int balance;
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
			this.balance = BALANCED;
		}
	}
	
}
