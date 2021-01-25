package Troca_De_Mensagens;

import javax.swing.*;
import java.awt.event.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.*;
import java.util.*;
import java.io.*;

public final class Server extends Thread {
	private String IP;
	private int Port;
	private int porta_cliente;
	private String msg;
	private boolean Interromp = false;
	private JTextArea log = new JTextArea();
	private boolean Change;
	private boolean notSend;
	private String [] ips_clientes;
	private void setIP(String ip){
		this.IP = ip;
	}
	private String getIP(){
		return this.IP;
	}
	private void setPort(int port){
		this.Port = port;
	}
	private int getPort(){
		return this.Port;
	}
	private void setPorta_Cliente(int port){
		this.porta_cliente = port;
	}
	private int getPorta_Cliente(){
		return this.porta_cliente;
	}
	private void setMessage(String msg){
		this.msg = msg;
	}
	private String getMessage(){
		return this.msg;
	}
	private void Criar_Interface(JFrame i) {
		JButton desligar = new JButton("Encerrar Servidor");
		JButton show_ips = new JButton("Mostrar IPs ");
		JLabel info = new JLabel("<html>Todas as informacoes do servidor <br> estao armazenadas no arquivo Log.txt.</html>");
		JLabel title = new JLabel("<html>Servidor Rodando!</html>");
		desligar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interromp = true;
				System.exit(0);
			}
		});
		show_ips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ips ="";
				for(int i = 0; i < ips_clientes.length; i++) {
					if(ips_clientes[i] != null && ips_clientes[i] != "") {
						ips += ips_clientes[i]+"\n";						
					}
				}
				JOptionPane.showMessageDialog(null, ips, "IPS CONECTADOS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.log.setLineWrap(true);
		this.log.setEditable(false);
		this.log.setWrapStyleWord(true);
		this.log.setPreferredSize(new Dimension(200, 200));
		i.setVisible(true);
		i.setSize(300, 150);
		i.setLayout(new FlowLayout());
		i.setResizable(false);
		i.setLocationRelativeTo(null);
		i.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		i.setTitle("Server");
		i.add(title);
		i.add(info);
		i.add(desligar);
		i.add(show_ips);
	}
	public Server(){	
		setPort(4444);
		Criar_Interface(new JFrame());
		start();
	}
	@Override
	public void run(){
		try {		
			ips_clientes = new String[5];
			int cont = 0;
			int i = 0;
			ServerSocket server = new ServerSocket(getPort());
			Runtime.getRuntime().exec("cmd /C echo LOGS DO SISTEMA/CLIENTES > Log.txt");
			Runtime.getRuntime().exec("cmd /C echo ============================ >> Log.txt");		
			String porta_servidor = "O Servidor esta trabalhando na porta "+ getPort();
			Runtime.getRuntime().exec("cmd /C echo "+porta_servidor+" >> Log.txt");
			while(Interromp == false) {
				Socket socket = server.accept();
				String informacoes = "Client: "+socket.getInetAddress().getHostAddress();
				String ip = socket.getInetAddress().getHostAddress();
				Runtime.getRuntime().exec("cmd /C echo "+informacoes+" >> Log.txt");	
				if(i < 5) {
					Scanner s = new Scanner(socket.getInputStream());
					setMessage(s.nextLine());
					if(getMessage().contains("Reply for")) {
						setMessage(getMessage().replace("for ", "for="));
						String [] split = getMessage().split("=");
						String porta_cliente_string = split[1];
						setPorta_Cliente(Integer.parseInt(porta_cliente_string));
						ips_clientes[i] = ip;
						i++;
						Change = true;
						notSend = true;
					}
					else if(getMessage().contains("Client Disconectado%")) {
						String [] split = getMessage().split("%");
						String ip_desconectado = split[1];
						try {
							for(int j = 0; j < ips_clientes.length; j++) {
								if(ips_clientes[j].contains(ip_desconectado)) {
									ips_clientes[j] = "";
								} else {}
							}
						}catch(Exception e) {}
						setMessage("Cliente "+ip_desconectado+" Disconectado!");
					}
					if(Change != true) {
						Runtime.getRuntime().exec("cmd /C echo Mensagem Enviada foi: '"+getMessage()+"' >> Log.txt");
					}else {
						Runtime.getRuntime().exec("cmd /C echo Cliente "+cont+" conectado, Porta para conexao:"+getPorta_Cliente()+" >> Log.txt");
						cont++;
						Change = false;
					}
					if(notSend != true) {
						for(int c = 0; c < ips_clientes.length; c++) {
							try {
								if(ips_clientes[c] != null && ips_clientes[c] != "") {
									Socket cliente = new Socket(ips_clientes[c], getPorta_Cliente());
									PrintWriter w =  new PrintWriter(cliente.getOutputStream());
									w.print(getMessage());
									w.flush();
									w.close();
									s.close();
								}
							}catch(Exception ev) {
								System.out.println("Cliente nao existe!");
							}
						}
					}else {
						notSend = false;                                                
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void Show_Ips() {
		for(int i = 0; i < ips_clientes.length; i++) {
			System.out.printf("IP"+i+"%s %n", ips_clientes[i]);
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}