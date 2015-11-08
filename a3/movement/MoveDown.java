package a3.movement;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import a3.controller.GameWorld;
import a3.objects.GameObjectCollection;
import a3.objects.Net;

@SuppressWarnings("serial")
public class MoveDown extends AbstractAction {
	GameObjectCollection goCollection;
	GameWorld gw;
	
	
	public MoveDown(){
		super("Down");
		goCollection = GameObjectCollection.getGameObjectCollection();
		gw = GameWorld.getGameWorld();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Net n = (Net)goCollection.getCollection().get(0);
		System.out.println("You move the net Down");
		n.moveDown();
		gw.stateChange();
	}
}
