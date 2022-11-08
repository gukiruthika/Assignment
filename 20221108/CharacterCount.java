package session;

import java.util.Scanner;

public class CharacterCount {

	public static void main(String[] args) {
		new CharacterCount().process();

	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		printResult(input);
	}

	private void printResult(String input) {
		char previous='_';
		int count=0;
		for (int i = 0; i < input.length(); i++) {
			if(previous!=input.charAt(i)) {
				if(count>1)
					System.out.print(count);
				previous=input.charAt(i);
				count=1;
				System.out.print(previous);
			}
			else
				count++;
		}
		if(count>1)
			System.out.print(count);
	}
	}
}
