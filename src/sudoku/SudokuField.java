package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class SudokuField extends JTextField implements KeyListener {
	/** Skapar ett SudokuField (JTextField). */
	public SudokuField() {
		super();
		setBackground((new Color(71,255,233)));
		addKeyListener(this);
		setFont(new Font("serif", Font.PLAIN, 35));
		setBorder(new LineBorder((Color.BLACK)));
		setHorizontalAlignment(CENTER);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/** Kontrollerar om inskrivet tecken är korrekt i rutan (tal mellan 1-9), och begränsar antalet tecken till 1.
	 * @param arg0 är vilken knapptryckning som gjorts. */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(this.getText().length() > 0) {
			arg0.consume();
		}
		if(!(arg0.getKeyChar() >= KeyEvent.VK_1 && arg0.getKeyChar() <= KeyEvent.VK_9)) {
			arg0.consume();
		}
	}

}
