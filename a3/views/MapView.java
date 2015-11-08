package a3.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import a3.controller.GameWorld;
import a3.objects.GameObject;
import a3.objects.GameObjectCollection;

@SuppressWarnings("serial")
public class MapView extends JPanel implements Observer{
	private static GameWorld gameWorld;
	private static GameObjectCollection goCollection;
	private Iterator<GameObject> itr;
	private static MapView mv;
	
	
	private MapView(GameWorld observable){
		gameWorld = observable;
		gameWorld.addObserver(this);
		Dimension d = new Dimension();
		d.setSize(GameWorld.WORLDSIZEX, GameWorld.WORLDSIZEY);
		setPreferredSize(d);
		setBackground(new Color(0, 0, 0));
		this.setVisible(true);
	}
	
	public static MapView getMapView(){
		if(mv == null){
			mv = new MapView(GameWorld.getGameWorld());
			goCollection = GameObjectCollection.getGameObjectCollection();
		}
		return mv;
	}
	@Override
	public void update(Observable o, Object arg) {
		gameWorld.map();
		repaint();
	}
	@Override
	public void paintComponent(Graphics g){
		itr = goCollection.iterator();
		super.paintComponent(g);
		while(itr.hasNext())
			itr.next().draw(g);
		
	}
}
