public class AVLTreeKoff {

	private Node root;
	private boolean increase;
	
	public void add(int value){
		this.increase = false;
		root = addInternal(value, this.root);
	}
	
	private Node addInternal(int value, Node node){
		if(node == null){
			this.increase = true;
			return new Node(value);
		} else if (value < node.value) {
			node.left = addInternal(value, node.left);
			if(this.increase){
				decrementBalance(node);
				if(node.balance < Node.LEFT_HEAVY){
					this.increase = false;
					return rebalanceLeft(node);
				}
			}
			return node; // Re-balance not needed
		} else if (value > node.value) {
			node.right = addInternal(value, node.right);
			if(this.increase){
				incrementBalance(node);
				if(node.balance > Node.RIGHT_HEAVY){
					this.increase = false;
					return rebalanceRight(node);
				}
			}
			return node; // Re-balance not needed
		}
		
		return node;
	}
	
	private Node rebalanceLeft(Node node){
		//Obtain reference to left child
		Node leftChild = node.left;
		//see whether left-right heavy
		if(leftChild.balance > Node.BALANCED){
			//Obtain reference to left-right child.
			Node leftRightChild = leftChild.right;
			/*
			 * Adjust the balances to be their new values after the rotations are performed
			 */
			if(leftRightChild.balance < Node.BALANCED){
				leftChild.balance = Node.BALANCED;
				leftRightChild.balance = Node.BALANCED;
				node.balance = Node.RIGHT_HEAVY;
			} else if (leftRightChild.balance > Node.BALANCED){
				leftChild.balance = Node.LEFT_HEAVY;
				leftRightChild.balance = Node.BALANCED;
				node.balance = Node.BALANCED;
			} else {
				//Left-Right balanced case
				leftChild.balance = Node.BALANCED;
				node.balance = Node.BALANCED;
			}
			//Perform left rotation
			node.left = rotateLeft(leftChild);
		} else {	
			//Left-left case
			leftChild.balance = Node.BALANCED;
			node.balance = Node.BALANCED;
		}
		//now rotate the local root right
		return rotateRight(node);
	}
	
	private Node rebalanceRight(Node localRoot){
		//Obtain reference to right child
		Node rightChild = localRoot.right;
		//see whether right-left heavy
		if(rightChild.balance < Node.BALANCED){
			//Obtain reference to right-left child.
			Node RightLeftChild = rightChild.left;
			/*
			 * Adjust the balances to be their new values after the rotations are performed
			 */
			if(RightLeftChild.balance < Node.BALANCED){
				rightChild.balance = Node.RIGHT_HEAVY;
				RightLeftChild.balance = Node.BALANCED;
				localRoot.balance = Node.BALANCED;
			} else if (RightLeftChild.balance > Node.BALANCED){
				rightChild.balance = Node.BALANCED;
				RightLeftChild.balance = Node.BALANCED;
				localRoot.balance = Node.LEFT_HEAVY;
			} else {
				//Right-Left balanced case
				rightChild.balance = Node.BALANCED;
				localRoot.balance = Node.BALANCED;
			}
			//Perform right rotation
			localRoot.right = rotateRight(rightChild);
		} else {	
			//Right-right case
			rightChild.balance = Node.BALANCED;
			localRoot.balance = Node.BALANCED;
		}
		//now rotate the local root left
		return rotateLeft(localRoot);
	}
	
	private void decrementBalance(Node node){
		node.balance--;
		if(node.balance == Node.BALANCED){
			//If now balanced, overall height has not this.increased
			this.increase = false;
		}
	}
	
	private void incrementBalance(Node node){
		node.balance++;
		if(node.balance == Node.BALANCED){
			//If now balanced, overall height has not this.increased
			this.increase = false;
		}
	}
	
	private Node rotateRight(Node node){
		Node temp = node.left;
		node.left = temp.right;
		temp.right = node;
		return temp;
	}
	
	private Node rotateLeft(Node node){
		Node temp = node.right;
		node.right = temp.left;
		temp.left = node;
		return temp;
	}
	
	public void preOrderTraversal() {
		internalPreOrderTraversal(this.root);
	}
	
	private void internalPreOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			internalPreOrderTraversal(node.left);
			internalPreOrderTraversal(node.right);
		}
	}

	public void inOrderTraversal() {
		internalInOrderTraversal(this.root);
	}
	
	private void internalInOrderTraversal(Node node) {
		if (node != null) {
			internalInOrderTraversal(node.left);
			System.out.print(node.value + " ");
			internalInOrderTraversal(node.right);
		}
	}

	public void postOrderTraversal() {
		internalPostOrderTraversal(this.root);
	}
	
	private void internalPostOrderTraversal(Node node) {
		if (node != null) {
			internalPostOrderTraversal(node.left);
			internalPostOrderTraversal(node.right);
			System.out.print(node.value + " ");
		}
	}
	
	private static class Node {

		public static final int LEFT_HEAVY = -1;
		public static final int BALANCED = 0;
		public static final int RIGHT_HEAVY = 1;
		
		private int value;
		private Node left;
		private Node right;
		private int balance;
		
		public Node(int value) {
			this.value = value;
			balance = BALANCED;
		}
		
	}

	public static void main(String[] args) {
		AVLTreeKoff avlt = new AVLTreeKoff();
		avlt.add(30);
		avlt.add(40);
		avlt.add(15);
		avlt.add(25);
		avlt.add(90);
		avlt.add(80);
		avlt.add(70);
		avlt.add(85);
		avlt.add(15);
		avlt.add(72);
		avlt.inOrderTraversal();
	}
	
}
