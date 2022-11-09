package session;

import java.util.Scanner;

public class MergeSortImplementation {

	int inversionCount;

	public static void main(String[] args) {
		new MergeSortImplementation().process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int length = scan.nextInt();
		int[] arr = new int[length];
		System.out.println("Enter the elements");
		for (int i = 0; i < length; i++)
			arr[i] = scan.nextInt();
		scan.close();
		sort(arr, 0, length - 1);
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\nInversion Count -> " + inversionCount);

	}

	private void sort(int arr[], int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private void merge(int arr[], int start, int mid, int end) {
		int firstLength = mid - start + 1;
		int lastLength = end - mid;
		int first[] = new int[firstLength];
		int last[] = new int[lastLength];

		for (int i = 0; i < firstLength; ++i)
			first[i] = arr[start + i];
		for (int j = 0; j < lastLength; ++j)
			last[j] = arr[mid + 1 + j];

		int i = 0, j = 0, k = start;
		while (i < firstLength && j < lastLength) {
			if (first[i] <= last[j]) {
				arr[k] = first[i];
				i++;
			} else {
				arr[k] = last[j];
				inversionCount++;
				j++;
			}
			k++;
		}
		while (i < firstLength) {
			arr[k] = first[i];
			i++;
			k++;
		}
		while (j < lastLength) {
			arr[k] = last[j];
			j++;
			k++;
		}
	}

}
