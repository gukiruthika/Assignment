package Group1;

import java.util.Scanner;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix task = new LongestCommonPrefix();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of Strings ");
		int n = scan.nextInt();
		scan.nextLine();
		int minLength=Integer.MAX_VALUE;
		String[] strings = new String[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter String " + (i+1) + " : ");
			strings[i] = scan.next();
			minLength = Math.min(minLength, strings[i].length());
		}
		System.out.println(getCommonPrefix(strings,minLength));
		scan.close();

	}

	private String getCommonPrefix(String[] strings, int minLength) {
		String commonPrefix = "";
		Loop: for (int i = 0; i < minLength; i++) {
			for (int j = 1; j < strings.length; j++) {
				if (strings[0].charAt(i) != strings[j].charAt(i))
					break Loop;
			}
			commonPrefix += strings[0].charAt(i);
		}
		return commonPrefix;
	}
}
