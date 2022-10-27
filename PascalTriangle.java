package Group1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle task = new PascalTriangle();
		task.display();
	}

	void display() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int number = scan.nextInt();
		scan.close();
		System.out.println(generate(number));
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascal = new ArrayList<>();
		for (int line = 1; line <= numRows; line++) {
			List<Integer> row = new ArrayList<>();
			int number = 1;
			for (int i = 1; i <= line; i++) {
				row.add(number);
				number = number * (line - i) / i;
			}
			pascal.add(row);
		}
		return pascal;
	}

}
