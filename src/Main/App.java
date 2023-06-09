package Main;

import javax.swing.*;

public class App {

	public static void main(String[] args) {
		JFrame win = new JFrame("feel");
		Game game = new Game();
		
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setFocusable(true);
		win.add(game);
		win.pack();
		win.setLocationRelativeTo(null);
		win.setVisible(true);
	}

}
