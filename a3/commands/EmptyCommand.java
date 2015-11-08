package a3.commands;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class EmptyCommand extends AbstractAction{
	public EmptyCommand(String text){
		super(text);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Item clicked: "+arg0.getActionCommand());

	}

}
