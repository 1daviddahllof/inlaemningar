package oooooooo;

public class Selection_sort {

	public static void main(String[] args) {
		int[] l = {1, 3 ,1 ,3, 6, 3 ,2 ,9 , 3 ,9};
		selectionSort(l);
		for (int x = 0; x<10; x++) {
			System.out.println(l[x]);
		}
	}
//	det verkar som om selectionsort och insertionsort är hopblandade men vad vet jag
//	jag tror alltså att det här egentligen är insertionsort.
	public static void selectionSort(int[] array) {

		int comparisons = 0;
		int swaps = 0;

		for (int j = 1; j < array.length; j++) {
			for (int i = j; i > 0; i--) {
				comparisons++;
				if (array[i]<array[i-1]) {
					int temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
				}
			}
		}

		System.out.println("Comparisons: " + comparisons);
		System.out.println("Swaps: " + swaps);

	}
}
