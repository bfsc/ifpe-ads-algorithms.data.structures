import java.util.Random;

import linear_structures.ArrayList;
import linear_structures.LinkedList;
import linear_structures.List;
import trees.BinarySearchTree;
import trees.BinaryTree;

public class PerformanceTest {

	public static void main(String[] args) {
		List ll = new LinkedList();
		List al = new ArrayList();
		BinaryTree bst = new BinarySearchTree();
		
		final int SIZE = 100000000;
		Random random = new Random();
		int lastNumber = 0;
		for(int i = 0; i < SIZE; i++) {
			int number = random.nextInt(SIZE);
//			int number = i;
			lastNumber = number;
			ll.add(number);
			al.add(number);
//			bst.add(number);
		}
		
		System.out.println("TERMINOU O PREENCHIMENTO");
		
//		final int numberToSearchFor = random.nextInt(SIZE);
		final int numberToSearchFor = lastNumber;
		
		long startLl = System.currentTimeMillis();
//		ll.contains(numberToSearchFor);
		ll.get(SIZE - 1);
		long endLl = System.currentTimeMillis();
		long llDuration = endLl - startLl;
		System.out.println("LL DURATION: " + llDuration);
		
		long startAl = System.currentTimeMillis();
//		al.contains(numberToSearchFor);
		al.get(SIZE - 1);
		long endAl = System.currentTimeMillis();
		long alDuration = endAl - startAl;
		System.out.println("AL DURATION: " + alDuration);
		
//		long startBst = System.currentTimeMillis();
//		bst.contains(numberToSearchFor);
//		long endBst = System.currentTimeMillis();
//		long bstDuration = endBst - startBst;
//		System.out.println("BST DURATION: " + bstDuration);	
	}
	
}
