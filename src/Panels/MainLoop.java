package Panels;

import java.awt.*;
import java.awt.event.*;

import Main.Game;
import Objects.*;

public class MainLoop implements MouseMotionListener, MouseListener{
	
	// variables for the panel
	public boolean active, visible;
	Game game;	
	Rect boardRect;
	double tileSize;
	
	// variables for the actual gameplay
	Square[][] board = new Square[8][8];
	Square[][] displayBoard = new Square[8][8];
	
	double[][] selectedsMoves;
	double[] selectedPos;
	double[] clickedPos;
	
	
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
//					g.setColor(new Color(177, 110, 65)); // darkish brown
					g.setColor(new Color(118, 150, 86)); // darkish green
				}
				else {
					// light square
//					g.setColor(new Color(255, 213, 153)); // lightish brown
					g.setColor(new Color(238, 238, 210)); // dirty white
				}
				
				g.fillRect((int)(boardRect.left + c*tileSize), (int)(boardRect.top + r*tileSize), (int)tileSize, (int)tileSize);
			}
		}
		
		// draw line around the board
		g.setStroke(new BasicStroke(3));
		g.setColor(Color.black);
		g.drawRect((int)boardRect.x, (int)boardRect.y, (int)boardRect.w, (int)boardRect.h);
		
		// draw the selected pos
		if (selectedPos != null) {	
			// set the color to a somewhat opaque yellow
			g.setColor(new Color(255, 255, 0, 155)); // r g b a
			g.fillRect(
				(int)(boardRect.left + selectedPos[1]*tileSize), 
				(int)(boardRect.top + selectedPos[0]*tileSize), 
				(int)tileSize, (int)tileSize)
			;
		}
		
		// draw the possible moves
		if (selectedsMoves != null) {
			for (double[] pos : selectedsMoves) {
				int r = (int) pos[0];
				int c = (int) pos[1];
				
				Square square = displayBoard[r][c];
				
				int radius = (int)(15);
				int x = (int)(square.c + tileSize/2 - radius);
				int y = (int)(square.r + tileSize/2 - radius);
				
				g.setStroke(new BasicStroke(10));
				g.setColor(new Color(50, 50, 50, 130)); // r g b a
				g.fillArc(x, y, radius*2, radius*2, 0, 360);
			}
		}
		
		// draw the pieces
		drawPieces(displayBoard, Checkers.WHITE, g);
		drawPieces(displayBoard, Checkers.BLACK, g);
		
	}
	
	public void update() {
		
		// clickedPos is not empty if the player clicked
		if (clickedPos != null) {
			
			
			
			// if there is no selected pos yet
			if (selectedPos == null) {
				// if that pos has a piece.. and it is the color of the current color
				if (board[(int)clickedPos[0]][(int)clickedPos[1]].type != Checkers.SPACE) {
					selectedPos = clickedPos;
					
					selectedsMoves = board[(int)selectedPos[0]][(int)selectedPos[1]].getPossibleMoves(board);
				}
			}
			else {
				if (board[(int)clickedPos[0]][(int)clickedPos[1]].type != Checkers.SPACE) {
					selectedPos = clickedPos;
					
					selectedsMoves = board[(int)selectedPos[0]][(int)selectedPos[1]].getPossibleMoves(board);
				}
				else {					
					selectedPos = null;
					selectedsMoves = null;
				}
			}
			
			
			
			clickedPos = null;
		}
		
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
		int r = (int)((e.getY() - boardRect.top)/tileSize);
		int c = (int)((e.getX() - boardRect.left)/tileSize);
		
		if (r >= 0 && r < 8 && c >= 0 && c < 8) {
			clickedPos = new double[] {r, c};
		}
		
		System.out.println("r: " + r + " c: " + c);	
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
