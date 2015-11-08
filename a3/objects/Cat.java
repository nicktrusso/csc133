package a3.objects;

import java.awt.Graphics;
import java.util.Random;

import a3.controller.GameWorld;
import a3.utilities.Utility;

/**
 * 
 * @author Nick
 * Cat GameObject, represented by an equilateral triangle with side length getSize()
 *
 */
public class Cat extends Animal {
	private static final int MAXSIZE = 400;
	public static final int MINSIZE = 50;
	private Random rand;
	private int points;
	
	public Cat(){
		rand = new Random();
		points = -10;
		setType("cat");
		setLocX((rand.nextFloat() * GameWorld.WORLDSIZEX));
		setLocY((rand.nextFloat() * GameWorld.WORLDSIZEY));
		setDirection(rand.nextInt(360));
		setSize(Utility.randomBounded(MINSIZE, MAXSIZE));
		setColor(64, 150, 179);
	}
	
	public int getPoints(){
		return points;
	}
	public Cat breed(Cat cat){
		Cat kitten = new Cat();
		kitten.setLocX(cat.getLocX()+5);
		kitten.setLocY(cat.getLocY()+5);
		return kitten;
	}

	public String toString(){
		return "Cat: " + 
				"Location=(" + String.format("%.1f",getLocX()) +"," + String.format("%.1f",getLocY()) +") " + 
				"Color=["+getColorR() + "," +getColorG()+","+getColorB()+"]"+
				" Size="+getSize() + 
				" Speed="+getSpeed() + 
				" Direction=" + getDirection()
				;
	}

	@Override
	public void draw(Graphics g) {
		
		
	}
}
