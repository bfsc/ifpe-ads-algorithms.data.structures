package linear_structures;

public interface List {

	//Obt�m um elemento em uma posi��o espec�fica
	public int get(int index);
	
	//Adiciona um elemento no fim da lista
	public void add(int element);
	
	//Adiciona um elemento em qualquer posi��o da lista
	public void add(int element, int index);
	
	//Remove um elemento em uma posi��o espec�fica
	public void remove(int index);
	
	//Substitui um elemento da lista por outro
	public void replace(int element, int index);
	
	//Obt�m o tamanho da lista
	public int getSize();
	
	public boolean contains(int element);
}

