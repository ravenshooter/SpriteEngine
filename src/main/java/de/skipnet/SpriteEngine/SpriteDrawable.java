package main.java.de.skipnet.SpriteEngine;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class SpriteDrawable implements Drawable {

	private Sprite sprite;
	private int x,y;
	private int rotation;
	
	public SpriteDrawable(Sprite sprite, int rotation, int x, int y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}



	public Sprite getSprite() {
		return sprite;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	public int getRotation() {
		return rotation;
	}

	@Override
	public int getWidth() {
		return sprite.getWidth();
	}

	@Override
	public int getHeight() {
		return sprite.getHeight();
	}

	
	/**
	 * Renders the sprite, relative to camera.
	 */
	@Override
	public void render(Graphics2D g, int camX, int camY) {
		AffineTransform af = new AffineTransform();
		af.translate(getX()-camX,getY()-camY);
		af.translate(+getWidth()/2, +getHeight()/2);
		af.rotate(Math.toRadians(90*rotation));
		af.translate(-getWidth()/2, -getHeight()/2);
		g.drawImage(getSprite().getImage(), af, null); //TODO should check whether drawbale is visible before rendering.

	}


}
