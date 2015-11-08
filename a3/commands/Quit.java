package a3.commands;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Quit extends AbstractAction {
	
	
	public Quit(){
		super("Quit");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Are you sure you want to Quit?",
			    "Quit",
			    JOptionPane.YES_NO_OPTION);
		if(n == 0)
			System.exit(0);
	}

}
