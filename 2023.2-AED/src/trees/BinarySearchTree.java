package trees;

public class BinarySearchTree implements BinaryTree {
	
	private Node root;

	public void add(int value) {
		this.root = internalAdd(value, this.root);
	}
	
	private Node internalAdd(int value, Node node) {
		if (node == null) {
			 return new Node(value);
		} else if (value < node.getValue()) {
			node.setLeft(internalAdd(value, node.getLeft()));
		} else if (value > node.getValue()) {
			node.setRight(internalAdd(value, node.getRight()));
		}
		
		return node;
	}

	public boolean contains(int element) {
		return internalContains(element, this.root);
	}
	
	private boolean internalContains(int element, Node node) {
		if (node != null) {
			if (element == node.getValue()) {
				return true;
			} else if (element < node.getValue()) {
				return internalContains(element, node.getLeft());
			} else {
				return internalContains(element, node.getRight());
			}
		}
		
		return false;
	}

	public void remove(int element) {
		this.root = internalRemove(element, this.root);
	}
	
	private Node internalRemove(int element, Node node) {
		if (node != null) {
			if (element == node.getValue()) {
				if (node.getLeft() == null && node.getRight() == null) {
					return null;
				} else if (node.getLeft() != null && node.getRight() != null) {
					Node inOrderPredecessor = node.getLeft();
					while (inOrderPredecessor.getRight() != null) {
						inOrderPredecessor = inOrderPredecessor.getRight();
					}
					node.setValue(inOrderPredecessor.getValue());
					node.setLeft(internalRemove(node.getValue(), node.getLeft()));
					return node;
				} else {
					return node.getRight() == null ? node.getLeft() : node.getRight();
				}
			} else if (element < node.getValue()) {
				node.setLeft(internalRemove(element, node.getLeft()));
			} else {
				node.setRight(internalRemove(element, node.getRight()));
			}
		}
		
		return node;
	}

	public void preOrderTraversal() {
		internalPreOrderTraversal(this.root);
	}
	
	private void internalPreOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.getValue() + " ");
			internalPreOrderTraversal(node.getLeft());
			internalPreOrderTraversal(node.getRight());
		}
	}

	public void inOrderTraversal() {
		internalInOrderTraversal(this.root);
	}
	
	private void internalInOrderTraversal(Node node) {
		if (node != null) {
			internalInOrderTraversal(node.getLeft());
			System.out.print(node.getValue() + " ");
			internalInOrderTraversal(node.getRight());
		}
	}

	public void postOrderTraversal() {
		internalPostOrderTraversal(this.root);
	}
	
	private void internalPostOrderTraversal(Node node) {
		if (node != null) {
			internalPostOrderTraversal(node.getLeft());
			internalPostOrderTraversal(node.getRight());
			System.out.print(node.getValue() + " ");
		}
	}
	
	private class Node {
		
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
		
	}
	
}
