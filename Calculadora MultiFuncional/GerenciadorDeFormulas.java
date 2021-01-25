package com.resources;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.*;

public class GerenciadorDeFormulas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean existe = false;
	private String [][] formulas =  new String[100][2];
	//private String [] forms = new String[100];
	private String[] colunas = {"Nome", "Formulas"};
	private JTable t = new JTable(formulas, colunas);
	private JButton add = new JButton("Adicionar");
	private JButton volta = new JButton("Calculadora");
	private JButton access = new JButton("Acessar Formula");
	private JButton remove = new JButton("Deletar");
	private JScrollPane scroll = new JScrollPane(t);
	public GerenciadorDeFormulas() throws Exception {
		// TODO Auto-generated method stub	
		Memoria.setCaminho("Formulas.txt");
		Memoria.Criar();	
		setVisible(false);
		setTitle("Formulas");
		setVisible(true);
		setSize(500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		add.setPreferredSize(new Dimension(250, 30));
		volta.setPreferredSize(new Dimension(250, 30));
		remove.setPreferredSize(new Dimension(250, 30));
		add(add);
		add(remove);
		add(volta);
		add(scroll);
		add(access);
		t.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				t.editingCanceled(null);
				t.editingStopped(null);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.Carregar();
		this.Criar_Formula();
		this.Acessar(new JFrame());
		this.Deletar(new JFrame());
		volta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				formulas = null;
				new Calculadora_20();
				dispose();
			}
		});
	}
	private void Carregar() {
		try {
			Memoria.ler();
			for(int i = 0; i < 100; i++) {
				formulas[i][0] = null;
				formulas[i][1] = null;
			}
			for(int i = 0; i < Memoria.lenght; i++) {
				if(Memoria.getforms(i) != null) {
					String [] dados  = Memoria.getforms(i).split("--");
					add_formula(dados[0], dados[1]);
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	private void Criar_Formula() {
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JButton volta = new JButton("Voltar");
				JFrame o = new JFrame();
				setVisible(false);
				JButton adi = new JButton("Adicionar");
				JTextField nome = new JTextField(10);
				JTextField formula = new JTextField(10);
				JLabel t_1 = new JLabel("Nome:");
				JLabel t_2 = new JLabel("Formula:");
				JPanel p = new JPanel();
				o.setTitle("Adicionando!");
				o.setVisible(true);
				o.setSize(350, 100);
				o.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				o.setLayout(new FlowLayout());
				o.setLocationRelativeTo(null);
				o.setResizable(false);
				o.getRootPane().setDefaultButton(adi);
				p.setSize(100, 100);
				o.add(p);
				p.add(t_1);
				p.add(nome);
				p.add(t_2);
				p.add(formula);
				o.add(adi);
				o.add(volta);
				volta.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						existe = true;
						setVisible(true);
						o.setVisible(false);
						o.remove(nome);
						o.remove(t_1);
						o.remove(p);
						o.remove(formula);
						o.remove(adi);
						o.remove(volta);
						o.dispose();
					}
				});
				adi.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							Memoria.escrever(nome.getText()+"--"+formula.getText());
						}catch(Exception e) {
							e.printStackTrace();
						}
						add_formula(nome.getText(),formula.getText() );
						o.setVisible(false);
						setVisible(true);
					}
				});
		
			}
		});
	}
	private void add_formula(String nome, String formula) {
		boolean stop = false;
		int j = 0;
		while(stop  == false) {
			if(formulas[j][0] == null && formulas[j][1] == null) {
				formulas[j][0] = nome;
				formulas[j][1] = formula;
				stop = true;
			}
			j++;
		}
	}
	private void Acessar(JFrame u) {
		access.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton a = new JButton("Acessar");
				JButton volta = new JButton("Voltar");
				JLabel title = new JLabel("Nome:");
				JTextField name = new JTextField(20);
				u.setTitle("Acessando");
				u.setVisible(true);
				u.setSize(300, 100);
				u.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				u.setLayout(new FlowLayout());
				u.setLocationRelativeTo(null);
				u.setResizable(false);
				u.getRootPane().setDefaultButton(a);
				u.add(title);
				u.add(name);
				u.add(a);
				u.add(volta);
				volta.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						existe = true;
						setVisible(true);
						u.setVisible(false);
						u.remove(name);
						u.remove(title);
						u.remove(a);
						u.remove(volta);
						u.dispose();
					}
				});
				a.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						existe = false;
						if(name.getText() != null) {
							for(int i = 0; i < 100; i++) {
								if(formulas[i][0] != null) {
									if(formulas[i][0].equals(name.getText())) {
										u.setVisible(false);
										Calculo.CalculaString(formulas[i][1], name.getText());
										existe = true;
									}
								}
							}
							if(existe == false) {
								JOptionPane.showMessageDialog(null, "Esse nome nao existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
							}else {
								setVisible(true);
								u.setVisible(false);
								u.remove(name);
								u.remove(title);
								u.remove(volta);
								u.remove(a);
								u.dispose();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Esse nome nao existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
			}
		});

	}
	private void Deletar(JFrame u) {
		//Melhorar o botao de remover
		remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton a = new JButton("Remover");
				JButton volta = new JButton("Voltar");
				JLabel title = new JLabel("Nome:");
				JTextField name_1 = new JTextField(20);
				u.setTitle("Removendo");
				u.setVisible(true);
				u.setSize(300, 100);
				u.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				u.setLayout(new FlowLayout());
				u.setLocationRelativeTo(null);
				u.setResizable(false);
				u.getRootPane().setDefaultButton(a);
				u.add(title);
				u.add(name_1);
				u.add(a);
				u.add(volta);
				volta.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						setVisible(true);
						t.repaint();
						u.setVisible(false);
						u.remove(name_1);
						u.remove(title);
						u.remove(a);
						u.remove(volta);
						u.dispose();
					}
				});
				a.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							String nome  = name_1.getText();
							if(name_1.getText().length() > 0) {
								for(int i = 0; i < Memoria.lenght; i++) {
									if(Memoria.getforms(i) != null ) {
										String [] dados  = Memoria.getforms(i).split("--");
										if(dados[0].equals(nome)) {
											Memoria.deletarUmaLinha(nome+"--"+dados[1]);
										}
									}
								}
								//Memoria.deletarUmaLinha(nome);
							}
							name_1.setText("");
							Carregar();
							setVisible(false);
							setVisible(true);
							repaint();
						}catch(Exception eb) {
							eb.printStackTrace();
						}
					}
				});
			}
		});

	}
}
