public class AVLTree {

//	private Node root;
//	private boolean increase;
//	
//	public void add(int value) {
//		increase = false;
//		this.root = internalAdd(value, this.root);
//	}
//	
//	private Node internalAdd(int value, Node node) {
//		if (node == null) {
//			increase = true;
//			 return new Node(value);
//		} else if (value < node.value) {
//			node.left = internalAdd(value, node.left);
//			if (increase) {
//				decrementBalance(node);
//				if (node.balance < Node.LEFT_HEAVY) {
//					increase = false;
//					return rebalanceLeft(node);
//				}
//			}
//			return node;
//		} else if (value > node.value) {
//			node.right = internalAdd(value, node.right);
//		}
//		
//		return node;
//	}
//	
//	private class Node {
//
//		public static final int LEFT_HEAVY = -1;
//		public static final int BALANCED = 0;
//		public static final int RIGHT_HEAVY = 1;
//
//		private int value;
//		private Node left;
//		private Node right;
//		private int balance;
//		
//		public Node(int value) {
//			balance = BALANCED;
//		}
//		
//	}
	
}
