
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Date;
public class Gerado_Interface extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 187373426031494278L;
	private int Cont = 0;
	private JButton gera = new JButton();
	private JButton gera_varios = new JButton("<html>Gerar Varios<br>Documentos</html>");
	private JButton transferir = new JButton("Copiar para o bloco de notas");
	private JButton abrir_diretorio = new JButton("Abrir Pasta");
	private JLabel titulo = new JLabel("Gerador Pessoal");
	private JPanel painel = new JPanel();
	private JPanel painel1 = new JPanel();
	private JTextArea info = new JTextArea();
	private boolean Informar = true;
	private Image img = ImageIO.read(getClass().getResource("refresh.png"));
	private Image img1 = ImageIO.read(getClass().getResource("documents.png"));
	private String nome = "";
	private String Tipo = "";
	private String CPF = "";
	private String NumeroCartao = "";
	private String NumeroSeg = "";
	private String DataValid = "";
	public Gerado_Interface() throws Exception{
		super("Gerador");
		setVisible(true);
		setSize(280, 410);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		gera.setIconTextGap(5);
		gera.setText("Gerar");
		gera.setIcon(new ImageIcon(img));
		gera.setPreferredSize(new Dimension(120, 50));
		gera_varios.setPreferredSize(new Dimension(150, 60));
		gera_varios.setIcon(new ImageIcon(img1));
		painel.setPreferredSize(new Dimension(200, 150));
		info.setPreferredSize(new Dimension(250, 120));
		info.setLineWrap(true);
		info.setWrapStyleWord(true);
		info.setEditable(false);
		add(painel);
		painel.add(titulo);
		painel.add(gera);
		painel.add(gera_varios);
		add(painel1);
		painel1.add(info);
		gera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerarInfo();
			}
		});
		gera_varios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerarVariosInfo();
			}
		});
		transferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transferir();
			}
		});
		abrir_diretorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("cmd /C start C:\\Users\\Matheus\\Lista\\Informacoes");
				}catch(Exception evt) {
					evt.printStackTrace();
				}
			}
		});
	}
	private void GerarInfo() {
		nome = Gerador.GerarNome().GerarSobreNome();
		Tipo = "Tipo"+Gerador.GerarCPF().getTipoDeDocumento();
		CPF = "Numero do Documento: "+Gerador.getgCPF();
		NumeroSeg = "Numero de Seguranca: "+Gerador.GerarNumeroSeguranca();
		NumeroCartao = "Numero do Cartao: "+Gerador.GerarNumeroCartao();
		DataValid = "Data de Validade: "+Gerador.GerarDataDeVal();
		info.setText(nome+"\n"+CPF+"\n"+NumeroCartao+"\n"+NumeroSeg+"\n"+DataValid);
		if(Informar  == true) {
			add(transferir);
			add(abrir_diretorio);
			repaint();
		} else {
			remove(transferir);
		}
	}
	private void GerarVariosInfo() {
		JFrame quant = new JFrame();
		JLabel titulo = new JLabel("Insira a quantidade");
		JButton conf = new JButton("Confirmar");
		JTextField quantidade = new JTextField(16);
		quant.setTitle("Gerar Varios");
		quant.setVisible(true);
		quant.setSize(250, 125);
		quant.setLocationRelativeTo(null);
		quant.setResizable(false);
		quant.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		quant.setLayout(new FlowLayout());
		quant.add(titulo);
		quant.add(quantidade);
		quant.add(conf);
		quantidade.setText("Insira um numero");
		conf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					quant.setExtendedState(ICONIFIED);
					Informar = false;
					int Quant = Integer.parseInt(quantidade.getText());
					for(int i = 1; i <= Quant; i++) {
						GerarInfo();
						transferir();
					}
					info.setText("Processo Concluido com Êxito!");
					Informar = true;
					add(abrir_diretorio);
					repaint();
					quant.dispose();
				}catch(Exception ev) {
					JOptionPane.showMessageDialog(null, "Apenas Numeros!", "ERROR!",  JOptionPane.ERROR_MESSAGE);
					quant.dispose();
				}
			}
		});
	}
	//Metodo armazena os dados da pessoa em um arquivo tipo texto
	private void transferir() {
		try {
			Cont++;	
			Date data = new Date();
			String nome_arquivo = Integer.toString(Cont);
			Runtime.getRuntime().exec("cmd /C mkdir C:\\Users\\Matheus\\Lista");
			Runtime.getRuntime().exec("cmd /C mkdir C:\\Users\\Matheus\\Lista\\Informacoes");
			Memoria.setCaminho("C:\\Users\\Matheus\\Lista\\Informacoes\\Informacoes_Pessoa_"+nome_arquivo+".txt");
			Memoria.deletar();
			Memoria.Criar();
			Memoria.escrever(nome);
			Memoria.escrever(CPF);
			Memoria.escrever(Tipo);
			Memoria.escrever(NumeroCartao);
			Memoria.escrever(NumeroSeg);
			Memoria.escrever(DataValid);
			Memoria.escrever(data.toString());
			//Process cria_arquivo = Runtime.getRuntime().exec("cmd /C echo "+info.getText()+" > C:\\Users\\Matheus\\Lista\\Informacoes\\Informacoes_Pessoa_"+nome_arquivo+".txt");
			//BufferedReader leia = new BufferedReader(new InputStreamReader(p.getInputStream()));
			if(Informar == true) {
				JOptionPane.showConfirmDialog(null, "Arquivo Informacoes_Pessoa_"+nome_arquivo+".txt", "CRIADO COM SUCESSO!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Arquivo: Informacoes_Pessoa_"+nome_arquivo+".txt - CRIADO COM SUCESSO!");
			}
		}catch(Exception ev) {
			JOptionPane.showMessageDialog(null, "Erro ao Criar!", "ERROR!",  JOptionPane.ERROR_MESSAGE);
			ev.printStackTrace();
		}
	}
}
