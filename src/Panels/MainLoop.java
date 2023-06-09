package Panels;

import java.awt.*;
import java.awt.event.*;

import Main.Game;
import Objects.*;

public class MainLoop implements MouseMotionListener, MouseListener{
	
	public boolean active, visible;
	Game game;
	
	Square[][] board = new Square[8][8];
	Square[][] displayBoard = new Square[8][8];
	Rect boardRect;
	double tileSize;
	
	public MainLoop(Game game) {
		this.game = game;
		// initializing variables
		double boardSize = game.size.height;
		boardRect = new Rect(game.size.width/2 - boardSize/2, 0, boardSize, boardSize);
		
		tileSize = boardSize/8;
		
		// initializing the boards
		board = Checkers.generateBoard();
		displayBoard = getDisplayBoard(board);
	}
	
	
	public void draw(Graphics2D g) {
		
		// draws the board
		int oddOrEven = 0;
		for (int r = 0; r < 8; r++) {
			oddOrEven = oddOrEven == 1 ? 0 : 1; 
			for (int c = 0; c < 8; c++) {
				
				if (c % 2 == oddOrEven) {
					// dark square
//					new Color(177, 110, 65)
					g.setColor(new Color(186, 202, 68));
				}
				else {
					// light square
//					new Color(255, 213, 153)
					g.setColor(new Color(238, 238, 210));
				}
				
				g.fillRect((int)(boardRect.left + c*tileSize), (int)(boardRect.top + r*tileSize), (int)tileSize, (int)tileSize);
			}
		}
		
		// draw line around the board
		g.setStroke(new BasicStroke(3));
		g.setColor(Color.black);
		g.drawRect((int)boardRect.x, (int)boardRect.y, (int)boardRect.w, (int)boardRect.h);
		
		// draw the pieces
		drawPieces(displayBoard, Checkers.WHITE, g);
		drawPieces(displayBoard, Checkers.BLACK, g);
		
	}
	
	public void update() {
		
	}
	
	
	private Square[][] getDisplayBoard(Square[][] board) {
		Square[][] out = new Square[8][8];
		
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				out[r][c] = new Square(
					boardRect.top + r*tileSize,
					boardRect.left + c*tileSize,
					board[r][c].type,
					board[r][c].color
				);
			}
		}
		
		return out;
	}
	
	
	private void drawPieces(Square[][] displayBoard, int color, Graphics2D g) {
		
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				Square square = displayBoard[r][c];
				
				if (square.color == color) {					
					int radius = (int)(tileSize/2 - 10);
					int x = (int)(square.c + tileSize/2 - radius);
					int y = (int)(square.r + tileSize/2 - radius);
					
					g.setStroke(new BasicStroke(10));
					g.setColor(color == Checkers.WHITE ? Color.white : Color.black);
					g.drawArc(x, y, radius*2, radius*2, 0, 360);
				}
			}
		}
		
	}

	// MOUSE LISTENERS
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
