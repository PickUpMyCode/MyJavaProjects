package Troca_De_Mensagens;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Cliente1 {
	public static void main(String[] args) {
		try{
			Socket socket = new Socket("127.0.0.1", 4444);
			Scanner a = new Scanner(System.in);
			String msg = a.nextLine();
			PrintWriter w = new PrintWriter(socket.getOutputStream());
			w.print(msg);
			w.flush();
			w.close();
		}catch(Exception e) {
			//Excpetion
		}		
	}
}
