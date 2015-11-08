package a3.commands;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import a3.controller.GameWorld;
import a3.objects.GameObjectCollection;
import a3.objects.Net;


@SuppressWarnings("serial")
public class ContractNet extends AbstractAction {
	private GameObjectCollection goCollection;
	private GameWorld gameWorld;
	
	public ContractNet(){
		super("Contract");
		goCollection = GameObjectCollection.getGameObjectCollection();	
		gameWorld = GameWorld.getGameWorld();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		Net n = (Net)goCollection.getCollection().get(0);
		if(n.decSize()){
			System.out.println("You shrink the net");
			gameWorld.stateChange();
		}
		else
			System.out.println("The net cannot shrink any more");
		
	}
}
