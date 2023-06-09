package Objects;

public abstract class Checkers {

	public static int
		WHITE = 0,
		BLACK = 1,
		SPACE = -1,
		PIECE = 2,
		SUPER_PIECE = 3
	;
	
	public static double[][] getPossibleMoves(Square[][] board, int color){
		double[][] out = new double[0][2];
		
		
		return out;
	}
	
	public static Square[][] generateBoard() {
		Square[][] out = new Square[8][8];
		
		// fill the board with space
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				out[r][c] = new Square(r, c, SPACE, SPACE);
			}
		}
		
		// place the pieces on their appropriate sqaures as per the rules of checkers
		for (int r : new int[] {0, 6}) {
			
			int color = r == 0 ? BLACK : WHITE;
			
			for (int c = 1; c < 8; c += 2) {
				out[r][c] = new Square(r, c, PIECE, color);
			}
			
		}
		
		for (int r : new int[] {1, 7}) {
			
			int color = r == 1 ? BLACK : WHITE;
			
			for (int c = 0; c < 8; c += 2) {
				out[r][c] = new Square(r, c, PIECE, color);
			}
			
		}
		
		return out;
	}
}
