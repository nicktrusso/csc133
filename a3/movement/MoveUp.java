package a3.movement;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import a3.controller.GameWorld;
import a3.objects.GameObjectCollection;
import a3.objects.Net;

@SuppressWarnings("serial")
public class MoveUp extends AbstractAction {
	GameObjectCollection goCollection;
	GameWorld gw;
	
	public MoveUp(){
		super("Up");
		goCollection = GameObjectCollection.getGameObjectCollection();
		gw = GameWorld.getGameWorld();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Net n = (Net)goCollection.getCollection().get(0);
		System.out.println("You move the net up");
		n.moveUp();
		gw.stateChange();
	}
}