package SnakeGame;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int WIDTH = 1024, HEIGHT = 800;
	
	private Thread thread;
	
	public boolean running = true ;
	
	private Snake snake;
	
	private Map map ;
	
	public Apple apple;
	
	private Window frame;
	
	public static void main(String[] args) {
		new Game();
	}	
	
	public Game() {
		
		 
		frame = new Window(WIDTH,  HEIGHT,  this, "Jogo da Cobrinha");
		
		addKeyListener(Controller.getKeyListener());
		
		
	}
	public synchronized void start() {
		
		map = new Map(this);
		
		apple = new Apple(map);
		
		apple.generate();
		
		snake = new Snake(this);
		
		thread = new Thread(this);
		
		thread.start();
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			 e.printStackTrace();
		}
	}
	

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 long lastTime = System.nanoTime();
		 double amountOfTicks = 10.0;
		 double ns = 1000000000 /  amountOfTicks;
		 double delta = 0;
		 long timer = System.currentTimeMillis();
		 int frames = 0;
		 while(running) {
			 long now = System.nanoTime();
			 delta += (now - lastTime) / ns;
			 lastTime = now;
			// System.out.println(delta);
			 while(delta >= 1) {
				 tick();
				 delta--;
			 }
			 if(running) 
				 render();
			 frames++;
			 
			 if(System.currentTimeMillis() - timer > 1000) {
				 timer += 1000;
				// System.out.println("FPS: " +  frames);
				 frame.fps.setText("<html><h3>FPS: "+frames+"</h3> </html>");
				 frames = 0;
			 }
		 }
		 stop();
	}

	
	private void render() {
		BufferStrategy bs =  this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.white);
		
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		map.setGrahics(g);
		
		map.drawMap();
		
		apple.render(map);
		
		snake.render(map);
		
		g.dispose();
		
		bs.show();
	}
	private void tick() {
		snake.tick();
	
	}
}
