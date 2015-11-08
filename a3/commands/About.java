package a3.commands;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class About extends AbstractAction {
	
	public About(){
		super("About");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,
				"CSC 133\n"+
				"Programmed By: Nick Trusso\n"+
				"10/20/2015",
			    "Dog Catcher v2.5",
			    JOptionPane.PLAIN_MESSAGE);

	}
}
