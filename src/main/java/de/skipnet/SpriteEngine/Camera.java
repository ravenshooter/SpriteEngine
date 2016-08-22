package main.java.de.skipnet.SpriteEngine;


import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;


/**
 * Class representing a camera that slides over the drawables.
 * @author Stephan Tietz
 *
 */
public class Camera {

	/**
	 * Store holding all drawables that need to be rendered
	 */
	private DrawableStore drawables;
	
	/**
	 * Top left corner of camera. Internal representation must be double to ensure smooth camera movements
	 */
	private double x, y;
	
	/**
	 * Width and height of camera
	 */
	private int width, height;
	
	
	/**
	 * Sets the zoom level of the camera
	 */
	private double zoom;
	
	
	/**
	 * Creates a new camera that renders all drawables in drawable store.
	 * @param drawables
	 * @param height height in pxl
	 * @param width width in pxl
	 */
	public Camera(DrawableStore drawables, int x, int y, double zoom, int width, int height) {
		this.drawables = drawables;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.zoom = zoom;
	}

	
	
	
	
	/**
	 * Call this method to render all drawables currently visible.
	 * @param g graphics object to render on
	 */
	public synchronized void render(Graphics2D g){
		g.fillRect(0, 0, width, height);
		AffineTransform af = new AffineTransform();
		af.translate(width/2, height/2);
		af.scale(zoom, zoom);
		af.translate(-width/2,-height/2);
		g.transform(af);
		
		synchronized (drawables) {
			for(int i = 0; i < 10; i ++){
				for(Drawable d : drawables.getDrawables(i)){
					d.render(g, getX(), getY());
				}
			}
		}
		
	}
	
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getX() {
		return (int) x;
	}
	
	public int getY() {
		return (int) y;
	}


	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}


	public void move(char direction) {
		switch(direction){
			case 'w': y = y - 20; break;
			case 's': y = y + 20; break;
			case 'a': x = x - 20; break;
			case 'd': x = x + 20; break;
			case 'q': zoom = zoom -0.1; break;
			case 'e': zoom = zoom +0.1; break;
		}
	}
}
