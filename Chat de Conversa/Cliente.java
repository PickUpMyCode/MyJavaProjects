package Troca_De_Mensagens;

import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Cliente extends Thread{
	private JTextArea chat = new JTextArea();
	private int port;
	private String msg;
	private String nickname;
	private boolean interrup = false;
	public Cliente() {
		setPort(5555);
		GUI(new JFrame());
		Requisicao();
		start();
	}
	private void setMessage(String msg) {
		this.msg = msg;
	}
	private String getMessage() {
		return this.msg;
	}
	private void setNickname(String nick) {
		this.nickname = nick;
	}
	private String getNickname() {
		return this.nickname;
	}
	private void setPort(int porta) {
		this.port = porta;
	}
	private int getPort() {
		return this.port;
	}
	@Override
	public void run() {	
		int cont = 0;
		int cont1 = 0;
		String texto = "";
		while(interrup == false) {
		try {
			ServerSocket server = new ServerSocket(port);
			while(true) {
				try{				
					cont++;
					Socket socket = server.accept();	
					Scanner s = new Scanner(socket.getInputStream());
					if(cont == 1) {
						setMessage(s.nextLine());
						texto += getMessage() + "\n";
						chat.setText(texto);
					}
					cont = 0;
				}catch(java.net.BindException ev) {
					cont1++;
					server.close();
					if(cont1 == 1) {
						JOptionPane.showMessageDialog(null, "Ja existe um cliente aberto!", "ERROR!", JOptionPane.ERROR_MESSAGE);
					}
				}catch(java.util.NoSuchElementException noLine) {
					JOptionPane.showMessageDialog(null, "Server Parece estar OFF!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	}
	private void Requisicao() {
		int cont = 0;	
		final String requisicao = "Reply for "+getPort();
		boolean reconnect = true;
		while(reconnect == true) {
			try {
				@SuppressWarnings("resource")
				Socket socket = new Socket("192.168.1.175", 4444);				
				cont++;
				if(cont == 1) {
					JOptionPane.showMessageDialog(null, "Conectado! ", "INFO", JOptionPane.INFORMATION_MESSAGE);
				}
				PrintWriter w = new PrintWriter(socket.getOutputStream());
				w.print(requisicao);
				w.flush();
				w.close();		
				reconnect = false;
			}catch(java.net.ConnectException co) {
				cont++;
				if(cont == 1) {
					JOptionPane.showMessageDialog(null, "Servidor esta fora do ar!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	//Adicionar barra de rolagem ao JTextArea
	private void GUI(JFrame i) {
		JFrame frame = new JFrame();
		JLabel title = new JLabel("Chat de Conversas");	
		JPanel painel = new JPanel();
		JTextField text = new JTextField(16);
		JButton send = new JButton("Enviar");
		JButton exit = new JButton("Sair");
		JLabel title1 = new JLabel("Insira o seu Nickname:");
		JTextField nick = new JTextField(16);
		JButton escolher_nick = new JButton("Ok");
		JScrollPane scroll = new JScrollPane(this.chat);
		//JScrollBar vertical = scroll.getVerticalScrollBar();
		//vertical.setValue(vertical.getMaximum());
		i.setVisible(false);
		frame.setTitle("Nickname");
		frame.setVisible(true);
		frame.setSize(270, 120);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(title1);
		frame.add(nick);
		frame.add(escolher_nick);
		frame.getRootPane().setDefaultButton(escolher_nick);
		escolher_nick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(nick.getText() == "" || nick.getText() == null || nick.getText().length() < 3 || nick.getText().length() > 15) {
					JOptionPane.showMessageDialog(null, "Por favor insira um nome de 3 a 15 caracteres!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}else{
					setNickname(nick.getText());
					i.setVisible(true);
					frame.dispose();
				}
			}
		});
		i.setTitle("Chat");
		i.setSize(300, 350);
		i.setResizable(false);
		i.setLayout(new FlowLayout());
		i.setLocationRelativeTo(null);
		i.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.chat.setLineWrap(true);
		this.chat.setEditable(false);
		this.chat.setWrapStyleWord(true);
		scroll.setPreferredSize(new Dimension(250, 200));
		i.add(title);
		i.add(scroll);
		i.add(painel);
		painel.add(text);
		painel.add(send);
		i.add(exit);
		i.getRootPane().setDefaultButton(send);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Socket socket = new Socket("192.168.1.175", 4444);
					PrintWriter w = new PrintWriter(socket.getOutputStream());
					String ip = socket.getLocalAddress().toString();
					if(ip.contains("/")) {
						String [] split = ip.split("/");
						ip = split[1];
					}
					w.print("Client Disconectado%"+ip);
					w.flush();
					w.close();
				}catch(java.net.ConnectException e) {
					System.out.printf("%s", "Falha ao se conectar!");
				}catch(Exception ev){
					ev.printStackTrace();
				}finally {
					interrup = false;
					System.exit(0);
				}
			}
		});
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int cont = 0;
				try {
					Socket socket = new Socket("192.168.1.175", 4444);
					if(text.getText() != null  && text.getText() != "") {								
						PrintWriter wr = new PrintWriter(socket.getOutputStream());
						wr.print(getNickname()+":"+text.getText());
						wr.flush();
						wr.close();
					}else {
						JOptionPane.showMessageDialog(null, "Insira alguma coisa!");
					}
				}catch(java.net.ConnectException co) {
					cont++;
					if(cont == 1) {
						JOptionPane.showMessageDialog(null, "Servidor esta fora do ar!", "ERROR!", JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}finally {
					text.setText("");
				}
			}
		});
	}
	public static void main(String[] args) {
		new Cliente();
	}
}