package a3.objects;

import java.awt.Color;

import a3.controller.GameWorld;


/**
 * 
 * @author Nick
 * Abstract superclass of all Game Objects
 *
 */
public abstract class GameObject implements IDrawable {
	private float locX, locY;
	private int size;
	private Color color;
	private String type;
	//mutator methods
	public void setLocX(float locX){
		this.locX = locX;
	}
	public void setLocY(float locY){
		this.locY = locY;
	}
	public void setSize(int size){
		this.size = size;
	}
	public void setColor(int r,int g,int b){
		color = new Color(r,g,b);
	}
	public void setType(String type){
		this.type = type;
	}
	//access methods
	public float getLocX(){
		return locX;
	}
	public float getLocY(){
		return locY;
	}
	public int getSize(){
		return size;
	}
	public int getColorR(){
		return color.getRed();
	}
	public int getColorG(){
		return color.getGreen();
	}
	public int getColorB(){
		return color.getBlue();
	}
	public Color getColor(){
		return this.color;
	}
	public String getType(){
		return type;
	}
}
	
