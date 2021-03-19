package SnakeGame;

import java.awt.Color;
import java.awt.Graphics;

public class Map {

	private final int size = 24;

	private int w, h;

	private int [] x = new int[size];

	private int [] y = new int[size];
	
	private boolean [][] busy = new boolean[size][size];
	
	private Graphics g;

	public Map(Game game) {
		// TODO Auto-generated constructor stub
		
		w = game.getWidth()  / size; h = game.getHeight() / size;
		
		loadMap();
		
		vacate();
	}
	
	public boolean getBusyPoint(int x, int y) {
		return busy[x][y];
	}
	
	public int getSize() {
		return size;
	}

	private void loadMap() {

		int x = 0, y = 0;
		
		this.x[0] = y; this.y[0] = y;
		
		for(int j = 1;  j < size; j++) {
			y += h;
			
			x += w;
			
			this.y[j] = y;
			
			this.x[j] = x;
			
		}
	}
	public void setGrahics(Graphics g) {
		
		this.g = g;
	}
	
	public void drawMap() {
		
		g.setColor(Color.black);
		
		for(int j = 0; j < size; j++) {
			for(int i = 0; i < size; i++) {
				g.fillRect(this.x[i], this.y[j], w, h);
			}
		}
		
	
	}
	
	public void drawPoint(int x, int y, Color c) {
		
		g.setColor(c);
		
		g.fillRect(this.x[x], this.y[y], w, h);
		
	}
	
	public void drawPointOval(int x, int y, Color c) {
		
		g.setColor(c);
		
		g.fillOval(this.x[x], this.y[y], w, h);
		
	}
	
	public void setBusyPoint(int x, int y) {
		busy[x][y] = true;
	}
	
	public void vacate() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				busy[i][j] = false;
			}
		}
	}
}
