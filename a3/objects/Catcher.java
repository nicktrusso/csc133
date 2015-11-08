package a3.objects;

import a3.controller.GameWorld;
import a3.movement.IGuidedBehavior;

public abstract class Catcher extends GameObject implements IGuidedBehavior{
	@Override
	public void moveUp() {
		if((getLocY()-10) <= 0)
			return;
		setLocY(getLocY() - 10);
	}
	@Override
	public void moveDown() {
		if((getLocY()+10) >= GameWorld.WORLDSIZEY)
			return;
		setLocY(getLocY() + 10);
	}
	@Override
	public void moveLeft() {
		if((getLocX()-10) <= 0)
			return;
		setLocX(getLocX() - 10);	
	}
	@Override
	public void moveRight() {
		if((getLocX()+10) >= GameWorld.WORLDSIZEX)
			return;
		setLocX(getLocX() + 10);	
	}
	public String toString(){
		return "";
	}
}
