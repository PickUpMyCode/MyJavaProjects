package com.resources;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora_20 extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField input = new JTextField(20);
	private static JTextField output = new JTextField(10);
	private JLabel titulo = new JLabel("Calculadora");
	private JPanel painel = new JPanel();
	private JPanel painel1 = new JPanel();
	private JButton buttons [] = new JButton[10];
	private JButton Somar = new JButton("+");
	private JButton Subtrair = new JButton("-");
	private JButton Multiplicar = new JButton("*");
	private JButton Dividir = new JButton("/");
	private JButton add_formula = new JButton("Formulas");
	//private JButton Igual = new JButton("=");
	private JButton Limpar = new JButton("C");
	private JButton porcentagem = new JButton("%");
	private JButton ponto = new JButton(".");
	private static boolean clear = false;
	private String msg= "";
	private double operador = 0;
	private boolean trava = true;	
	private boolean  trava2 = false;
	private boolean calc = true;
	private boolean trava_ponto = false;
	//Interface Calculadora
	public Calculadora_20() {
		//Calculadora Versao ALPHA
		new Thread(this).start();
		setTitle("Calculadora");
		setSize(250, 370);
		setVisible(true);
		setLayout(new FlowLayout());
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add_formula.setPreferredSize(new Dimension(150, 30));
		Somar.setPreferredSize(new Dimension(45, 30));
		Subtrair.setPreferredSize(new Dimension(45, 30));
		Dividir.setPreferredSize(new Dimension(45, 30));
		Multiplicar.setPreferredSize(new Dimension(45, 30));
		porcentagem.setPreferredSize(new Dimension(45, 30));
		ponto.setPreferredSize(new Dimension(45, 30));
		Limpar.setPreferredSize(new Dimension(45, 30));
		painel1.setPreferredSize(new Dimension(150, 250));
		painel.setPreferredSize(new Dimension(150, 75));
		output.setEditable(false);
		input.setEditable(false);
		input.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar() == '0') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '1') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '2') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '3') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '4') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '5') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '6') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '7') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '8') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '9') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '-') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '+') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '*') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '/') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '.') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}
				else if(e.getKeyChar() == '%') {
					if(trava2 == false) {
						msg += e.getKeyChar()+"";
						input.setText(msg);
						trava = false;
					}
				}else if(e.getKeyChar() == 'c') {
					msg = "";
					clear = true;
					input.setText(msg);
					trava_ponto = false;
					trava2 = false;
				}
				else if(e.getKeyChar() == ',') {
					int tam = msg.length() - 1;
					String novo = "";
					for(int i = 0; i < tam; i++) {
						novo += Character.toString(msg.charAt(i));
					}
					msg = novo;
					input.setText(msg);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		//Adicionando Objetos a Interface
		add(titulo);
		getContentPane().add(input);
		getContentPane().add(output);
		getContentPane().add(painel);
		painel.add(Somar);
		painel.add(Subtrair);
		painel.add(Multiplicar);
		painel.add(Dividir);
		painel.add(porcentagem);
		getContentPane().add(painel1);
		for(int i = 1; i < buttons.length; i++) {
			buttons[i] = new JButton(""+i);
			buttons[i].setPreferredSize(new Dimension(45, 30));
			painel1.add(buttons[i]);
		}
		buttons[0] = new JButton(""+"0");
		buttons[0].setPreferredSize(new Dimension(45, 30));
		painel1.add(Limpar);
		painel1.add(buttons[0]);
		painel1.add(ponto);
		painel1.add(add_formula);
		//Fim
		//Metodos
		B0();
		B1();
		B2();
		B3();
		B4();
		B5();
		B6();
		B7();
		B8();
		B9();
		Somar();
		Subtrair();
		Multiplicar();
		Dividir();
		Porcentagem();
		Limpar();
		Ponto();
		add_formula(new JFrame());
		//Fim Metodos
	}
	@Override
	public void run() {
		clear = true;
		while(calc == true) {
			if(clear != false) {
				operador = 0;
				output.setText(operador+"");
				clear = false;
			}
			//if(msg != "") {
			try {
				String [] t = new String[msg.length()];
				String [] n = new String[msg.length()];
				for(int i = 0; i < msg.length(); i++) {
					t[i] =  Character.toString(msg.charAt(i));
				}
				for(int i = 0; i < msg.length(); i++) {
					if(t[i].equals("+") || t[i].equals("-") || t[i].equals("*") ||t[i].equals("/") ) {
						t[i] = Character.toString(msg.charAt(i));
					}else {
						if(i < (msg.length() - 1)) {
							if(t[i+1].equals("0") || t[i+1].equals("1") || t[i+1].equals("2") ||t[i+1].equals("3") ||t[i+1].equals("4") ||t[i+1].equals("5") ||t[i+1].equals("6") ||t[i+1].equals("7") ||t[i+1].equals("8") ||t[i+1].equals("9") || t[i+1].equals(".") ) {
								String soma = t[i] + t[i+1];
								t[i] = soma;
								t[i + 1] = t[i];
								t[i] = null;
							}
						}
					}
				}
				int cont = 0;
				for(int i = 0; i < msg.length(); i++) {
					if(t[i] != null) {
						n[cont] = t[i];
						cont++;
					}
				}
				for(int i = 0; i < msg.length(); i++) {
					t[i] = n[i];
				}
				double re = 0;
				for(int i = 0; i < msg.length(); i++) {
					if(t[i] != null) {
						if(t[i].equals("*")) {
							if(t[i - 1] != null) {
								re = Double.parseDouble(t[i - 1]) * Double.parseDouble(t[i + 1]) ;
								t[i] = null;
								t[i + 1] = null;
								t[i  - 1] = null;
							}else {
								re *= Double.parseDouble(t[i + 1]);
								t[i] = null;
								t[i + 1] = null;
							}
						}
					}
					if(t[i] != null) {
						if(t[i].equals("+")) {
							if(t[i - 1] != null) {
								re = Double.parseDouble(t[i - 1]) + Double.parseDouble(t[i + 1]) ;
								t[i] = null;
								t[i + 1] = null;
								t[i  - 1] = null;
							}else {
								re += Integer.parseInt(t[i + 1]);
								t[i] = null;
								t[i + 1] = null;
							}
						}
					}
					if(t[i] != null) {
						if(t[i].equals("-")) {
							if(t[i - 1] != null) {
								re = Double.parseDouble(t[i - 1]) - Double.parseDouble(t[i + 1]) ;
								t[i] = null;
								t[i + 1] = null;
								t[i  - 1] = null;
							}else {
								re -= Double.parseDouble(t[i + 1]);
								t[i] = null;
								t[i + 1] = null;
							}
						}
						if(t[i] != null) {
							if(t[i].equals("/")) {
								if(t[i - 1] != null) {
									re = Double.parseDouble(t[i - 1]) / Double.parseDouble(t[i + 1]) ;
									t[i] = null;
									t[i + 1] = null;
									t[i  - 1] = null;
								}else {
									re /= Double.parseDouble(t[i + 1]);
									t[i] = null;
									t[i + 1] = null;
								}
							}
							if(t[i] != null) {
								if(t[i].equals("%")) {
									if(t[i - 1] != null) {
										re = Double.parseDouble(t[i - 1]) / 100;
										t[i] = null;
										t[i + 1] = null;
										t[i  - 1] = null;
									}else {
										re /= 100;
										t[i] = null;
										t[i + 1] = null;
									}
								}
							}
						}
					}
				}
				output.setText(re+"");
				}catch(Exception e){
					//DO NOTHING
				}	
			}
		//}

	}
	
	//Declaração dos Buttons
	public void B0() {
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(trava2 == false) {
				msg = msg+"0";
				input.setText(msg);
				trava = false;
				}
			}
		});
	}
	public void B1() {
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(trava2 == false) {
				msg = msg+"1";
				input.setText(msg);
				trava = false;
				}
			}
		});
	}
	public void B2() {
		buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(trava2 == false) {
				msg = msg+"2";
				input.setText(msg);
				trava = false;
				}
			}
		});
	}
	public void B3() {
		buttons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(trava2 == false) {
				msg = msg+"3";
				input.setText(msg);
				trava = false;
				}
			}
		});
	}
	public void B4() {
		buttons[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(trava2 == false) {
					msg = msg+"4";
					input.setText(msg);
					trava = false;
				}
			}
		});
	}
	public void B5() {
		buttons[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(trava2 == false) {
				msg = msg+"5";
				input.setText(msg);
				trava = false;
				}
			}
		});
	}
	public void B6() {
		buttons[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(trava2 == false) {
				msg = msg+"6";
				input.setText(msg);
				trava = false;
				}
			}
		});
	}
	public void B7() {
		buttons[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(trava2 == false) {
				msg = msg+"7";
				input.setText(msg);
				trava = false;
				}
			}
		});
	}
	public void B8() {
		buttons[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(trava2 == false) {
				msg = msg+"8";
				input.setText(msg);
				trava = false;
				}
			}
		});
	}
	public void B9() {
		buttons[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(trava2 == false) {
				msg = msg+"9";
				input.setText(msg);
				trava = false;
				}
			}
		});
	}
	private void Somar() {
		Somar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(trava == false) {
					msg += "+";
					input.setText(msg);
					trava = true;
					trava_ponto = false;
				}
			}
		});
	}
	private void Subtrair() {
		Subtrair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(trava == false) {
					msg += "-";
					input.setText(msg);
					trava = true;
					trava_ponto = false;
				}
			}
		});
	}
	private void Multiplicar() {
		Multiplicar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(trava == false) {
					msg += "*";
					input.setText(msg);
					trava = true;
					trava_ponto = false;
				}
			}
		});
	}
	private void Dividir() {
		Dividir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(trava == false) {
					msg += "/";
					input.setText(msg);
					trava = true;
					trava_ponto = false;
				}
			}
		});
	}
	private void Ponto() {
		ponto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(trava_ponto == false) {
					msg += ".";
					input.setText(msg);
					trava_ponto = true;
				}
			}
		});
	}
	private void Porcentagem() {
		porcentagem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(trava == false) {
					msg += "%";
					input.setText(msg);
					trava = true;
					trava2 = true;
				}
			}
		});
	}
	private void Limpar() {
		Limpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				msg = "";
				clear = true;
				input.setText(msg);
				trava_ponto = false;
				trava2 = false;
			}
		});
	}
	private void add_formula(JFrame i) {
		add_formula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				calc = false;
				try {
					new GerenciadorDeFormulas();
				}catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args)throws Exception {
		new Calculadora_20();
	}
}
