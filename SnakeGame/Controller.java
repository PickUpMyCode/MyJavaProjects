package SnakeGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class Controller{

	private static boolean up, down = true, left, right; 

	public static boolean getKeyUP() {
		return up;
	}

	public static boolean getKeyDOWN() {
		return down;
	}

	public static boolean getKeyLEFT() {
		return left;
	}

	public static boolean getKeyRIGHT() {
		return right;
	}


	public static KeyAdapter getKeyListener() {
		return new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

				if(e.getKeyCode() == KeyEvent.VK_UP && !down ) {
					//	System.out.println("Up");

					up = true;
					down = false;
					left = false;
					right = false;
					

				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN && !up) {
					//	System.out.println("Down");

					down = true;
					up = false;
					left = false;
					right = false;
					
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT && !right ) {
					//System.out.println("Left");
					left = true;
					right = false;
					down = false;
					up = false;
					

				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT && !left) {
					//System.out.println("Right");

					right = true;
					left = false;
					up  = false;
					down = false;
					
					
				}





			}

		};
	}



}
