package Group1;

import java.util.Scanner;
import java.util.Stack;

public class SingleAppearance {

	public static void main(String[] args) {
		SingleAppearance task = new SingleAppearance();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n = scan.nextInt();
		int element;
		Stack<Integer> list = new Stack<>();
		System.out.println("Enter elements");
		while (n-- > 0) {
			element = scan.nextInt();
			if (list.contains(element)) {
				list.pop();
			} else {
				list.add(element);
			}
		}
		scan.close();

		System.out.println(list.pop());
	}

}
