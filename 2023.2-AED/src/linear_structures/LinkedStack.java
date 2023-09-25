package linear_structures;

public class LinkedStack implements Stack {
	
	private Node top;
	private int size;
	
	public void push(int element) {
		if (top == null) {
			this.top = new Node(element);
		} else {
			this.top = new Node(element, this.top);
		}
		this.size++;
	}

	public int peek() {
		if(this.top == null) {
			throw new RuntimeException("The stack is empty.");
		}
		
		return this.top.getValue();
	}

	public int pop() {
		if(this.top == null) {
			throw new RuntimeException("The stack is empty.");
		}
				
		int oldTopValue = this.top.getValue();
		this.top = this.top.getDown();
		this.size--;
		return oldTopValue; 
	}

	public int getSize() {
		return this.size;
	}
	
	private class Node {
		
		private int value;
		private Node down;
		
		public Node(int value, Node down) {
			super();
			this.value = value;
			this.down = down;
		}
		
		public Node(int value) {
			super();
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
		
		public Node getDown() {
			return down;
		}
		
		public void setDown(Node down) {
			this.down = down;
		}
		
	}

}
