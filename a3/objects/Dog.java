package a3.objects;

import java.awt.Graphics;
import java.util.Random;

import a3.controller.GameWorld;
import a3.utilities.Utility;

/**
 * 
 * @author Nick
 *	Dog GameObject represented by a circle with diameter getSize()
 */
public class Dog extends Animal {
	private static final int MAXSCRATCHES = 5;
	private static final int MAXSIZE = 400;
	public static final int MINSIZE = 50;
	private int scratches, points;
	private Random rand;
	
	public Dog(){
		scratches = 0;
		points = 10;
		setSpeed(); 
		setType("dog");
		rand = new Random();
		setLocX((rand.nextFloat() * GameWorld.WORLDSIZEX));
		setLocY((rand.nextFloat() * GameWorld.WORLDSIZEY));
		setDirection(rand.nextInt(360));
		super.setSize(Utility.randomBounded(MINSIZE, MAXSIZE));
		setColor(0,255,255);
	}
	
	public int getScratches(){
		return scratches;
	}
	public int getPoints(){
		return points;
	}
	public void scratch(){
		if(scratches < MAXSCRATCHES){
			++scratches;
			--points;
			reduceSpeed();
			setColor((getColorR()+50), (getColorG()-50), (getColorB()-50));
		} 
	}
	public String toString(){
		return "Dog: " + 
				"Location=(" + String.format("%.1f",getLocX()) +"," + String.format("%.1f",getLocY()) +") " + 
				"Color=["+getColorR() + "," +getColorG()+","+getColorB()+"]"+
				" Size="+getSize() + 
				" Speed="+getSpeed() + 
				" Direction=" + getDirection() + 
				" Scratches=" + getScratches();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval((int)(getLocX()), (int)(getLocY()), (getSize()), (getSize()));
	}
}
