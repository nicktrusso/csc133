package a3.commands;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;

import a3.controller.GameWorld;
import a3.objects.Cat;
import a3.objects.GameObject;
import a3.objects.GameObjectCollection;

@SuppressWarnings("serial")
public class Breed extends AbstractAction {
	private GameObjectCollection goCollection;
	private GameWorld gw;
	
	public Breed(){
		super("Breed");
		goCollection = GameObjectCollection.getGameObjectCollection();
		gw = GameWorld.getGameWorld();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean hasCat,hasCat2;
		Iterator<GameObject> itr = goCollection.iterator();
		GameObject go;
		hasCat = false;
		hasCat2 = false;
		Cat c = null,c2 = null;
		
		//check if there are two cats
		while(itr.hasNext()){
			if(itr.next().getType() == "cat")
				hasCat = true;
			if(itr.hasNext() && itr.next().getType() == "cat")
				hasCat2 = true;
		}
		if(hasCat && hasCat2){
			System.out.println("Two cats have just created a kitten!");
			for(int i=0;i < goCollection.getCollection().size(); i++){
				if(goCollection.getCollection().get(i).getType() == "cat"){
					go = goCollection.getCollection().get(i);
					c = (Cat)go;
				}
				for(int j=1;j < goCollection.getCollection().size()-1;j++){
					if(goCollection.getCollection().get(j).getType() == "cat"){
						go = goCollection.getCollection().get(j);
						c2 = (Cat)go;
					}
				}
			}
			goCollection.add(c.breed(c2));
			gw.addCat();
			gw.stateChange();
		}
		else
			System.out.println("Not enough cats to make a kitten");
	}

}
