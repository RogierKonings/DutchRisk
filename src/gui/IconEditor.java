package gui;

import game.Dice;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class responsible for displaying an ImageIcon on the JSpinner objects of
 * RiskBoard
 * 
 * @author rogier_konings
 * 
 */
public class IconEditor extends JLabel implements ChangeListener {

	private JSpinner spinner;
	private Icon icon;
	private int diceeyes;

	public IconEditor(JSpinner s) {
		super((Icon) ((Dice) s.getValue()).getDiceIcon(), CENTER);
		icon = (Icon) ((Dice) s.getValue()).getDiceIcon();
		diceeyes = ((Dice) s.getValue()).getDiceNumber();
		spinner = s;
		spinner.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent ce) {
		icon = (Icon) ((Dice) spinner.getValue()).getDiceIcon();
		diceeyes = ((Dice) spinner.getValue()).getDiceNumber();
		System.out.println("" + diceeyes);
		setIcon(icon);
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public Icon getIcon() {
		return icon;
	}
}