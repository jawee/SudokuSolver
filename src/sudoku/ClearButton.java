package sudoku;
import javax.swing.*;
import java.awt.event.*;


public class ClearButton extends JButton implements ActionListener {
	public JTextField[][] board;
	public JPanel top;
	public SudokuGUI view;
	/** Knapp för clear.
	 * @param view är vilket SudokuGUI som används*/
	public ClearButton(SudokuGUI view) {
		super("Clear");
		this.view = view;
		addActionListener(this);
	}
	/** Tömmer spelplanen vid knapptryckning. */
	 public void actionPerformed(ActionEvent e) {
		int[][] temp = new int[9][9];
		 for(int i = 0; i < 9; i++) {
			 for(int j = 0; j < 9; j++) {
				 temp[i][j] = 0;
			 }
		 }
		 view.update(temp);
	 }
}