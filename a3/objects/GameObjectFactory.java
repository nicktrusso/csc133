package a3.objects;

public class GameObjectFactory {
	public GameObject createObject(String type){
		GameObject gObject = null;
		
		if(type.equals("net"))
			gObject = new Net();
		else
			if(type.equals("dog"))
				gObject = new Dog();
			else
				if(type.equals("cat"))
					gObject = new Cat();
		return gObject;
	}
}
