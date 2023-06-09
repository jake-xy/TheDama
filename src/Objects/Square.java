package Objects;

public class Square {

	public int type, color;
	public double r, c;
	
	public Square(double rPos, double cPos, int type, int color) {
		r = rPos;
		c = cPos;
		this.type = type;
		this.color = color;
	}
	
	public double[][] getPossibleMoves(Square[][] board) {
		double[][] out = new double[0][2];
		
		// this nested for loop will be able to check the 1 square diagonal to this piece's position
		for (int rDir : new int[] {1, -1}) {
			for (int cDir : new int[] {1, -1}) {
				int destR = (int)r + rDir;
				int destC = (int)c + cDir;
				
				// to prevent going over the board (i.e., to prevent ArrayIndexOutOfBound Error)
				if (destR >= 0 && destR < 8 && destC >= 0 && destC < 8) {
					// if the destination r and destination c on the board is an empty space
					if (board[destR][destC].type == Checkers.SPACE) {
						// That is a possible move. So, add that to the possible moves
						out = Utils.append(new double[] {destR, destC}, out);
					}
				}
			}
		}
		
		return out;
	}
	
}
