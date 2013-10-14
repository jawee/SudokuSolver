package sudoku;
import javax.swing.*;
import java.awt.event.*;


public class SolveButton extends JButton implements ActionListener {
	public JTextField[][] board;
	public SudokuGUI view;
	/** Knapp för solve.
	 * @param view är vilket SudokuGUI som används*/
	public SolveButton(SudokuGUI view) {
		super("Solve");
		this.view = view;
		addActionListener(this);
	}
	/** Tar in sudoku från GUI och löser denna vid knapptryckning. */
	 public void actionPerformed(ActionEvent e) {
		 SudokuSolver s = view.getSudoku();
		 
		 if(!s.solve()) {
			 JOptionPane.showMessageDialog(view.getWindow(), "Går ej att lösa");
		 }
		 view.update(s.getSolved());
	 }
}
