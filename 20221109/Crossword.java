package assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class Crossword {

	public static void main(String[] args) {
		new Crossword().process();
	}

	private void process() {
		char[][] matrix = { { 'B', 'N', 'E', 'Y', 'S' }, { 'H', 'E', 'D', 'E', 'S' }, { 'S', 'G', 'N', 'D', 'E' } };
		String word = "DES";
//		char[][] matrix = { {'B', 'N', 'E', 'Y', 'S'}, {'H', 'E', 'D', 'E', 'S'}, {'S', 'G', 'N', 'D', 'E'}};
//		String word = "BNEGSHBN";
		findWord(matrix, word);
	}

	private void findWord(char[][] matrix, String word) {
		String result;
		Set<String> results = new LinkedHashSet<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == word.charAt(0)) {
					result = word.charAt(0) + "(" + i + "," + j + ") ";
					findNextLetter(matrix, i, j, word, 1, result, results);
				}
			}
		}
		for (String str : results) {
			System.out.println(str);
		}

	}

	private void findNextLetter(char[][] matrix, int i, int j, String word, int index, String result, Set<String> set) {
		if (index == word.length()) {
			set.add(result);
			return;
		}
		int[][] positions = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
		int row, column;
		String newResult;
		for (int k = 0; k < 8; k++) {
			row = i + positions[k][0];
			column = j + positions[k][1];
			if (row < 0) {
				row = matrix.length - 1;
				column = j;
			} else if (row == matrix.length) {
				row = 0;
				column = j;
			} else if (column < 0) {
				row = i;
				column = matrix[0].length - 1;
			} else if (column == matrix[0].length) {
				row = i;
				column = 0;
			}
			if (matrix[row][column] == word.charAt(index)) {
				newResult = result + word.charAt(index) + "(" + row + "," + column + ") ";
				findNextLetter(matrix, row, column, word, index + 1, newResult, set);
			}
		}

	}

}
