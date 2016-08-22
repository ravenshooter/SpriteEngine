package main.java.de.skipnet.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.java.de.skipnet.SpriteEngine.DrawableCanvas;
import main.java.de.skipnet.SpriteEngine.DrawableStore;

public class Main {



	public static void main(String[] args) {
		
		//Initialize drawablee engine
		DrawableStore drawableStore = new DrawableStore();
		DrawableCanvas canvas = new DrawableCanvas(drawableStore, false);
		
		//Initialize JFrame
		JFrame frame = new JFrame("PacMan example");
		frame.setPreferredSize(new Dimension(1000, 400));
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add tooltip to explain camera movement
		JLabel tooltip = new JLabel("Use W,A,S,D to move camera, Q and E to zoom.");
		frame.add(tooltip,BorderLayout.SOUTH);
		
		
		//Canvas must be added before setVisible is called!
		frame.getContentPane().add(canvas,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		
		//Add drawables that need to be displayed.
		drawableStore.addDrawable(new PacManDrawable(100, 100), 1);
		drawableStore.addDrawable(new GhostDrawable(GhostDrawable.Color.blue, 400, 100), 1);
		drawableStore.addDrawable(new GhostDrawable(GhostDrawable.Color.green, 700, 100), 1);
		
		canvas.repaint();
	}

}
