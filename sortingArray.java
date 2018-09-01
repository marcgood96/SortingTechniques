
public class sortingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] { 34, 5, 3, 7, 9 };
		System.out.println("Array before: " + printArray(array));

		int[] bubbleArray = array.clone();
		System.out.println("Array after Bubble Sort: " + printArray(bubbleSort(bubbleArray)));

		int[] selectionArray = array.clone();
		System.out.println("Array after Selection Sort: " + printArray(bubbleSort(selectionArray)));

		int[] insertionArray = array.clone();
		System.out.println("Array after Insertion Sort: " + printArray(insertionSort(insertionArray)));

		int[] mergeArray = array.clone();
		System.out.println("Array after Merge Sort: " + printArray(mergeSort(mergeArray)));

		int[] quickArray = array.clone();
		System.out.println("Array after Quick Sort: " + printArray(quickSort(quickArray)));

	}

	public static int[] quickSort(int[] arr) {

		return quickSortHelper(0, arr.length - 1, arr);
	}

	public static int[] quickSortHelper(int start, int end, int[] arr) {

		int x = start;
		int y = end;
		
		int pivot = arr[start + (end - start) / 2];
		 
		while (x <= y) {

			while (arr[x] < pivot) {
				x++;
			}
			while (arr[y] > pivot) {
				y--;
			}
			if (x <= y) {
				swap(x, y, arr);
				
				x++;
				y--;
			}
		}
		
		if (start < y)
			quickSortHelper(start, y, arr);
		if (x < end)
			quickSortHelper(x, end, arr);
		return arr;
	}

	public static int[] mergeSort(int[] arr) {
		return mergeSortHelper(0, arr.length - 1, arr);

	}

	public static int[] mergeSortHelper(int lowerIndex, int higherIndex, int[] arr) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			mergeSortHelper(lowerIndex, middle, arr);
			mergeSortHelper(middle + 1, higherIndex, arr);
			return mergeParts(lowerIndex, middle, higherIndex, arr, new int[arr.length]);
		}
		return new int[1];
	}

	public static int[] mergeParts(int start, int mid, int end, int[] arr, int[] tempArray) {

		for (int i = start; i <= end; i++) {
			tempArray[i] = arr[i];
		}
		int x = start;
		int y = mid + 1;
		int z = start;
		while (x <= mid && y <= end) {
			if (tempArray[x] <= tempArray[y]) {
				arr[z] = tempArray[x];
				x++;
			} else {
				arr[z] = tempArray[y];
				y++;
			}
			z++;
		}
		while (x <= mid) {
			arr[z] = tempArray[x];
			z++;
			x++;
		}
		return arr;

	}

	public static int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int x = i; x > 0; x--) {
				if (arr[x] < arr[x - 1]) {
					swap(x, x - 1, arr);
				}

			}
		}
		return arr;
	}

	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			swap(i, getLowestFromIndex(i, arr), arr);
		}

		return arr;
	}

	public static void swap(int val1, int val2, int[] array) {
		int temp = array[val1];

		array[val1] = array[val2];
		array[val2] = temp;
	}

	public static int getLowestFromIndex(int ind, int[] arr) {
		int lowestValByInd;
		lowestValByInd = ind;
		for (int i = ind; i < arr.length; i++) {
			if (arr[i] < arr[lowestValByInd]) {
				lowestValByInd = i;
			}
		}
		return 0;
	}

	public static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int x = 0; x < arr.length - 1; x++) {
				if (arr[x] > arr[x + 1]) {
					swap(x, arr);
				}
			}
		}

		return arr;
	}

	public static void swap(int val1, int[] array) {
		int temp = array[val1];
		int val2 = val1 + 1;
		array[val1] = array[val2];
		array[val2] = temp;
	}

	public static String printArray(int[] arr) {
		String s = ""+arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			s = s + " , " + arr[i];
		}
		return s;
	}

}
