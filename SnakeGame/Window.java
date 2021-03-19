package SnakeGame;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window  extends Canvas {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame window;
	
	JLabel fps = new JLabel("<html><h3>FPS: 0</h3> </html>");
	
	private JPanel top = new JPanel(), center = new JPanel(), bottom = new JPanel();
	
	private JButton start = new JButton("Iniciar");
	
	private JLabel t = new JLabel("Jogo da Cobrinha");
	
	public Window(int WIDTH, int HEIGHT, Game game, String title ) {
		 window = new JFrame();
		 
		 window.setTitle(title);
		 window.setResizable(false);
		 window.setSize(WIDTH, HEIGHT);
		 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 window.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		 window.setLocationRelativeTo(null);
		 
		// top.setBackground(Color.white);
		 
		 top.setPreferredSize(new Dimension(WIDTH, HEIGHT / 3));
		 
		// center.setBackground(Color.white);
		 
		 center.setPreferredSize(new Dimension(WIDTH, HEIGHT /3));
		 
		// bottom.setBackground(Color.white);
		 
		 bottom.setPreferredSize(new Dimension(WIDTH, HEIGHT /3));
		 
		 window.setLayout(new BorderLayout());
		 
		 window.add(top, BorderLayout.NORTH);
		 
		 window.add(center, BorderLayout.CENTER);
		 
		 window.add(bottom, BorderLayout.SOUTH);
		 
		 Font f = new Font("Arial", Font.BOLD, 100);
		 
		 Font f2 = new Font("Arial", 0, 20);
		 
		 t.setFont(f);
		 
		// t.setForeground(Color.black);
		 
		 top.add(t);
		 
		 start.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT / 7));
		 
		// start.setBackground(Color.black);
		 
		// start.setForeground(Color.white);
		 
		 start.setFont(f2);
		 
		 center.add(start);
		 
		 window.setVisible(true);
		 
		 ButtonEvent(game);
	 }
	
	 private void ButtonEvent(Game game) {
		 start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 start.setVisible(false);
				 
				 window.remove(top); window.remove(center); window.remove(bottom);
				 
				 window.add(game, BorderLayout.CENTER);
				 
				 window.add(fps, BorderLayout.NORTH);
				 
				 window.revalidate();
				 
				 window.repaint();
				 
				 game.start();
			}
		});
	 }

}
