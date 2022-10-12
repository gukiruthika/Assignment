
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfDays {

	public static void main(String[] args) {
		NumberOfDays numberOfDays = new NumberOfDays();
		numberOfDays.getDate();
	}

	void getDate() {
		int fromDay, fromMonth, fromYear, toDay, toMonth, toYear;
		do {
			String fromDate = getInput("starting date");
			String[] fromArray = fromDate.split("/");
			fromDay = Integer.valueOf(fromArray[0]);
			fromMonth = Integer.valueOf(fromArray[1]);
			fromYear = Integer.valueOf(fromArray[2]);
			if (fromDay > getLastDay(fromMonth, fromYear))
				System.out.println("Invalid input!!");
		} while (fromDay > getLastDay(fromMonth, fromYear));

		do {
			String toDate = getInput("ending date");
			String[] toArray = toDate.split("/");
			toDay = Integer.valueOf(toArray[0]);
			toMonth = Integer.valueOf(toArray[1]);
			toYear = Integer.valueOf(toArray[2]);
			if (toDay > getLastDay(toMonth, toYear))
				System.out.println("Invalid input!!");
		} while (toDay > getLastDay(toMonth, toYear));
		int noOfDays;
		if ((fromYear > toYear) || (fromYear == toYear && fromMonth > toMonth)
				|| (fromYear == toYear && fromMonth == toMonth && fromDay > toDay)) {
			noOfDays = getDifference(toDay, toMonth, toYear, fromDay, fromMonth, fromYear);
		} else
			noOfDays = getDifference(fromDay, fromMonth, fromYear, toDay, toMonth, toYear);
		System.out.println("\nNumber of Days -> " + noOfDays);
	}

	int getDifference(int fromDay, int fromMonth, int fromYear, int toDay, int toMonth, int toYear) {
		int numberOfDays = 0;
		if (fromYear == toYear) {
			numberOfDays = getNumberOfDays(fromDay, fromMonth, fromYear, toDay, toMonth);
		} else {
			numberOfDays = getNumberOfDays(fromDay, fromMonth, fromYear, 31, 12);
			for (int year = fromYear + 1; year < toYear; year++) {
				if (isLeapYear(year))
					numberOfDays += 366;
				else
					numberOfDays += 365;
			}
			numberOfDays += getNumberOfDays(0, 01, toYear, toDay, toMonth);
		}
		return numberOfDays;
	}

	int getNumberOfDays(int fromDay, int fromMonth, int fromYear, int toDay, int toMonth) {
		int numberOfDays = 0;
		if (fromMonth == toMonth) {
			numberOfDays = toDay - fromDay;
		} else {
			numberOfDays = getLastDay(fromMonth, fromYear) - fromDay;
			for (int month = fromMonth + 1; month < toMonth; month++) {
				numberOfDays += getLastDay(month, fromYear);
			}
			numberOfDays += toDay;
		}
		return numberOfDays;
	}

	int getLastDay(int month, int year) {
		if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12)
			return 31;
		if (month == 4 | month == 6 | month == 9 | month == 11)
			return 30;
		if (isLeapYear(year))
			return 29;
		else
			return 28;
	}

	boolean isLeapYear(int year) {
		if (year % 400 == 0)
			return true;

		if (year % 4 == 0 && year % 100 != 0)
			return true;

		return false;
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
