package sudoku;

public class SudokuSolver {
	public int[][] board;

	/** Skapar ett nytt Sudoku-spel, utan några siffror ifylld.a */
	public SudokuSolver() {
		this(new int[9][9]);
	}

	/**
	 * Skapar ett nytt Sudoku-spel med siffror från GUI.
	 * @param board är ett spelbräde som ska lösas.
	 */
	public SudokuSolver(int[][] board) {
		this.board = board;
	}

	private boolean checkRow(int r, int c, int n) {
		for (int i = 0; i < 9; i++)
			if(i == c) {
				
			}
			else if (board[r][i] == n) {
				return false;
			}

		return true;
	}

	private boolean checkColumn(int r, int c, int n) {
		for (int i = 0; i < 9; i++) {
			if(i == r) {
				
			}
			else if (board[i][c] == n) {
				return false;
			}
		}
		return true;

	}

	private boolean checkArea(int r, int c, int n) {
		int oldR = r;
		int oldC = c;

		r = (r / 3) * 3;
		c = (c / 3) * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ((r + i) == oldR && (c + j) == oldC) {
				} else if (board[r + i][c + j] == n) {
					return false;
				}

			}
		}
		return true;
	}

	/**
	 * Löser sudokut, börjar på plats 0,0.
	 * 
	 * @return true om det löstes, false annars.
	 */
	public boolean solve() {
		return solve(0, 0);
	}

	private boolean solve(int r, int c) {
		if (c > 8) {
			r++;
			c = 0;
		}
		if (r > 8) {
			return true;
		}

		if (board[r][c] != 0) {
			int p = board[r][c];
			if (checkRow(r, c, p) && checkColumn(r, c, p) && checkArea(r, c, p))
				if (solve(r, c + 1)) {
					return true;
				}
		} else {
			for (int i = 1; i < 10; i++) {
				if (checkRow(r, c, i) && checkColumn(r, c, i)
						&& checkArea(r, c, i)) {
					board[r][c] = i;
					if (solve(r, c + 1)) {
						return true;
					}

				}
			}
			board[r][c] = 0;
		}

		return false;
	}

	/** @return returnar spelbrädet */
	public int[][] getSolved() {
		return board;
	}

}
