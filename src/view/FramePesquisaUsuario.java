package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.prompt.PromptSupport;

import controller.conexaoController;
import controller.usuarioController;

@SuppressWarnings("serial")
public class FramePesquisaUsuario extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField PesquisarField;
	
	public JButton btnExcluir;

	private usuarioController controleUsuario = new usuarioController();
	private conexaoController controleAcesso = new conexaoController();


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FramePesquisaUsuario frame = new FramePesquisaUsuario();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FramePesquisaUsuario(String nomeUsuario, String tipoUsuario) {
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
		setBounds(100, 100, 800, 526);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnListar = new JButton("Listar Usuarios");
		btnListar.setBackground(new Color(47, 79, 79));
		btnListar.setForeground(new Color(0, 255, 255));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controleUsuario.listarUsuarios(model);
			}
		});
		btnListar.setBounds(23, 447, 175, 23);
		contentPane.add(btnListar);
		// fim do botao listar

		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setForeground(new Color(0, 255, 255));
		table.setBackground(Color.DARK_GRAY);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setGridColor(Color.WHITE);
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Tipo");
		model.addColumn("Telefone");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setBounds(23, 21, 730, 399);
		scrollPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Usuarios Cadastrados", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(47, 79, 79));
		btnVoltar.setForeground(new Color(0, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				FrameMenu telaMenu = new FrameMenu(nomeUsuario, tipoUsuario);
				telaMenu.show();
				dispose();

			}
		});
		btnVoltar.setBounds(208, 447, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnPesquisarCurso = new JButton("Pesquisar");
		btnPesquisarCurso.setBackground(new Color(47, 79, 79));
		btnPesquisarCurso.setForeground(new Color(0, 255, 255));
		btnPesquisarCurso.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controleUsuario.pesquisarUsuario(model, PesquisarField);
			}

		});
		btnPesquisarCurso.setBounds(408, 447, 128, 23);
		contentPane.add(btnPesquisarCurso);

		PesquisarField = new JTextField();
		PromptSupport.setPrompt("Digite o nome do Usu�rio", PesquisarField);
		PesquisarField.setBackground(new Color(47, 79, 79));
		PesquisarField.setForeground(Color.WHITE);
		PesquisarField.setFont(new Font("Tahoma", Font.BOLD, 11));
		PesquisarField.setToolTipText("Digite o nome do Usu�rio");
		PesquisarField.setBounds(546, 448, 207, 20);
		contentPane.add(PesquisarField);
		PesquisarField.setColumns(10);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(47, 79, 79));
		btnExcluir.setForeground(new Color(0, 255, 255));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controleUsuario.btnExcluir();
			}
		});
		btnExcluir.setBounds(309, 447, 89, 23);
		contentPane.add(btnExcluir);
		
		controleAcesso.bloqueiaButtonExcluir(tipoUsuario, btnExcluir);

	}

}
