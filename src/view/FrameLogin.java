package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.conexaoController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;
	private conexaoController acessarcontrole = new conexaoController();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameLogin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				setResizable(false);
				setLocationRelativeTo(null);
			}
		});
		setTitle("AcadSystem");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/Graduation Cap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBackground(SystemColor.textInactiveText);
		btnAcessar.setForeground(new Color(0, 255, 255));
		btnAcessar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				boolean conectado;
				conectado = acessarcontrole.btnAcessar(loginField, passwordField);

				if (conectado == true) {
					dispose();
					System.out.println("LOGIN E SENHA CORRETOS ! - FrameLogin");
				}else{
					System.out.println("LOGIN E SENHA ERRADO ! - FrameLogin");
				}

			}
		});
		btnAcessar.setBounds(26, 233, 225, 25);
		contentPane.add(btnAcessar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(0, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(48, 133, 56, 16);
		contentPane.add(lblNome);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(0, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(48, 190, 56, 16);
		contentPane.add(lblSenha);

		loginField = new JTextField();
		loginField.setForeground(Color.WHITE);
		loginField.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginField.setBackground(new Color(47, 79, 79));
		loginField.setBounds(94, 130, 136, 22);
		contentPane.add(loginField);
		loginField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBackground(new Color(47, 79, 79));
		passwordField.setBounds(94, 187, 136, 22);
		contentPane.add(passwordField);

		
		
		JLabel lblUser = new JLabel("");
		Image imgUser = new ImageIcon (this.getClass().getResource("/login user.png")).getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
		lblUser.setIcon(new ImageIcon(imgUser));
		lblUser.setBounds(94, 20, 100, 90);
		contentPane.add(lblUser);
		
	}
}
