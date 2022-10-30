package Group1;

import java.util.Scanner;
import java.util.Stack;

public class PostFixExpression {

	public static void main(String[] args) {
		PostFixExpression task = new PostFixExpression();
		task.getInput();
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("PostFixExpression : ");
		String expression = scan.nextLine();
		scan.close();
		System.out.println(getResult(expression));
	}

	private int getResult(String expression) {
		int result = 0;
		Stack<Integer> equation = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			if (Character.isDigit(expression.charAt(i))) {
				equation.push(expression.charAt(i) - 48);
			} else {
				result = solve(equation.pop(), equation.pop(), expression.charAt(i));
				equation.push(result);
			}
		}
		return result;
	}

	private int solve(int number2, int number1, char operator) {
		switch (operator) {
		case '+':
			return (number1 + number2);
		case '-':
			return (number1 - number2);
		case '*':
			return (number1 * number2);
		case '/':
			return (number1 / number2);
		default:
			return 0;
		}
	}

}
