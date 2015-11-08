package a3.utilities;

import java.util.Iterator;
import java.util.Random;

import a3.objects.GameObject;

public class Utility {
	
	public static void clearScreen(){
		for(int i=0;i<50;i++)
			System.out.println();
	}
	
	public static void printAllObjects(Iterator<GameObject> itr){
		while(itr.hasNext()){
			Object o = itr.next();
			System.out.println(o.toString());
		}
	}
	
	public static int randomBounded(int lower, int upper){
		Random rnd = new Random();
		int returnInt;
		returnInt = rnd.nextInt(upper);		
		if(returnInt < lower)
			returnInt = ((lower - returnInt) + lower);
		return returnInt;
	}
	public static float randomBounded(float lower, float upper){
		Random rnd = new Random();
		float returnFloat;
		returnFloat = rnd.nextFloat();
		if(returnFloat < lower)
			returnFloat = ((lower - returnFloat) + lower);
		else
			if(returnFloat > upper)
				returnFloat = (returnFloat % upper);
		return returnFloat;
	}
	public static double randomBounded(double lower, double upper){
		Random rnd = new Random();
		double returnDouble;
		returnDouble = rnd.nextDouble();
		if(returnDouble < lower)
			returnDouble = ((lower - returnDouble) + lower);
		else
			if(returnDouble > upper)
				returnDouble = (returnDouble % upper);
		return returnDouble;
	}

}
