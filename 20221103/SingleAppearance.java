package Group1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
		List<Integer> list = new LinkedList<>();
		System.out.println("Enter elements");
		while (n-- > 0) {
			element = scan.nextInt();
			if (list.contains(element)) {
				list.remove((Integer) element);
			} else {
				list.add(element);
			}
		}
		scan.close();

		System.out.println(list.get(0));
	}

}
