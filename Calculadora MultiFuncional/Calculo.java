package com.resources;
import java.util.regex.Matcher;

import java.util.Date;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;


import java.util.Scanner;
public class Calculo {
	public static void CalculaString(String msg, String nome) {
		try {
			Date date = new Date();
			Scanner leia = new Scanner(System.in);
			String log = "";
			Pattern p = Pattern.compile("[a-z]*");
			String [] t = new String[msg.length()];
			String [] n = new String[msg.length()];
			log += "["+date+" / ";
			System.out.printf("%s %n %s %s %n %s %n", "----------------------------", "Nome da Formula: ", nome, "----------------------------");
			log += "Nome da Formula: "+ nome+"] ";
			for(int i = 0; i < msg.length(); i++) {
				t[i] =  Character.toString(msg.charAt(i));
			}
			for(int i = 0; i < msg.length(); i++) {
				if(t[i].equals("+") || t[i].equals("-") || t[i].equals("*") ||t[i].equals("/") ||t[i].equals("(")|| t[i].equals(")")  ) {
					t[i] = Character.toString(msg.charAt(i));
				}else {
					if(i < (msg.length() - 1)) {
						if(t[i+1].equals("0") || t[i+1].equals("1") || t[i+1].equals("2") ||t[i+1].equals("3") ||t[i+1].equals("4") ||t[i+1].equals("5") ||t[i+1].equals("6") ||t[i+1].equals("7") ||t[i+1].equals("8") ||t[i+1].equals("9") || t[i+1].equals(".")|| t[i+1].equals("a") || t[i+1].equals("b")|| t[i+1].equals("c")|| t[i+1].equals("d")|| t[i+1].equals("e")|| t[i+1].equals("f")|| t[i+1].equals("g")|| t[i+1].equals("h")|| t[i+1].equals("i")|| t[i+1].equals("j")|| t[i+1].equals("k")|| t[i+1].equals("l")|| t[i+1].equals("m")|| t[i+1].equals("n")|| t[i+1].equals("o")|| t[i+1].equals("p")|| t[i+1].equals("q")|| t[i+1].equals("r")|| t[i+1].equals("s")|| t[i+1].equals("t")|| t[i+1].equals("u")|| t[i+1].equals("v")|| t[i+1].equals("w")|| t[i+1].equals("x")|| t[i+1].equals("y")|| t[i+1].equals("z")) {
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
				if(t[i] != null) {
					Matcher m = p.matcher(t[i]);
					if(m.matches()) {
						System.out.print(t[i]+": ");
						t[i] = leia.nextLine();
					}
					
				}
			}
			int pos1 = 0;
			int pos2 = 0;
			boolean par1 = false;
			boolean par2 = false;
			boolean existe = false;
			double re = 0;
			for(int i = 0; i < msg.length(); i++) {
				if(t[i] != null) {
					if(t[i].equals("(")) {
						//String[] s = t[i].split("(");
						pos1 = i;
						par1 = true;
						existe = true;
					}
					if(t[i].equals(")")) {
						pos2 = i;
						par2 = true;
					}
					if((par1 == true) && (par2 == true)) {
						for(int j = pos1+1; j < pos2; j++) {
							if(t[j] != null) {
								if(t[j].equals("+")) {
									if(t[j - 1] != null ) {
										re = Double.parseDouble(t[j - 1]) + Double.parseDouble(t[j + 1]) ;
										t[j] = null;
										t[j + 1] = null;
										t[j  - 1] = null;
									}else {
										re += Integer.parseInt(t[j + 1]);
										t[j] = null;
										t[j + 1] = null;
									}
								}
							}
							if(t[j] != null) {
								if(t[j].equals("-")) {
									if(t[j - 1] != null ) {
										re = Double.parseDouble(t[j - 1]) - Double.parseDouble(t[j + 1]) ;
										t[j] = null;
										t[j + 1] = null;
										t[j - 1] = null;
									}else {
										re -= Integer.parseInt(t[j + 1]);
										t[j] = null;
										t[j + 1] = null;
									}
								}
							}
							if(t[j] != null) {
								if(t[j].equals("*")) {
									if(t[j - 1] != null ) {
										re = Double.parseDouble(t[j - 1]) * Double.parseDouble(t[j + 1]) ;
										t[j] = null;
										t[j + 1] = null;
										t[j  - 1] = null;
									}else {
										re *= Integer.parseInt(t[j + 1]);
										t[j] = null;
										t[j + 1] = null;
									}
								}
							}
							if(t[j] != null) {
								if(t[j].equals("/")) {
									if(t[j - 1] != null ) {
										re = Double.parseDouble(t[j - 1]) / Double.parseDouble(t[j + 1]) ;
										t[j] = null;
										t[j + 1] = null;
										t[j  - 1] = null;
									}else {
										re /= Integer.parseInt(t[j + 1]);
										t[j] = null;
										t[j + 1] = null;
									}
								}
							}
						}
						t[pos1+1] = Double.toString(re);
						par1 =  false;
						par2 = false;
					}
				}
			}
			if(existe == true) {
				for(int i = 0; i < msg.length(); i++) {
					if(t[i] != null) {
						if(t[i].equals("(")) {
							t[i] = null;
						}
						if(t[i] != null) {
							if(t[i].equals(")")) {
								t[i] = null;
							}
						}
					}
				}
				cont = 0;
				for(int i = 0; i < msg.length(); i++) {
					n[i] = null;
				}
				for(int i = 0; i < msg.length(); i++) {
					if(t[i] != null) {
						n[cont] = t[i];
						cont++;
					}
				}
				for(int i = 0; i < msg.length(); i++) {
					t[i] = null;
				}
				for(int i = 0; i < msg.length(); i++) {
					t[i] = n[i];
				} 
			}
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
							re += Double.parseDouble(t[i + 1]);
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
			String resultado = "Resultado: "+re;
			System.out.println(resultado);
			log += resultado;
			Runtime.getRuntime().exec("cmd /C echo "+log+" >> Resultados.txt");
			leia.close();
		}catch(NumberFormatException n) {
			JOptionPane.showMessageDialog(null, "Verifique se vc digitou correto e tente de novo!", "Erro de Digitação!", JOptionPane.ERROR_MESSAGE);
		}catch(NullPointerException nulo) {
			JOptionPane.showMessageDialog(null, "Não aceitamos valores nulos!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no programa por favor consulte o desenvolvedor!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
}