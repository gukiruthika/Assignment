import java.util.Scanner;

public class Multiplication {

	public static void main(String[] args) {
		Multiplication task = new Multiplication();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number.. ");
		int number = scan.nextInt();
		scan.close();
		getAnswer(number);
	}

	private void getAnswer(int number) {
		System.out.println(number + " x 15 = "+((number << 4)-number));
		if((number & 1) != 1)
			System.out.println(number + " x 7.5 = "+(((number << 4)-number)>>1));
		else
			System.out.println(number + " x 7.5 = "+((((number << 4)-number)>>1)+0.5));
		System.out.println(number + " x 15 / 16 = "+(((number << 4)-number)>>4));
	}

}
