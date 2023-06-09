package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

import javax.swing.JPanel;

import Panels.*;

public class Game extends JPanel{

	public static final int GAME_SPEED = 24; // speed is like working on 24 FPS
	GameLoop gameLoop;
	public Dimension size;
	public MainLoop mainLoop;
	public double prevTime;
	public static double dt;
	
	public Game() {
		// initialize this class
		size = new Dimension(1080, 720);
		this.setPreferredSize(size);
		
		// add listeners
		this.addMouseMotionListener(new MML());
		this.addMouseListener(new ML());
//		this.setFocusable(true);
		this.setVisible(true);
		
		// initialize game panels
		mainLoop = new MainLoop(this);
		mainLoop.active = true;
		mainLoop.visible = true;
		
		// start the game loop
		gameLoop = new GameLoop(this);
	}
	
	
	public void update() {		
		// update game panels
		mainLoop.update();
		
	}
	
	
	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		
		// draw the game panels
		mainLoop.draw(g);
	}
	
	class ML implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			mainLoop.mouseClicked(e);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			mainLoop.mousePressed(e);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			mainLoop.mouseReleased(e);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			mainLoop.mouseEntered(e);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			mainLoop.mouseExited(e);
			
		}
		
	}
	
	
	class MML implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			mainLoop.mouseDragged(e);
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			mainLoop.mouseMoved(e);
			
		}
		
	}
	
}
