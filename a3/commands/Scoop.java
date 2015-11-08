package a3.commands;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;

import a3.controller.GameWorld;
import a3.objects.Animal;
import a3.objects.GameObject;
import a3.objects.GameObjectCollection;
import a3.objects.Net;
import a3.views.MapView;
import a3.views.ScoreView;

@SuppressWarnings("serial")
public class Scoop extends AbstractAction {
	GameObjectCollection goCollection;
	GameWorld gw;
	ScoreView sv;
	MapView mv;
	
	public Scoop(){
		super("Scoop");
		goCollection = GameObjectCollection.getGameObjectCollection();
		gw = GameWorld.getGameWorld();
		sv = ScoreView.getScoreView();
		mv = MapView.getMapView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Iterator<GameObject> itr = goCollection.iterator();
		GameObject go;
		Net n = (Net)goCollection.getCollection().get(0);
		System.out.println("You scoop up your net!");
		itr.next(); //skip testing net object
		while(itr.hasNext()){
			go = itr.next();
			if(n.contains(go.getLocX(),go.getLocY())){
				Animal a = (Animal)go;
				a.caught();
			}
		}
		gw.addPoints();
		gw.removeCaptured();
	}
}
