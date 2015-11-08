package a3.objects;

import java.awt.Graphics;
import java.util.Random;

import a3.controller.GameWorld;
import a3.utilities.Utility;

/**
 * 
 * @author Nick
 * Net GameObject represented by a square with side length getSize() 
 */
public class Net extends Catcher {
	public static final int MINSIZE = 50;
	public static final int MAXSIZE = 500;
	private Random rand;
	
	public Net(){
		rand = new Random();
		setType("net");
		setLocX((rand.nextFloat() * GameWorld.WORLDSIZEX));
		setLocY((rand.nextFloat() * GameWorld.WORLDSIZEY));
		setSize(Utility.randomBounded(MINSIZE, MAXSIZE));
		setColor(250,250,250);	
	}	
	public String toString(){
		return "Net: " + 
				"Location=(" + String.format("%.1f",getLocX()) +"," + String.format("%.1f",getLocY()) +") " + 
				"Color=["+getColorR() + "," +getColorG()+","+getColorB()+"]"+
				" Size="+getSize();
	}
	/**
	 * 
	 * @return Returns true if the increment does not exceed MAXSIZE
	 */
	public boolean incSize(){
		if((getSize() + 10) < MAXSIZE){
			setSize(getSize() + 10);
			return true;
		}
		else return false;		
	}
	/**
	 * 
	 * @return Returns true if shrinking the net does not go below MINSIZE
	 */
	public boolean decSize(){
		if((getSize() - 10) > MINSIZE){
			setSize(getSize() - 10);
			return true;
		}
		else
			return false;
	}
	public boolean contains(float x, float y){
		return(getLocX() < x && getLocY() < y &&
			   getLocX() + getSize() > x &&
			   getLocY() + getSize() > y);
	}
	@Override
	public void draw(Graphics g) {
		g.drawRect((int)getLocX(), (int)getLocY(), getSize(), getSize());
		g.setColor(getColor());
	}
}
