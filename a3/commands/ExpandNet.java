package a3.commands;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import a3.controller.GameWorld;
import a3.objects.GameObjectCollection;
import a3.objects.Net;

@SuppressWarnings("serial")
public class ExpandNet extends AbstractAction {
	private GameObjectCollection goCollection;
	private GameWorld gameWorld;
	
	public ExpandNet(){
		super("Expand");
		goCollection = GameObjectCollection.getGameObjectCollection();
		gameWorld = GameWorld.getGameWorld();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Expand");
		Net n = (Net)goCollection.getCollection().get(0);
		if(n.incSize()){
			System.out.println("Net has been expanded");
			gameWorld.stateChange();
		}
		else
			System.out.println("The net cannot be expanded");
		
	}
}
