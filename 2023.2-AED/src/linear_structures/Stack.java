package linear_structures;

public interface Stack {
	
	// Adiciona um elemento no topo
	public void push(int element);
	
	// Obtém o elemento do topo, sem retirá-lo
	public int peek();
	
	// Obtém o elemento do topo e retira-o
	public int pop();

	// Obtém o elemento do topo e retira-o
	public int getSize();
}

