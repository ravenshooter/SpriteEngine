package main.java.de.skipnet.SpriteEngine;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;


/**
 * Drawable that features a sprite and that is drawn centered to its position.
 * @author Stephan Tietz
 *
 */
public class CenteredSpriteDrawbale extends SpriteDrawable {

	public CenteredSpriteDrawbale(Sprite sprite, int rotation, int x, int y) {
		super(sprite, rotation, x, y);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Renders the sprite, relative to camera.
	 */
	@Override
	public void render(Graphics2D g, int camX, int camY) {
		AffineTransform af = new AffineTransform();
		af.translate(getX()-camX-getWidth()/2,getY()-camY-getHeight()/2);
		af.translate(+getWidth()/2, +getHeight()/2);
		af.rotate(Math.toRadians(90*getRotation()));
		af.translate(-getWidth()/2, -getHeight()/2);
		g.drawImage(getSprite().getImage(), af, null); //TODO should check whether drawbale is visible before rendering.

	}
}
