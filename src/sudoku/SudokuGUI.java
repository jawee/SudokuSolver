package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SudokuGUI extends JFrame {
	private JPanel top;
	private SudokuField[][] frames;

	/** Skapar ett sudokuGUI. */
	public SudokuGUI() {
		super("SudokuSolver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		top = new JPanel();
		JPanel bottom = new JPanel();
		top.setLayout(new GridLayout(9, 9));

		frames = new SudokuField[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				frames[i][j] = new SudokuField();

				if (i / 3 % 2 == 0 && j / 3 % 2 == 0
						|| (i / 3 == 1 && j / 3 == 1)) {
					frames[i][j].setBackground((new Color(143, 206, 233)));
				}
				top.add(frames[i][j]);
			}
		}

		bottom.add(new SolveButton(this));
		bottom.add(new ClearButton(this));

		add(top, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		// pack();
		setSize(500, 400);
		setVisible(true);
	}

	/**
	 * Tar emot en int-matris med nya siffror som ska skrivas ut på spelplanen.
	 * 
	 * @param temp
	 *            är en int-matris.
	 */
	public void update(int[][] temp) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (temp[i][j] == 0) {
					frames[i][j].setText("");
				} else {
					frames[i][j].setText(Integer.toString(temp[i][j]));
				}
			}
		}
	}

	/** @return returnerar JPanel-objektet som innehåller spelbrädet. */
	public JPanel getWindow() {
		return top;
	}

	/**
	 * Skapar en sudoku från GUI.
	 * @return SudokuSolver-objekt med en sudoku från GUI.
	 */
	public SudokuSolver getSudoku() {
		int[][] sudoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (frames[i][j].getText().isEmpty()) {
					sudoku[i][j] = 0;
				} else {
					sudoku[i][j] = Integer.valueOf(frames[i][j].getText());
				}
			}
		}

		return new SudokuSolver(sudoku);
	}
}
