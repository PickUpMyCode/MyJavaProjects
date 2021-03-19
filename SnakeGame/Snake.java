package SnakeGame;

import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Snake {

	private int x = 5 , y  =5;

	public String teste ;

	private Game game;

	public int length = 8;

	private ArrayList<SnakePiece> piece = new ArrayList<>();
	
	private int delay = 10, delayCount = 0;
	
	private boolean generated = false;
	
	private boolean isDead = false;

	public Snake(Game game) {
		this.game = game;
		
		loadSnake();
	}

	public void loadSnake() {
		for(int i = 0; i < length; i++) {
			piece.add(new SnakePiece());
		}
		piece.get(0).isHead = true;
	}


	public int getX() {
		return x;
	}
	public int getY() {
		return y; 
	}

	private void Dead() {

		isDead = true;

		JOptionPane.showMessageDialog(null, "Perdeu!");

		game.stop();
	}


	public void eat() {
		game.apple.grow(this);

		game.apple.generate();

		piece.add(new SnakePiece());

	}

	public void tick() {


		if(Controller.getKeyDOWN()) { y++;  }
		if(Controller.getKeyUP() ) { y--;  }
		if(Controller.getKeyLEFT() ) { x--;  }
		if(Controller.getKeyRIGHT() ) { x++; }

	}

	public void render(Map map) {
		
		delayCount++;
		
		
		Color c = new Color(Rainbow.r, Rainbow.g, Rainbow.b);	
		
		if(delayCount == delay) {
			
			Rainbow.R(); Rainbow.G(); Rainbow.B();
			
			delayCount = 0;
		}
		
		piece.get(0).x = x;

		piece.get(0).y = y;
		
		for(int i = 1; i < length; i++) {
			piece.get(i).setPosition(piece.get(i - 1));
		}
		
		if(!generated) {
			generated = true;
			for(int i = 0; i < length; i++) {
				if(piece.get(i).x == 0 && piece.get(i).y == 0) {
					generated = false;
					
					break;
				}
				
				map.drawPoint(piece.get(i).x, piece.get(i).y, c);
			}
		}
		
		if(!isDead && generated) {

			try {
				
				map.vacate();


			
				
				for(int i = 0; i < length; i++) {

					int pX = piece.get(i).x, pY = piece.get(i).y;


					if(map.getBusyPoint(pX, pY) && !piece.get(i).isGenerating) {

						Dead();

						return; 
					}

					if(!piece.get(i).isGenerating || piece.get(i).isHead) {
						
					
						map.drawPoint(pX, pY, c);
					

						map.setBusyPoint(pX, pY);
					}

				}

				if(game.apple.x == piece.get(0).x && game.apple.y == piece.get(0).y) { eat(); }

			}catch(Exception e) {
				Dead();
			}
		}
	}



	class SnakePiece {

		boolean isGenerating = true, isHead = false;

		int bx = -1, by= -1, x, y;

		void setPosition(SnakePiece p) {

			if(bx < 0 && by < 0) {
				bx = p.x;

				by = p.y;

				return;
			}



			if(bx != p.x || by != p.y) {
				x = bx;

				y = by;

				bx = p.x;

				by = p.y;
				
				isGenerating = false ;
			}


		}
	}
}

