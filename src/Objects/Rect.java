package Objects;

public class Rect {

	public double x, y, w, h;
	public double top, left, right, bot;
	
	public Rect(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		w = width;
		h = height;
		
		updateRect();
	}
	
	
	private void updateRect() {
		this.top = y;
		this.left = x;
		this.right = x + w;
		this.bot = y + h;
	}
}
