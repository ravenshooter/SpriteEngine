package main.java.de.skipnet.SpriteEngine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;



public class DrawableCanvas extends JPanel implements ComponentListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	private Camera camera;
	private CameraController controller;
	
	
	/**
	 * DrawableCanvas is a JPanel that renders all drawables in the drawable store according to a camera position.
	 * @param drawables the store containing all drawables that need to be rendered onto the jpanel.
	 */
	public DrawableCanvas(DrawableStore drawables, boolean center) {
		
		if(center)
			camera = new Camera(drawables, -400, -300, 1, 800, 600);
		else
			camera = new Camera(drawables, 0, 0, 1, 800, 600);

		controller = new CameraController(this, camera);
		this.addKeyListener(controller);
		
		this.setFocusable(true);
		this.requestFocus();
		this.setDoubleBuffered(true);
		this.addComponentListener(this);

	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		camera.render((Graphics2D)g);
	}


	@Override
	public void componentHidden(ComponentEvent e) {

	}


	@Override
	public void componentMoved(ComponentEvent e) {

	}


	@Override
	public void componentResized(ComponentEvent e) {
		camera.setWidth(this.getWidth());
		camera.setHeight(this.getHeight());
		this.repaint();
	}


	@Override
	public void componentShown(ComponentEvent e) {

	}
	
	
	
	



	
	
	

}
