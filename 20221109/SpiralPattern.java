package assignments;

import java.util.Scanner;

public class SpiralPattern {

	public static void main(String[] args) {
		new SpiralPattern().process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n");
		int n = scan.nextInt();
		scan.close();
		printSpiralPattern(n);
	}

	private void printSpiralPattern(int n) {
		int[][] matrix = new int[n][n];
		int value = 1, upLimit = 0, leftLimit = 0, downLimit = n - 1, rightLimit = n - 1, direction = 0;
		while (upLimit <= downLimit && leftLimit <= rightLimit) {
			if (direction == 0) {
				for (int i = leftLimit; i <= rightLimit; i++)
					matrix[upLimit][i] = value++;
				upLimit++;
				direction++;
			} else if (direction == 1) {
				for (int i = upLimit; i <= downLimit; i++)
					matrix[i][rightLimit] = value++;
				rightLimit--;
				direction++;
			} else if (direction == 2) {
				for (int i = rightLimit; i >= leftLimit; i--)
					matrix[downLimit][i] = value++;
				downLimit--;
				direction++;
			} else {
				for (int i = rightLimit; i >= upLimit; i--)
					matrix[i][leftLimit] = value++;
				leftLimit++;
				direction++;
			}
			if (direction == 4)
				direction = 0;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
