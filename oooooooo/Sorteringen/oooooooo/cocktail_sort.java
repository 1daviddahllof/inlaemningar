package oooooooo;

public class cocktail_sort {

	public static void main(String[] args) {
		int[] l = {1, 3 ,1 ,3, 6, 3 ,2 ,9 , 3};
		cocktailSort(l);
		for (int x = 0; x<9; x++) {
			System.out.println(l[x]);
		}

	}

	public static void cocktailSort(int[] array) {
		int comparisons = 0;
		int swaps = 0;
		boolean hasSwapped = true;
		for (int j = 0; j < array.length && hasSwapped; j+=2) {
			hasSwapped = false;
			int tos = array.length - 1 - j;
			for (int i = tos; i > 0; i--) {
				comparisons++;
				if (array[i-1] > array[i]) {
					int temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
					swaps++;
					hasSwapped = true;
				}
			}
			for (int i = 0; i < tos; i++) {
				comparisons++;
				if (array[i] > array[i+1]) {
					int temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
					swaps++;
					hasSwapped = true;
				}
			}
		}
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Swaps: " + swaps);
	}
}
