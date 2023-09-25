package linear_structures;

public class Test {

	public static void main(String[] args) {
//		List lista = new LinkedList();
//		
//		lista.add(10);
//		lista.add(20);
//		lista.add(30);
//		
//		System.out.println(lista);
//		
//		lista.add(100, 1);
//		
//		System.out.println(lista);
		
//		lista.remove(0);
//		
//		System.out.println(lista);
//		
//		lista.remove(1);
//		
//		System.out.println(lista);
		
		
		Stack minhaPilha = new LinkedStack();
	
		minhaPilha.push(10);
		minhaPilha.push(2);
		minhaPilha.push(7);
		minhaPilha.push(12);
		minhaPilha.push(8);
		
		minhaPilha.pop();
		
		System.out.println(minhaPilha.pop());
	}
	
}
