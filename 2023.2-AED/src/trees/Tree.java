package trees;

public interface Tree { 
	
	// Adiciona um elemento na �rvore
	public void add(int element);
	
	// Verifica se um elemento est� presente na �rvore
	public boolean contains(int element);
	
	// Remove um elemento da �rvore
	public void remove(int element);
}
