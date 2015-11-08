package a3.controller;

import java.util.Iterator;
import java.util.Observable;
import java.util.Scanner;
import a3.objects.Animal;
import a3.objects.Cat;
import a3.objects.Dog;
import a3.objects.GameObject;
import a3.objects.GameObjectCollection;
import a3.objects.GameObjectFactory;
import a3.utilities.Utility;


public class GameWorld extends Observable {
	//Model//
	public static final int WORLDSIZEX = 1024;
	public static final int WORLDSIZEY = 768;
	public static final int MAXANIMALS = 200;
	private GameObjectCollection goCollection;
	private Scanner scan;
	private int dogsCaptured,catsCaptured,dogsRemain,catsRemain,totalPoints;
	private static GameWorld gameWorld;
	private static GameObjectFactory gObjectFactory;
	boolean soundOn;
	
	/**
	 * Create the GameWorld and initialize an empty collection of GameObjects, the Net is always the first object.
	 * 
	 * Initialization of the Game World
	 */
	private GameWorld(GameObjectFactory gObjectFactory){
		scan = new Scanner(System.in);
		goCollection = GameObjectCollection.getGameObjectCollection();
		GameWorld.gObjectFactory = gObjectFactory;
		goCollection.add(GameWorld.gObjectFactory.createObject("net"));
		dogsCaptured = 0;
		catsCaptured = 0;
		dogsRemain = 0;
		catsRemain = 0;
		totalPoints = 0;
	}
	public static GameWorld getGameWorld(){
		if(gameWorld == null)
			gameWorld = new GameWorld(new GameObjectFactory());
		return gameWorld;
	}
	public void initLayout(){
		int value;
		value = getNumberOfObjects("dog");
		dogsRemain = value;
		for(int i=0;i<value;i++)
			goCollection.add(gObjectFactory.createObject("dog"));
		value = getNumberOfObjects("cat");
		catsRemain = value;
		for(int i=0;i<value;i++)
			goCollection.add(gObjectFactory.createObject("cat"));
		
	}
	private int getNumberOfObjects(String type){
		int value;
		do{
			System.out.println("How many "+type+ "'s (1 - "+MAXANIMALS+")? ");
			while(!scan.hasNextInt()){
				System.out.println("Invalid input!");
				scan.next();
				System.out.print("How many "+type+"s? ");
			}
			value = scan.nextInt();
		}while(value < 1 || value > MAXANIMALS);
		return value;
	}
	public int getTotalPoints(){
		return totalPoints;
	}
	public int getDogsCaptured(){
		return dogsCaptured;
	}
	public int getCatsCaptured(){
		return catsCaptured;
	}
	public int getDogsRemaining(){
		return dogsRemain;
	}
	public int getCatsRemaining(){
		return catsRemain;
	}
	public void addCat(){
		catsRemain++;
	}
	public void soundOn(){
		soundOn = true;
		setChanged();
		notifyObservers();
	}
	public void soundOff(){
		soundOn = false;
		setChanged();
		notifyObservers();
	}
	public boolean isSoundOn(){
		return soundOn;
	}
	
	
	public void removeCaptured(){
		Animal go;
		//start at 1, since net is always at 0
		for(int i=1; i<goCollection.getCollection().size(); i++){
			go = (Animal)goCollection.getCollection().get(i);
			if(go.isCaught())
				goCollection.getCollection().remove(go);
		}
		if(dogsRemain == 0)
			win();
	}
	
	public void addPoints(){
		GameObject go;
		Dog dog;
		Cat cat;
		int currentDCap = 0;
		int currentCCap = 0;
		//start at 1 since net is always at 0
		for(int i=1; i < goCollection.getCollection().size(); i++){
			go = goCollection.getCollection().get(i);
			if(go.getType() == "dog"){
				dog = (Dog)goCollection.getCollection().get(i);
				if(dog.isCaught()){
					totalPoints += dog.getPoints();
					dogsCaptured++;
					dogsRemain--;
					currentDCap++;
				}
			}
			else
				if(go.getType() == "cat"){
					cat  = (Cat)goCollection.getCollection().get(i);
					if(cat.isCaught()){
						totalPoints += cat.getPoints();
						catsCaptured++;
						catsRemain--;
						currentCCap++;
					}
				}
		}
		setChanged();
		notifyObservers();
		System.out.println("You caught "+currentDCap+" dogs and "+currentCCap+" cats");
		System.out.println("There are still "+ dogsRemain+" dogs and "+catsRemain+" cats remaining!");
	}
	
	public void print(){
		System.out.println("Points:");
		System.out.println("Total Points: "+totalPoints);
		System.out.println("Dogs Captured: "+dogsCaptured);
		System.out.println("Cats Captured: "+catsCaptured);
		System.out.println("Dogs Remaining: "+dogsRemain);
		System.out.println("Cats Remaining: "+catsRemain);
	}
	
	public void map(){
		Iterator<GameObject> itr = goCollection.iterator();
		System.out.println("MAP:");
		Utility.printAllObjects(itr);
	}
	
	public void win(){
		System.out.println("All dogs have been captured!");
		quit();
	}
	
	public void quit(){
		print();
		System.out.println("Goodbye!");
		System.exit(0);
	}
	public void stateChange(){
		setChanged();
		notifyObservers();
	}
}
