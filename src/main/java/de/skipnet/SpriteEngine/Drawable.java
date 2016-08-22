package main.java.de.skipnet.SpriteEngine;

import java.awt.Graphics2D;

public interface Drawable {


	
	/**
	 * return absolute x coordinate of this drawable
	 * @return
	 */
	public int getX();
	
	
	/**
	 * Return absolute y coordinate of this drawable
	 * @return
	 */
	public int getY();
	
	
	/**
	 * Return width in pxl
	 * @return
	 */
	public int getWidth();
	
	/**
	 * Return height in pxl
	 * @return
	 */
	public int getHeight();
	
	
	/**
	 * This method is called by the camera. Put all your rendering logic here. 
	 * @param g The grahics context to render on 
	 * @param camX the x coordinate of the topleft corner of the camera. Render your image at: xPos-xCam 
	 * @param camY the y coordinate of the topleft corner of the camera. Render your image at: yPos-yCam 
	 */
	public void render(Graphics2D g, int camX, int camY);
		
}
