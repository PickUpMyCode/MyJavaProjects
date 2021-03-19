package SnakeGame;

import java.awt.Color;
import java.util.Random;

public class Apple {
	
	int x, y;
	
	private Map map;
	
	public Apple(Map map) {

		this.map = map;
	}
	
	public void generate() {
		
		Random r = new Random();
		
		int size = map.getSize();
		
		x = r.nextInt(size - 1);
		
		y = r.nextInt(size -1);
	
	}
	
	public void render(Map map) {
		map.drawPointOval(x, y, Color.red);
	}
	
	public void grow(Snake s) {
		
		s.length++;
		
		generate();
	}
	
}
