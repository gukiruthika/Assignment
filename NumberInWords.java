package Group1;

import java.util.Scanner;

public class NumberInWords {

	public static void main(String[] args) {
		NumberInWords task = new NumberInWords();
		task.process();

	}

	void process() {
		Scanner scan = new Scanner(System.in);
		boolean check;
		do {
			System.out.print("Enter a number : ");
			String number = scan.nextLine();

			check = number.matches("[0-9]||[1-9][0-9]||[1-9][0-9][0-9]");
			if (check)
				System.out.println(getInWords(number));

			else
				System.out.println("Invalid input");
		} while (!check);
		scan.close();
	}

	String getInWords(String number) {
		if (number.length() == 1) {
			if (number.equals("0"))
				return "Zero";
			return getUnitNumber(number);
		}
		if (number.length() == 2) {
			if (number.charAt(0) == '1') {
				return getTeenNumber(number);
			} else {
				return getTyNumber(number.substring(0, 1)) + getUnitNumber(number.substring(1));
			}
		}
		if (number.substring(1).equals("00"))
			return getUnitNumber(number.substring(0, 1)) + " hundred";
		return getUnitNumber(number.substring(0, 1)) + " hundred and " + getInWords(number.substring(1));
	}

	String getTyNumber(String number) {
		switch (number) {
		case "2":
			return "Twenty ";
		case "3":
			return "Thirty ";
		case "4":
			return "Forty ";
		case "5":
			return "Fifty ";
		case "6":
			return "Sixty ";
		case "7":
			return "Seventy ";
		case "8":
			return "Eighty ";
		case "9":
			return "Ninety ";
		default:
			return "";
		}
	}

	String getUnitNumber(String number) {
		switch (number) {
		case "1":
			return "One";
		case "2":
			return "Two";
		case "3":
			return "Three";
		case "4":
			return "Four";
		case "5":
			return "Five";
		case "6":
			return "Six";
		case "7":
			return "Seven";
		case "8":
			return "Eight";
		case "9":
			return "Nine";
		default:
			return "";
		}
	}

	String getTeenNumber(String number) {
		switch (number) {
		case "11":
			return "Eleven";
		case "12":
			return "Twelve";
		case "13":
			return "Thirteen";
		case "14":
			return "Fourteen";
		case "15":
			return "Fifteen";
		case "16":
			return "Sixteen";
		case "17":
			return "Seventeen";
		case "18":
			return "Eighteen";
		case "19":
			return "Nineteen";
		case "10":
			return "Ten";
		default:
			return "";
		}
	}

}
