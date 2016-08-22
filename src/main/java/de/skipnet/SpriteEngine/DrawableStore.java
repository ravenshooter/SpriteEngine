package main.java.de.skipnet.SpriteEngine;

import java.util.ArrayList;





public class DrawableStore {
	
	private ArrayList<ArrayList<Drawable>> drawables; //could be sth fancy like xy-tree to improve performance
	
	
	/**
	 * Creates a new drawable store. All drawables should register with the drawable store, otherwise they will not be drawn. 
	 */
	public DrawableStore() {
		drawables = new  ArrayList<ArrayList<Drawable>>(10);
		for(int i = 0; i < 10; i++){
			drawables.add(new ArrayList<Drawable>());
		}
	}
	
	
	public  ArrayList<Drawable> getDrawables(int layer) {
		return drawables.get(layer);
	}
	
	/**
	 * Add a drawable to this store.
	 * Method is sycnrhonized to make sure, that nobody can getInstance the list of drawables while rendering locks the DrawableStore.
	 */
	public synchronized void addDrawable(Drawable d, int layer){
		drawables.get(layer).add(d);
	}

	/**
	 * Remove a drawable to this store.
	 * Method is sycnrhonized to make sure, that nobody can getInstance the list of drawables while rendering locks the DrawableStore.
	 */
	public synchronized void removeDrawable(Drawable remove, int layer) {
		drawables.get(layer).remove(remove);
	}
	
	
	

}
