package sample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RemoveUnbalancedParentheses {

	public static void main(String[] args) {
		RemoveUnbalancedParentheses task = new RemoveUnbalancedParentheses();
		task.process();

	}

	void process() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();

		toBalance(input);
	}

	void toBalance(String equation) {

		Queue<String> queue = new LinkedList<String>();
		queue.add(equation);
		String subEquation;

		while (!queue.isEmpty()) {
			equation = queue.poll();

			if (isBalanced(equation)) {
				System.out.println(equation);
				break;
			}

			for (int i = equation.length()-1 ; i >=0 ; i--) {
				if (equation.charAt(i) == '(' || equation.charAt(i) == ')') {
					subEquation = equation.substring(0, i) + equation.substring(i + 1);
					if (!queue.contains(subEquation)) {
						queue.add(subEquation);
					}
				}
			}
		}
	}

	boolean isBalanced(String equation) {
		int openParenthesesCount = 0, closeParenthesesCount = 0;
		for (int i = 0; i < equation.length(); i++) {
			if (equation.charAt(i) == '(')
				openParenthesesCount++;
			else if (equation.charAt(i) == ')')
				closeParenthesesCount++;
		}
		if (openParenthesesCount == closeParenthesesCount)
			return true;
		else
			return false;
	}

}
