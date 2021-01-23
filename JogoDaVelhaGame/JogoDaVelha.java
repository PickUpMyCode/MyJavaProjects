package JogoDaVelhaGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JogoDaVelha extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel title = new JLabel("<html><font size='10'>Jogo da Velha!</font></html>");
	private JLabel titleLeft = new JLabel("<html><font size='9'>X</font></html>");
	private JLabel titleRight = new JLabel("<html><font size='9'>O</font></html>");
	private JLabel lblScoreX = new JLabel("<html><font size='6'>0</font></html>");
	private JLabel lblScoreO = new JLabel("<html><font size='6'>0</font></html>");
	//Afastam os componentes um dos outros
	private JLabel espace = new JLabel(" "), espace2 = new JLabel(" ");
	private JPanel principal, velha, leftpanel, rightpanel;
	private JButton buttons[] = new JButton[9];
	private JButton reniciar = new JButton("Reniciar");
	private Icon x, o;
	private char velhamap[][] = new char[][] {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
	private boolean turn = true, isEnded = false;
	private int scoreX = 0, scoreY = 0;
	//true - a vez do X. false - a vez do O
	public JogoDaVelha() {
		Design();
		IconsPresetting();	
		ButtonEvents();
		SettingUpComponents();
		SwingUtilities.updateComponentTreeUI(this);
	}
	//Organizando os java components
	private void SettingUpComponents() {
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		add(leftpanel, gbc2);
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		add(principal, gbc2);
		gbc2.gridx = 2;
		gbc2.gridy = 0;
		add(rightpanel, gbc2);
		
		leftpanel.add(titleLeft, BorderLayout.NORTH);
		leftpanel.add(lblScoreX, BorderLayout.CENTER);
		rightpanel.add(titleRight, BorderLayout.NORTH);
		rightpanel.add(lblScoreO, BorderLayout.CENTER);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		principal.add(title, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		principal.add(espace, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		principal.add(velha, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		principal.add(espace2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		principal.add(reniciar, gbc);

	}
	//Verifica se ouve um ganhador
	private boolean checkout() {
		if(velhamap[0][0] == velhamap[0][1] && velhamap[0][1] == velhamap[0][2]) {
			return true;
		}else if(velhamap[1][0] == velhamap[1][1] && velhamap[1][1] == velhamap[1][2]) {
			return true;
		}else if(velhamap[2][0] == velhamap[2][1] && velhamap[2][1] == velhamap[2][2]) {
			return true;
		}else if(velhamap[0][0] == velhamap[1][0] && velhamap[1][0] == velhamap[2][0]) {
			return true;
		}else if(velhamap[0][1] == velhamap[1][1] && velhamap[1][1] == velhamap[2][1]) {
			return true;
		}else if(velhamap[0][2] == velhamap[1][2] && velhamap[1][2] == velhamap[2][2]) {
			return true;
		}else if(velhamap[0][0] == velhamap[1][1] && velhamap[1][1] == velhamap[2][2]) {
			return true;
		}else if(velhamap[2][0] == velhamap[1][1] && velhamap[1][1] == velhamap[0][2]) {
			return true;
		}else {
			//Verifica se todos os botões foram preenchidos mas não houve nenhuma ocorrencia de vitoria
			if((velhamap[0][0] == 'x' || 
					velhamap[0][0] == 'o' )&&
					(velhamap[0][1] == 'x' || 
					velhamap[0][1] == 'o') && 
					(velhamap[0][2] == 'x' || 
					velhamap[0][2] == 'o') && 
					(velhamap[1][0] == 'x' ||
					velhamap[1][0] == 'o') && 
					(velhamap[1][1] == 'x' || 
					velhamap[1][1] == 'o') &&
					(velhamap[1][2] == 'x' || 
					velhamap[1][2] == 'o') && 
					(velhamap[2][0] == 'x' || 
					velhamap[2][0] == 'o') && 
					(velhamap[2][1] == 'x' ||
					velhamap[2][1] == 'o') && 
					(velhamap[2][2] == 'x' || 
					velhamap[2][2] == 'o')) 
			{
				GameEndedWithVeia();
			}
			return false;
		}
	}
	//Obtem as imgens do X e do O
	private void IconsPresetting(){
		try {
			Image x = new ImageIcon(this.getClass().getResource("X.png")).getImage();
			Image o = new ImageIcon(this.getClass().getResource("O.png")).getImage();	
			this.x = new ImageIcon(x);
			this.o = new ImageIcon(o);
		}catch(NullPointerException ex){
			System.out.print("Erro ao achar a imagem!" );
		}catch(Exception ex) {
			System.out.println("Erro desconhecido!" );
			ex.printStackTrace();
		}
	}
	//Define o design da Aplicação
	private void Design() {
		setTitle("Jogo Da Velha");
		setSize(600, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLayout(FormLayout());
		setResizable(false);
		velha = new JPanel(); 
		velha.setLayout(new GridLayout(3, 3));
		velha.setPreferredSize(new Dimension(300, 300));
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			velha.add(buttons[i]);
		}	
		principal = new JPanel();
		principal.setLayout(PrincipalLayout());
		principal.setPreferredSize(new Dimension(400, 500));
		reniciar.setPreferredSize(new Dimension(100, 50));
		reniciar.setVisible(false);
		leftpanel = new JPanel();
		leftpanel.setPreferredSize(new Dimension(50, 100));
		leftpanel.setLayout(new BorderLayout());
		rightpanel = new JPanel();
		rightpanel.setPreferredSize(new Dimension(50, 100));
		rightpanel.setLayout(new BorderLayout());
	}
	//Retorna o layout desejado
	private GridBagLayout FormLayout(){
		GridBagLayout g = new GridBagLayout();
		return g;
	}
	private GridBagLayout PrincipalLayout(){
		GridBagLayout g = new GridBagLayout();
		return g;
	}
	private void GameEnded() {
		isEnded = true;
		if(turn) {turn=false; scoreY++; lblScoreO.setText(Integer.toString(scoreY));}
		else {turn = true; scoreX++; lblScoreX.setText(Integer.toString(scoreX));}		
		reniciar.setVisible(true);
		JOptionPane.showMessageDialog(null, "TEMOS UM GANHADOR!");
	}
	private void GameEndedWithVeia() {
		isEnded = true;
		if(turn) {turn=false;}else {turn = true;}	
		reniciar.setVisible(true);
		JOptionPane.showMessageDialog(null, "DEU VEIA!");
	}
	private void restart() {
		int cont = 1;
		isEnded = false;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				velhamap[i][j] = Integer.toString(cont).charAt(0);
				cont++;
			}
		}
		for(int i = 0; i < 9; i++) {
			buttons[i].setIcon(null);
			buttons[i].setEnabled(true);
		}
		reniciar.setVisible(false);
	}
	//Eventos dos botões
	private void ButtonEvents() {
		buttons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isEnded) {
					if(turn) {
						velhamap[0][0] = 'x';
						buttons[0].setIcon(x);
						turn = false;
					}else {
						velhamap[0][0] = 'o';
						buttons[0].setIcon(o);
						turn = true;
					}
					buttons[0].setEnabled(false);
					if(checkout()) {
						GameEnded();
					}
				}
			}
		});
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isEnded) {
					if(turn) {
						velhamap[0][1] = 'x';
						buttons[1].setIcon(x);
						turn = false;
					}else {
						velhamap[0][1] = 'o';
						buttons[1].setIcon(o);
						turn = true;
					}
					buttons[1].setEnabled(false);
					if(checkout()) {
						GameEnded();
					}
				}
			}
		});
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isEnded) {
					if(turn) {
						velhamap[0][2] = 'x';
						buttons[2].setIcon(x);
						turn = false;
					}else {
						velhamap[0][2] = 'o';
						buttons[2].setIcon(o);
						turn = true;
					}
					buttons[2].setEnabled(false);
					if(checkout()) {
						GameEnded();
					}
				}
			}
		});
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isEnded) {
					if(turn) {
						velhamap[1][0] = 'x';
						buttons[3].setIcon(x);
						turn = false;
					}else {
						velhamap[1][0] = 'o';
						buttons[3].setIcon(o);
						turn = true;
					}
					buttons[3].setEnabled(false);
					if(checkout()) {
						GameEnded();
					}
				}
			}
		});
		buttons[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isEnded) {
					if(turn) {
						velhamap[1][1] = 'x';
						buttons[4].setIcon(x);
						turn = false;
					}else {
						velhamap[1][1] = 'o';
						buttons[4].setIcon(o);
						turn = true;
					}
					buttons[4].setEnabled(false);
					if(checkout()) {
						GameEnded();
					}
				}
			}
		});
		buttons[5].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isEnded) {
					if(turn) {
						velhamap[1][2] = 'x';
						buttons[5].setIcon(x);
						turn = false;
					}else {
						velhamap[1][2] = 'o';
						buttons[5].setIcon(o);
						turn = true;
					}
					buttons[5].setEnabled(false);
					if(checkout()) {
						GameEnded();
					}
				}
			}
		});
		buttons[6].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isEnded) {
					if(turn) {
						velhamap[2][0] = 'x';
						buttons[6].setIcon(x);
						turn = false;
					}else {
						velhamap[2][0] = 'o';
						buttons[6].setIcon(o);
						turn = true;
					}
					buttons[6].setEnabled(false);
					if(checkout()) {
						GameEnded();
					}
				}
			}
		});
		buttons[7].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isEnded) {
					if(turn) {
						velhamap[2][1] = 'x';
						buttons[7].setIcon(x);
						turn = false;
					}else {
						velhamap[2][1] = 'o';
						buttons[7].setIcon(o);
						turn = true;
					}
					buttons[7].setEnabled(false);
					if(checkout()) {
						GameEnded();
					}
				}
			}
		});
		buttons[8].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isEnded) {
					if(turn) {
						velhamap[2][2] = 'x';
						buttons[8].setIcon(x);
						turn = false;
					}else {
						velhamap[2][2] = 'o';
						buttons[8].setIcon(o);
						turn = true;
					}
					buttons[8].setEnabled(false);
					if(checkout()) {
						GameEnded();
					}
				}
			}
		});
		reniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				restart();
			}
		});
	}
	public static void main(String[] args) {
		new JogoDaVelha();
	}
}
