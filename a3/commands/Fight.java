package a3.commands;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Random;
import javax.swing.AbstractAction;

import a3.controller.GameWorld;
import a3.objects.Dog;
import a3.objects.GameObject;
import a3.objects.GameObjectCollection;

@SuppressWarnings("serial")
public class Fight extends AbstractAction {
	GameObjectCollection goCollection;
	GameWorld gw;
	Random rand;
	
	public Fight(){
		super("Fight");
		goCollection = GameObjectCollection.getGameObjectCollection();
		gw = GameWorld.getGameWorld();
		rand = new Random();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//check if there is a cat in the collection
				boolean hasCat;
				Iterator<GameObject> itr = goCollection.iterator();
				GameObject go;
				hasCat = false;
				while(itr.hasNext())
					if(itr.next().getType() == "cat"){
						hasCat = true;
						break;
					}
				if(hasCat){
					System.out.println("Cat and dog fight!");
					//grab a random dog and scratch()
					//first instance of dog is element 1
					//last element is dogsRemain
					if(gw.getDogsRemaining() != 1){
						rand = new Random();
						int randomNum = rand.nextInt(gw.getDogsRemaining()+1);
						//if nextInt returns 0, set to first dog
						if(randomNum == 0)
							randomNum = 1;
						go = goCollection.getCollection().get(randomNum);
						Dog d = (Dog)go;
						d.scratch();
					}
					else{
						go = goCollection.getCollection().get(1);
						Dog d = (Dog)go;
						d.scratch();
					}
					gw.stateChange();
				}
				else
					System.out.println("There are no cats left!");
	}
}
