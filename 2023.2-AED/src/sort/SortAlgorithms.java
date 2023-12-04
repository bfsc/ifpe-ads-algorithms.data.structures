package sort;

import java.util.Random;

public class SortAlgorithms {

	public static void bubbleSort(int[] array) {
		boolean swapped = true;
		while(swapped) {
			swapped = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i+1]) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					swapped = true;
				}
			}
		}
	}
	
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int smallest = array[i];
			int smallestIndex = i;
			for (int j = i; j < array.length; j++) {
				if (array[j] < smallest) {
					smallest = array[j];
					smallestIndex = j;
				}
			}
			int temp = array[i];
			array[i] = smallest;
			array[smallestIndex] = temp;
		}
	}
	
	public static void mergeSort(int[] array) {
		sort(array);
	}
	
	public static void sort(int[] array) {
		if (array.length > 1) {
			int leftArraySize = array.length / 2;
			int[] leftArray = new int[leftArraySize];
			for (int i = 0; i < leftArraySize; i++) {
				leftArray[i] = array[i];
			}
			
			int rightArraySize = array.length - leftArraySize;
			int[] rightArray = new int [rightArraySize];
			for (int i = 0; i < rightArray.length; i++) {
				rightArray[i] = array[leftArraySize + i];
			}
			
			sort(leftArray);
			sort(rightArray);
			merge(leftArray, rightArray, array);
		}
	}
	
	public static void merge(int[] leftArray, int[] rightArray, int[] array) {
		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		int arrayIndex = 0;
		
		while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
			if (leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) {
				array[arrayIndex] = leftArray[leftArrayIndex];
				leftArrayIndex++;
			} else {
				array[arrayIndex] = rightArray[rightArrayIndex];
				rightArrayIndex++;
			}
			
			arrayIndex++;
		}
		
		while (leftArrayIndex < leftArray.length) {
			array[arrayIndex++] = leftArray[leftArrayIndex++];
		}
		
		while(rightArrayIndex < rightArray.length) {
			array[arrayIndex++] = rightArray[rightArrayIndex++];
		}
	}
	
//	public static void main(String[] args) {
//		int[] randomArray = { 5, 12, 34, 18, 27, 9, 42, 3, 16, 20 };
//		mergeSort(randomArray);
//		for (int value : randomArray) {
//			System.out.print(value + ", ");
//		}
//	}
	
	public static void main(String[] args) {
//		int[] randomArray = { 5, 12, 34, 18, 27, 9, 42, 3, 16, 20 };
		
		final int ARRAY_SIZE = 1000000000;
		int[] randomArray = new int[ARRAY_SIZE];
		Random random = new Random();
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = random.nextInt(ARRAY_SIZE);
		}
		System.out.println("FIM DA CRIAÇÃO DO ARRAY");
		
		long start = System.currentTimeMillis();
		mergeSort(randomArray);
//		selectionSort(randomArray);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
//		for (int i : randomArray) {
//			System.out.print(i + ", ");
//		}
	}
	
}
