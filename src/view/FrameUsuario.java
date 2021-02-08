package view;

import java.awt.Toolkit;
//import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import controller.mascaraController;
import controller.usuarioController;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class FrameUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JPasswordField senhaField;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipo;

	private usuarioController controleUsuario = new usuarioController();

	private JTextField telefoneField;
	private JTextField idField;

	private mascaraController mascara = new mascaraController();

	//
	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FrameUsuario frame = new FrameUsuario();
	// frame.setVisible(true);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrameUsuario(String nomeUsuario, String tipoUsuario) {
		addWindowListener(new WindowAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void windowClosing(WindowEvent e) {
				FrameMenu frameMenu = new FrameMenu(nomeUsuario, tipoUsuario);
				frameMenu.show();
				dispose();
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				setResizable(false);
				setLocationRelativeTo(null);
			}
		});
		setTitle("AcadSystem");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/Graduation Cap.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 525, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GERENCIAR USU\u00C1RIO", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("*Nome:");
		lblNome.setForeground(new Color(0, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(167, 32, 51, 14);
		contentPane.add(lblNome);

		JLabel lblTipo = new JLabel("*Tipo:");
		lblTipo.setForeground(new Color(0, 255, 255));
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setBounds(10, 125, 58, 14);
		contentPane.add(lblTipo);

		JLabel lblSenha = new JLabel("*Senha:");
		lblSenha.setForeground(new Color(0, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(10, 86, 58, 14);
		contentPane.add(lblSenha);

		nomeField = new JTextField();
		nomeField.setForeground(Color.WHITE);
		nomeField.setBackground(new Color(47, 79, 79));
		nomeField.setFont(new Font("Dialog", Font.BOLD, 13));
		nomeField.setBounds(228, 29, 269, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);

		senhaField = new JPasswordField();
		senhaField.setForeground(Color.WHITE);
		senhaField.setBackground(new Color(47, 79, 79));
		senhaField.setFont(new Font("Dialog", Font.BOLD, 13));
		senhaField.setBounds(72, 82, 180, 20);
		contentPane.add(senhaField);

		cbTipo = new JComboBox();
		cbTipo.setForeground(Color.WHITE);
		cbTipo.setBackground(new Color(47, 79, 79));
		cbTipo.setFont(new Font("Dialog", Font.BOLD, 13));
		cbTipo.setBounds(56, 122, 441, 20);
		contentPane.add(cbTipo);
		cbTipo.addItem("Selecione");
		cbTipo.addItem("ADMINISTRADOR");
		cbTipo.addItem("NORMAL");

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controleUsuario.btnSalvar(cbTipo, idField, nomeField, telefoneField, senhaField);
			}
		});
		btnSalvar.setBackground(new Color(47, 79, 79));
		btnSalvar.setForeground(new Color(0, 255, 255));
		btnSalvar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnSalvar.setBounds(103, 177, 85, 23);
		contentPane.add(btnSalvar);

		telefoneField = new JFormattedTextField(mascara.mascaraTelefone());
		telefoneField.setForeground(Color.WHITE);
		telefoneField.setBackground(new Color(47, 79, 79));
		telefoneField.setFont(new Font("Dialog", Font.BOLD, 13));
		telefoneField.setBounds(349, 82, 148, 20);
		contentPane.add(telefoneField);
		telefoneField.setColumns(10);

		JLabel lblFone = new JLabel("Telefone:");
		lblFone.setForeground(new Color(0, 255, 255));
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFone.setBounds(279, 86, 73, 14);
		contentPane.add(lblFone);

		idField = new JTextField();
		idField.setForeground(Color.WHITE);
		idField.setBackground(new Color(47, 79, 79));
		controleUsuario.gerarID(idField);
		idField.setEnabled(false);
		idField.setFont(new Font("Dialog", Font.BOLD, 13));
		idField.setBounds(56, 29, 73, 20);
		contentPane.add(idField);
		idField.setColumns(10);

		JLabel lblid = new JLabel("*ID:");
		lblid.setForeground(new Color(0, 255, 255));
		lblid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblid.setBounds(10, 32, 51, 14);
		contentPane.add(lblid);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleUsuario.btnEditar(cbTipo, idField, nomeField, telefoneField, senhaField);
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setBackground(new Color(47, 79, 79));
		btnEditar.setForeground(new Color(0, 255, 255));
		btnEditar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnEditar.setBounds(198, 177, 85, 23);
		contentPane.add(btnEditar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controleUsuario.btnPesquisar(btnSalvar, btnEditar, cbTipo, idField, nomeField, telefoneField,
						senhaField);
			}
		});
		btnPesquisar.setBackground(new Color(47, 79, 79));
		btnPesquisar.setForeground(new Color(0, 255, 255));
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnPesquisar.setBounds(293, 177, 112, 23);
		contentPane.add(btnPesquisar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				FrameMenu frameMenu = new FrameMenu(nomeUsuario, tipoUsuario);
				frameMenu.show();
				dispose();
			}
		});
		btnVoltar.setBackground(new Color(47, 79, 79));
		btnVoltar.setForeground(new Color(0, 255, 255));
		btnVoltar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVoltar.setBounds(417, 177, 80, 23);
		contentPane.add(btnVoltar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setBackground(new Color(47, 79, 79));
		btnNovo.setForeground(new Color(0, 255, 255));
		btnNovo.setFont(new Font("Dialog", Font.BOLD, 11));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controleUsuario.ClearFields(idField, nomeField, telefoneField, senhaField);
				controleUsuario.DesbloquearFields(cbTipo, idField, nomeField, telefoneField, senhaField);
				controleUsuario.PosicionarCombobox(cbTipo);

				controleUsuario.gerarID(idField);
			}
		});
		btnNovo.setBounds(10, 177, 80, 23);
		contentPane.add(btnNovo);
	

	}
}
