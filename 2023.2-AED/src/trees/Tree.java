package trees;

public interface Tree { 
	
	// Adiciona um elemento na árvore
	public void add(int element);
	
	// Verifica se um elemento está presente na árvore
	public boolean contains(int element);
	
	// Remove um elemento da árvore
	public void remove(int element);
}
