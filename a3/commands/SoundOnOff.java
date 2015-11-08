package a3.commands;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import a3.controller.GameWorld;

@SuppressWarnings("serial")
public class SoundOnOff extends AbstractAction {
	GameWorld gw;
	
	public SoundOnOff(){
		super("Sound");
		gw = GameWorld.getGameWorld();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(gw.isSoundOn())
			gw.soundOff();
		else
			gw.soundOn();

	}

}
