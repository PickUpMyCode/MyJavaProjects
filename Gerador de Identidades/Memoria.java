
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import java.util.Scanner;
public class Memoria {
	private static String [] forms = new String[100];
	private static String caminho ;
	public static int lenght = forms.length;
	private static boolean check = false;
	public static void setCaminho(String cami) {
		caminho = cami;
	}
	public static String getCaminho() {
		return caminho;
	}
	public static void setforms(String valor, int pos) {
		forms[pos] = valor;
	}
	public static String getforms(int pos) throws Exception{
		ler();
		return forms[pos];
	}
	public static void Criar() throws Exception{
		if(caminho != null) {
			String arquivo  = caminho.replace("\\", "/");
			File f = new File(caminho);
			if(f.exists()) {
				//Arquivo Existe
			}else {
				if(f.createNewFile()) {
					System.out.println("Arquivo Criado: "+arquivo);
				}else {
					throw new java.io.IOException("Error!");
				}
			}
		}else {
			System.out.println("Por favor insisra o caminho do arquivo!");
		}
	}
	public static void deletar() {
		File f = new File(caminho);
		if(f.exists()) {
			f.delete();
			String diretorio = caminho.replace("\\","/");
			System.out.println("Arquivo Deletado: "+diretorio);
		}
	}
	public static void deletarUmaLinha(String nome) {
		try {
			ler();
			boolean exists = false;
			String [] restaurar  = new String[100];
			for(int i = 0; i < lenght; i++) {
				if(forms[i] != null) {
					if(forms[i].equals(nome)) {
						exists = true;
						forms[i] = null;
					}
				}
				if(forms[i] != null) {
					restaurar[i] = forms[i];
				}
			}
			if(exists == true) {
				FileWriter f = new FileWriter(caminho);
				f.close();
				for(int i = 0; i < lenght; i++) {
					if(forms[i] != null) {
						forms[i] = restaurar[i];
						escrever(forms[i]);
					}
				}
			}else {
				System.out.println("Essa palavra nao existe na cadeia de dados do arquivo!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void escrever(String conteudo) throws Exception{
		try {
			FileReader r = new FileReader(caminho);
			BufferedReader b = new BufferedReader(r);
			boolean stop = false;
			String [] linha = new String[100];
			String l;
			int conta = 0;
			while((l = b.readLine()) != null) {
				linha[conta] = l;
				conta++;
			}
			FileWriter f  = new FileWriter(caminho);
			BufferedWriter w = new BufferedWriter(f);
			conta = 0;
			while(stop == false) {
				if(linha[conta] == null) {
					stop = true;
					linha[conta] = conteudo;
					w.write(linha[conta]);
					conta++;
				}else{
					w.write(linha[conta]);
					w.newLine();
					conta++;
				}
			}
			b.close();
			w.close();
			f.close();
			r.close();
		}catch(java.io.FileNotFoundException g) {
			System.out.println("Arquivo não encontrado! ");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void ler() {
		try {
			check = true;
			FileReader i = new FileReader(caminho);
			BufferedReader b = new BufferedReader(i);
			String linha;
			int conta = 0;
			while((linha = b.readLine()) != null) {
				if(linha.contains("#") == false) {
					forms[conta] = linha;
					conta++;
				}
			}
			b.close();
			i.close();
			/*for(int j = 0; j < forms.length; j++) {
				if(forms[j] != null) {
					System.out.println(forms[j]);
				}
			}*/
		}catch(java.io.FileNotFoundException g) {
			System.out.println("Arquivo não Encontrado!");
		}catch(Exception ev){
			ev.printStackTrace();
		}
	}
	public static void Dados() {
		if(check == true) {
			for(int j = 0; j < forms.length; j++) {
				if(forms[j] != null) {
					System.out.println(forms[j]);
				}
			}
		}else {
			System.out.println("O arquivo precisa ter sido lido para que possa ser exibido o status");
		}
	}
	/*public static void main(String[] args) throws Exception{
		Memoria.setCaminho("C:\\Users\\Matheus\\Desktop\\Formulas.txt");
		Memoria.deletar();
		Memoria.Criar();
		Memoria.escrever("a");
		Memoria.escrever("b");
		Memoria.ler();
		Memoria.Dados();
		Memoria.deletarUmaLinha("b");
		Memoria.ler();
		Memoria.Dados();
		//Memoria.deletarUmaLinha("b");
		Scanner leia  = new Scanner(System.in);
		boolean stop  = false;
		while(stop == false) {
			String lendo  = leia.nextLine();
			if(lendo.equals("sair")) {
				stop  = true;
			}else {
				Memoria.ecrever(lendo);
				Memoria.ler();
			}
		}
		leia.close();
		System.exit(0);
	}*/
}
