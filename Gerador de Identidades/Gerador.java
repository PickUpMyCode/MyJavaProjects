
public final class Gerador {
	//Nota: O Gerador de CNPJ precisa ser desenvolvido
	private static String TipoDeDocumento;
	private static String gCPF;
	private static String gCNPJ;
	private static String primeiro_nome;
	private static String segundo_nome;
	private static String numero_cartao;
	private static String numero_de_seguranca;
	private static String data_de_val;
	private static boolean GeradoCPF;
	private static boolean GeradoCNPJ;
	private static boolean primeiro_nome_gerado;
	private static boolean segundo_nome_gerado;
	private static boolean numero_cartao_gerado;
	private static boolean numDeSeg_gerado;
	private static boolean DataVal_gerado;
	//Metodos Getters e Setters
	public static void setPrimeiroNome(String p_nome) {
		primeiro_nome = p_nome;
	}
	public static String getPrimeiroNome() {
		if(primeiro_nome_gerado == true) {
			return primeiro_nome;
		}else {
			return "Nome nao gerado ainda!";
		}
	}
	public static void setSegundoNome(String s_nome) {
		segundo_nome = s_nome;
	}
	public static String getSegundoNome() {
		if(segundo_nome_gerado == true) {
			return segundo_nome;
		}else {
			return "Sobrenome nao gerado ainda!";
		}
	}
	public static void setDocumento(String Tipo){
		TipoDeDocumento = Tipo;
	}
	public static String getDocumento(){
		return TipoDeDocumento;
	}
	private static void setNumeroCartao(String nu) {
		numero_cartao = nu;
	}
	public static String getNumeroCartao() {
		if(numero_cartao_gerado == true) {
			return numero_cartao;
		}else {
			return "Numero do cartao ainda nao foi gerado";
		}
	}
	private static void setNumeroDeSeg(String seg) {
		numero_de_seguranca = seg;
	}
	public static String getNumeroDeSeg() {
		if(numDeSeg_gerado == true) {
			return numero_de_seguranca;
		}else {
			return "Numero de seguranca ainda nao foi gerado";
		}
	}
	private static void setDataVal(String val) {
		data_de_val = val;
	}
	public static String getDataVal() {
		if(DataVal_gerado == true) {
			return data_de_val;
		}else {
			return "Data de validade do cartao ainda nao foi gerado";
		}
	}
	public static String getgCPF(){
		if(GeradoCPF == true){
			return gCPF;
		} else {
			return "Codigo ainda nao foi Gerado!";
		}
	}
	public static String getgCNPJ(){
		if(GeradoCNPJ == true){
			return gCNPJ;
		} else {
			return "Codigo ainda nao foi Gerado!";
		}
	}
	//Fim
	//Gera o CPF
	public final static Gerador GerarCPF(){
		setDocumento("CPF");
		gCPF = "";
		String [] CPF = new String[11];
		for(int i = 0; i < CPF.length; i++){			
			int num = (int) (Math.random()*10); 
			CPF[i] = Integer.toString(num);
			if(i == 3) {
				gCPF += ".";
			}
			else if(i == 6) {
				gCPF += ".";
			}
			else if(i == 9) {
				gCPF += "-";
			}
			gCPF += CPF[i];
		}
		GeradoCPF = true;
		return new Gerador();
	}
	//Gera o CNPJ
	public final static Gerador GerarCNPJ(){
		setDocumento("CNPJ");
		gCNPJ = "";
		String [] CNPJ = new String[14];
		for(int i = 0; i < CNPJ.length; i++){			
			int num = (int) (Math.random()*10); 
			CNPJ[i] = Integer.toString(num);
			if(i == 2) {
				gCNPJ += ".";
			}
			else if(i == 5) {
				gCNPJ += ".";
			}
			else if(i == 8) {
				gCNPJ += "/";
			}
			else if(i == 12) {
				gCNPJ += "-";
			}
			gCNPJ += CNPJ[i];
		}
		GeradoCNPJ = true;
		return new Gerador();
	}
	public final static Gerador GerarNome(){
		String [] nomes = new String[20];
		nomes[0] = "Adalia";
		nomes[1] = "Agnes";
		nomes[2] = "Alice";
		nomes[3] =  "Anabela";
		nomes[4] = "Amanda";
		nomes[5] = "Ana";
		nomes[6] = "Beatriz";
		nomes[7] = "Antonela";
		nomes[8] = "Aurora";
		nomes[9] = "Angelina";
		nomes[10] = "Marcos";
		nomes[11] = "Matheus";
		nomes[12] = "Caio";
		nomes[13] = "Caetano";
		nomes[14] = "Davi";
		nomes[15] = "Eduardo";
		nomes[16] = "Dante";
		nomes[17] = "Francisco";
		nomes[18] = "George";
		nomes[19] = "Heitor";
		for(int i = 0; i < 100; i++){
			int num = (int) (Math.random()*10 + Math.random()*10);
			if(num > 19){
				num -= 1;
				setPrimeiroNome(nomes[num]);
			} else {
				setPrimeiroNome(nomes[num]);
			}
		}
		primeiro_nome_gerado = true;
		return new Gerador();
	}
	public final static String GerarSobreNome() {
		String [] nomes = new String[20];
		nomes[0] = "Muniz";
		nomes[1] = "Monteiro";
		nomes[2] = "Miller";
		nomes[3] =  "Marques";
		nomes[4] = "Duarte";
		nomes[5] = "Fagundes";
		nomes[6] = "Trindade";
		nomes[7] = "Vargas";
		nomes[8] = "Viana";
		nomes[9] = "Ferraz";
		nomes[10] = "Andrade";
		nomes[11] = "Carvalho";
		nomes[12] = "Dantas";
		nomes[13] = "Santana";
		nomes[14] = "Gomes";
		nomes[15] = "Steves";
		nomes[16] = "Moura";
		nomes[17] = "Antunes";
		nomes[18] = "Roriz";
		nomes[19] = "Ferrari";
		String sobrenome = "";
		for(int i = 0; i < 100; i++) {
			int num = (int) (Math.random()*10 + Math.random()*10);
			if(num > 19) {
				num -= 1;
				setSegundoNome(nomes[num]);
			} else {
				setSegundoNome(nomes[num]);
			}
		}
		segundo_nome_gerado = true;
		return "Nome do Proprietario: "+getPrimeiroNome()+" "+getSegundoNome();
	}
	//Tipo de Documento [CPF || CNPJ]
	public final String getTipoDeDocumento(){
		return " Tipo de Documento: "+getDocumento();
	}
	public static final String GerarNumeroCartao() {
		String numero [] = new String[16];
		String numero_total = "";
		for(int i = 0; i < numero.length; i++) {
			int num = Gera.Random(1); 
			numero[i] = Integer.toString(num);
			if(i == 3) {
				numero[3] += " ";
			}
			if(i == 7) {
				numero[7] += " ";
			}
			if(i == 11) {
				numero[11] += " ";
			}
			numero_total += numero[i];
		}
		numero_cartao_gerado = true;
		setNumeroCartao(numero_total);
		return getNumeroCartao();
	}
	public static final String GerarNumeroSeguranca() {
		String [] numero_de_seguranca = new String[3];
		String resultado = "";
		for(int i = 0; i < numero_de_seguranca.length; i++) {
			int num = Gera.Random(1);
			numero_de_seguranca[i] = Integer.toString(num);
			resultado += numero_de_seguranca[i];
		}
		numDeSeg_gerado = true;
		setNumeroDeSeg(resultado);
		return getNumeroDeSeg();
	}
	public static final String GerarDataDeVal() {
		int mes = 0, ano = 0;
		String data_val = "";
		boolean gera = true;
		while(gera == true){
			mes = Gera.Random(1) + Gera.Random(1);
			ano = Gera.Random(2);
			if(mes < 12 && mes > 0) {
				if(ano > 19 && ano < 32) {
					data_val = Integer.toString(mes) +"/"+Integer.toString(ano);	
					gera = false;
				}
			} 
		}
		setDataVal(data_val);
		DataVal_gerado = true;
		return getDataVal();
	}
}