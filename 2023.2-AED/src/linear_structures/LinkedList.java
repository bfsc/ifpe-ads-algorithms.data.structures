package linear_structures;

public class LinkedList implements List {

	private Node head;
	private Node tail;
	private int size;
	
	public int get(int index) {
		Node node = this.getInternal(index);
		
		if(node != null) {
			return node.getValue();
		}
		
		throw new RuntimeException("Invalid index");
	}
	
	private Node getInternal(int index) {
		if (index < 0 || index > this.size) {
			throw new RuntimeException("Invalid index");
		}
				
		int currentIndex = 0;
		for (Node currentNode = this.head; currentNode != null; 
				currentNode = currentNode.getNext()) {
			if (currentIndex == index) {
				return currentNode;
			}
			currentIndex++;
		}
		
		throw new RuntimeException("Invalid index");
	}

	public void add(int element) {
		if (this.head == null){
			this.head = new Node(element);
			this.tail = this.head;
		} else {
			Node newNode = new Node(element);
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
		
		this.size++;
	}

	public void add(int element, int index) {
		Node node = this.getInternal(index - 1);
		Node oldNext = node.getNext();
		Node newNode = new Node(element);
		node.setNext(newNode);
		newNode.setNext(oldNext);
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replace(int element, int index) {
		// TODO Auto-generated method stub
		
	}

	public int getSize() {
		return this.size;
	}

	public String toString() {
		String string = "[";
		for (Node currentNode = this.head; currentNode != null; 
				currentNode = currentNode.getNext()) {
			string += currentNode.getValue() + ", ";
		}
		return string += "]";
	}
	
	private class Node{
		
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	
}
