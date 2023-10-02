package linear_structures;

public class ArrayList implements List {

	private int[] array;
	private int size;
	
	public ArrayList() {
		this.array = new int[10];
		this.size = 0;
	}
	
	public int get(int index) {
		if (index >= this.size || index < 0) {
			throw new RuntimeException("Invalid index");
		}
		return this.array[index];
	}

	public void add(int element) {
		if (this.size >= this.array.length) {
			duplicateArray();
		}
		this.array[this.size] = element;
		this.size++;
	}

	public void add(int element, int index) {
		
	}
	
	private void duplicateArray() {
		int newArraySize = this.array.length * 2;
		int[] newArray = new int[newArraySize]; 
		for (int i = 0; i < this.array.length; i++) {
			newArray[i] = this.array[i];
		}
		this.array = newArray;
	}

	public void remove(int index) {
		if (index >= this.size || index < 0) {
			throw new RuntimeException("Invalid index");
		}
		
		for (int i = index; i < this.size - 1; i++) {
			this.array[i] = this.array[i + 1];
		}
		
		this.size--;
	}

	public boolean contains(int element) {
		for (int item : this.array) {
			if (item == element) {
				return true;
			}
		}
		return false;
	}
	
	public void replace(int element, int index) {
		
	}

	public int getSize() {
		return this.size;
	}
	
	public String toString() {
		String string = "[";
		for (int i = 0; i < this.size; i++) {
			string += this.array[i] + ",";
		}
		return string += "]";
	}
	
}
