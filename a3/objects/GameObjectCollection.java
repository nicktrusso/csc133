package a3.objects;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class GameObjectCollection implements Collection<GameObject>{
	private LinkedList<GameObject> theCollection;
	private static GameObjectCollection gameObjectCollection;
	
	private GameObjectCollection(){
		theCollection = new LinkedList<GameObject>();
	}
	public static GameObjectCollection getGameObjectCollection(){
		if(gameObjectCollection == null)
			gameObjectCollection = new GameObjectCollection();
		return gameObjectCollection;
	}
	@Override
	public boolean add(GameObject e) {
		return theCollection.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends GameObject> c) {
		return theCollection.addAll(c);
	}

	@Override
	public void clear() {
		theCollection.clear();
	}

	@Override
	public boolean contains(Object o) {
		return theCollection.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return theCollection.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return theCollection.isEmpty();
	}

	@Override
	public Iterator<GameObject> iterator() {
		return theCollection.iterator();
	}
	
	@Override
	public boolean remove(Object o) {
		return theCollection.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return theCollection.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return theCollection.retainAll(c);
	}

	@Override
	public int size() {
		return theCollection.size();
	}

	@Override
	public Object[] toArray() {
		return theCollection.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return theCollection.toArray(a);
	}
	
	public LinkedList<GameObject> getCollection(){
		return theCollection;
	}
}
