package Group1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberSystem {

	public static void main(String[] args) {
		NumberSystem numberSystem = new NumberSystem();
		System.out.println(numberSystem.getNthTerm());
	}

	String getNthTerm() {
		System.out.print("Enter n: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		List<String> numberList = new ArrayList<String>();
		numberList.add("3");
		numberList.add("4");
		for (int i = 0; i < numberList.size(); i++) {
			if (numberList.size() >= n)
				break;
			numberList.add(numberList.get(i) + "3");
			numberList.add(numberList.get(i) + "4");
		}

		return n + "th term -> " + numberList.get(n - 1);

	}

}
