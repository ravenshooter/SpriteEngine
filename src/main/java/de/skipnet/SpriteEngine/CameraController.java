package main.java.de.skipnet.SpriteEngine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Simple controller used to move the camera around.
 * @author Stephan Tietz
 *
 */
public class CameraController extends KeyAdapter {

	
	private DrawableCanvas view; 
	private Camera camera;
	
	public CameraController(DrawableCanvas view, Camera camera) {
		this.camera = camera;
		this.view = view;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		super.keyPressed(e);
		camera.move(e.getKeyChar());
		view.repaint();
	}
	
	
	

}
