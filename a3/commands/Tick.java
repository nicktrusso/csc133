package a3.commands;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;

import a3.controller.GameWorld;
import a3.objects.Animal;
import a3.objects.GameObject;
import a3.objects.GameObjectCollection;

@SuppressWarnings("serial")
public class Tick extends AbstractAction {
	private GameObjectCollection goCollection;
	private GameWorld gameWorld;
	
	public Tick(){
		super("Tick");	
		goCollection = GameObjectCollection.getGameObjectCollection();
		gameWorld = GameWorld.getGameWorld();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Iterator<GameObject> itr = goCollection.iterator();
		System.out.println("Game clock has ticked");
		while(itr.hasNext()){
			Object obj = itr.next();
			if(obj instanceof Animal){
				((Animal) obj).move();
			}
		}
		gameWorld.stateChange();
	}
}
