package Group1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfDays2 {

	public static void main(String[] args) {
		NumberOfDays2 numberOfDays = new NumberOfDays2();
		numberOfDays.getDate();
	}

	boolean isLeapYear(int year) {
		if (year % 400 == 0)
			return true;

		if (year % 4 == 0 && year % 100 != 0)
			return true;

		return false;
	}

	void getDate() {
		int fromDay, fromMonth, fromYear, toDay, toMonth, toYear;
		String fromDate = getInput("starting date");
		String[] fromArray = fromDate.split("/");
		fromDay = Integer.valueOf(fromArray[0]);
		fromMonth = Integer.valueOf(fromArray[1]);
		fromYear = Integer.valueOf(fromArray[2]);
		String toDate = getInput("ending date");
		String[] toArray = toDate.split("/");
		toDay = Integer.valueOf(toArray[0]);
		toMonth = Integer.valueOf(toArray[1]);
		toYear = Integer.valueOf(toArray[2]);
		double noOfDays = getNumberOfDays(toDay, toMonth, toYear) - getNumberOfDays(fromDay, fromMonth, fromYear);
		System.out.println("\nNumber of Days -> " + noOfDays);
	}

	double getNumberOfDays(double day, int month, double year) {
		double noOfDays = getYearDays(year - 1) + getMonthDays(month - 1) + day;
		if (month > 2 & isLeapYear((int) year))
			noOfDays += 1;
		return noOfDays;
	}

	double getYearDays(double year) {
		double noOfDays = 0;
		noOfDays = (year * 365) + (Math.ceil(year * 0.24)) + (Math.round(year / 400))
				+ (isLeapYear((int) year) ? 1 : 0);
		return noOfDays;
	}

	double getMonthDays(int month) {
		switch (month) {
		case 1:
			return 31;
		case 2:
			return 59;
		case 3:
			return 90;
		case 4:
			return 120;
		case 5:
			return 151;
		case 6:
			return 181;
		case 7:
			return 212;
		case 8:
			return 243;
		case 9:
			return 273;
		case 10:
			return 304;
		case 11:
			return 334;
		}
		return 0;
	}

	public String getInput(String field) {
		Scanner scan = new Scanner(System.in);
		String input;
		System.out.print("\nEnter " + field + "(dd/mm/yyyy) : ");
		input = scan.nextLine();
		Pattern pattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])[/](0?[1-9]|1[012])[/][0-9]{4}");
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches())
			return input;
		else {
			System.out.println("Invalid input!!");
			return getInput(field);
		}
	}
}
