package sudoku;
import javax.swing.*;
import java.awt.event.*;


public class SolveButton extends JButton implements ActionListener {
	public JTextField[][] board;
	public SudokuGUI view;
	/** Knapp f�r solve.
	 * @param view �r vilket SudokuGUI som anv�nds*/
	public SolveButton(SudokuGUI view) {
		super("Solve");
		this.view = view;
		addActionListener(this);
	}
	/** Tar in sudoku fr�n GUI och l�ser denna vid knapptryckning. */
	 public void actionPerformed(ActionEvent e) {
		 SudokuSolver s = view.getSudoku();
		 
		 if(!s.solve()) {
			 JOptionPane.showMessageDialog(view.getWindow(), "G�r ej att l�sa");
		 }
		 view.update(s.getSolved());
	 }
}
