package session;

import java.util.Scanner;
import java.util.Stack;

public class StringSelection {

	public static void main(String[] args) {
		new StringSelection().process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n = scan.nextInt();
		scan.nextLine();
		String[] words = new String[n];
		System.out.println("Enter elements");
		for (int i = 0; i < words.length; i++)
			words[i] = scan.nextLine();

		scan.close();
		getSorted(words);
	}

	private void getSorted(String[] words) {
		int min;
		String temp;
		for (int i = 0; i < words.length; i++) {
			min = i;
			for (int j = i + 1; j < words.length; j++) {
				if (words[min].compareTo(words[j]) > 0)
					min = j;
			}
			if(min!=i) {
			temp = words[i];
			words[i] = words[min];
			words[min] = temp;
			}
			System.out.println(words[i]);
		}
	}

}
