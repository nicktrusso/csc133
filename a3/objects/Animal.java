package a3.objects;

import a3.controller.GameWorld;
import a3.movement.IMoveableBehavior;

public abstract class Animal extends GameObject implements IMoveableBehavior{
	public static final int MAXSPEED = 5;
	private int direction;
	private boolean caught;
	private int speed;
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	public int getDirection(){
		return direction;
	}
	public void setSpeed(){
		speed = Animal.MAXSPEED;
	}
	public void reduceSpeed(){
		--speed;
	}
	public int getSpeed(){
		return speed;
	}
	private void reverseDirection(){
		direction = -direction;
	}
	public void caught(){
		caught = true;
	}
	public boolean isCaught(){
		return caught;
	}
	public String toString(){
		return "";
	}
	public abstract int getPoints();
	
	@Override
	public void move(){
		float deltaX, deltaY;
		deltaX = ((float) Math.cos((90-getDirection())) * getSpeed());
		deltaY = ((float) Math.sin((90-getDirection())) * getSpeed());
		setLocX(getLocX()+deltaX);
		setLocY(getLocY()+deltaY);
		
		if((getLocX() >= GameWorld.WORLDSIZEX) || (getLocX() <= 0))
			reverseDirection();
		if((getLocY() >= GameWorld.WORLDSIZEY) || (getLocY() <= 0))
			reverseDirection();
		
	}
}
