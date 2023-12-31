package VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import DAO.ControleSessaoDAO;
import VO.ControleSessaoVO;

public class MenuPrincipalVIEW extends JFrame {

	private Container container;
	private JLabel lblAnakin;
	private JLabel sombraAnakin;
	private JLabel lblimagem;
	private ImageIcon imgIcon;
	private JButton btnControlSessao;
	private JMenuBar mnbBarra;
	private JMenu mnConfig;
	private JMenuItem miLogout, miSair;
	private JMenu mnSessoes;
	private static String JP;

	public static String getJP() {
		return JP;
	}

	// private ImageIcon botao;
	// private JLabel lblBotao;

	public MenuPrincipalVIEW() {

		this.setTitle("Projeto ANAKIN ★ ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(300, 200, 940, 550);
		this.setLayout(null);
		this.setBackground(new Color(250, 247, 255));
		this.container = getContentPane();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DoraliceMarques\\Downloads\\jupiter.png"));

		this.lblAnakin = new JLabel("ANAKIN");
		this.lblAnakin.setBounds(255, 100, 400, 165);
		this.lblAnakin.setForeground(new Color(90, 61, 171));
		this.lblAnakin.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblAnakin.setFont(new Font("Arial", Font.BOLD, 85));
		this.add(lblAnakin);

		this.sombraAnakin = new JLabel("ANAKIN");
		this.sombraAnakin.setBounds(260, 100, 400, 165);
		this.sombraAnakin.setForeground(new Color(204, 192, 228));
		this.sombraAnakin.setHorizontalAlignment(SwingConstants.CENTER);
		this.sombraAnakin.setFont(new Font("Arial", Font.BOLD, 85));
		this.add(sombraAnakin);

		this.btnControlSessao = new JButton("Controle de Sessao");
		this.btnControlSessao.setFont(new Font("Arial Black", Font.BOLD, 14));
		this.btnControlSessao.setBounds(360, 240, 200, 40);
		this.btnControlSessao.setBackground(new Color(90, 61, 171));
		this.btnControlSessao.setForeground(Color.white);
		this.btnControlSessao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// recebe o nome da sessao
				String JP = JOptionPane.showInputDialog(null, "Insira Nome");
				ControleSessaoVO objnome =  new ControleSessaoVO();
				
				objnome.setNome_sessao(JP);
				//nomesessao.salvarInformacoes(objnome);
				
				Object nomeSessao;
				JMenuItem miNomesSessoes = new JMenuItem();
				mnSessoes.add(miNomesSessoes);

				if (JP == null)
					System.out.println("Não colocou o nome");
				else
					System.out.println("Colocou o Nome: " + JP);
				ControleSessaoVIEW abre = new ControleSessaoVIEW();
				abre.setTitle(JP);
				abre.setVisible(true);

			}

		});

		this.add(btnControlSessao);

		this.mnbBarra = new JMenuBar();
		this.setJMenuBar(mnbBarra);

		this.mnConfig = new JMenu("Configurações");
		this.mnConfig.setMnemonic('C');
		this.mnbBarra.add(mnConfig);

		this.miLogout = new JMenuItem("Logout");
		this.miLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialVIEW telaInicial = new TelaInicialVIEW();
				telaInicial.setVisible(true);

			}
		});
		this.mnConfig.add(miLogout);

		this.miSair = new JMenuItem("Sair");
		this.miSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		this.mnConfig.add(miSair);

		this.mnSessoes = new JMenu("Minhas Sessões");
		this.mnSessoes.setMnemonic('M');
		this.mnSessoes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MinhasSessoesVIEW tela = new MinhasSessoesVIEW();
				tela.setVisible(true);
			}
		});
		this.mnbBarra.add(mnSessoes);

		/*
		 * botao = new ImageIcon(getClass().getResource("botao.png")); lblBotao = new
		 * JLabel(botao); lblBotao.setBounds(200,200,100,100); add(lblBotao);
		 * 
		 */
	}

}