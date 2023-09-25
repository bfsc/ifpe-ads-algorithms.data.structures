package linear_structures;

public interface Stack {
	
	// Adiciona um elemento no topo
	public void push(int element);
	
	// Obt�m o elemento do topo, sem retir�-lo
	public int peek();
	
	// Obt�m o elemento do topo e retira-o
	public int pop();

	// Obt�m o elemento do topo e retira-o
	public int getSize();
}

