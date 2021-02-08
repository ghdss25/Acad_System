package view;

//import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.prompt.PromptSupport;

import controller.alunoController;
import controller.conexaoController;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class FramePesquisaAluno extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField PesquisarField;
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

	public JButton btnExcluir;
	
	private alunoController controleAluno = new alunoController();
	private conexaoController controleAcesso = new conexaoController();


//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FramePesquisaAluno frame = new FramePesquisaAluno();
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
	public FramePesquisaAluno(String nomeUsuario, String tipoUsuario) {
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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(800, 510);

		// inicio do bot�o listar
		JButton btnListar = new JButton("Listar Alunos");
		btnListar.setBackground(new Color(47, 79, 79));
		btnListar.setForeground(new Color(0, 255, 255));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controleAluno.listarAlunos(model);

			}
		});
		btnListar.setBounds(23, 433, 137, 23);
		contentPane.add(btnListar);
		// fim do botao listar

		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setForeground(new Color(0, 255, 255));
		table.setBackground(Color.DARK_GRAY);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setGridColor(Color.WHITE);
		model.addColumn("Matricula");
		model.addColumn("Nome");
		model.addColumn("CPF");
		model.addColumn("Telefone");
		model.addColumn("Curso");
		model.addColumn("Sistema");
		model.addColumn("Orientador");
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 774, 399);
		scrollPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Alunos Cadastrados", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
		scrollPane.setBackground(Color.DARK_GRAY);
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
		btnVoltar.setBounds(170, 433, 99, 23);
		contentPane.add(btnVoltar);

		JButton btnPesquisarAluno = new JButton("Pesquisar");
		btnPesquisarAluno.setBackground(new Color(47, 79, 79));
		btnPesquisarAluno.setForeground(new Color(0, 255, 255));
		btnPesquisarAluno.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controleAluno.pesquisarAluno(model, PesquisarField);
			}

		});
		btnPesquisarAluno.setBounds(378, 433, 128, 23);
		contentPane.add(btnPesquisarAluno);

		PesquisarField = new JTextField();
		PromptSupport.setPrompt("Digite o nome do Aluno", PesquisarField);
		PesquisarField.setBackground(new Color(47, 79, 79));
		PesquisarField.setForeground(Color.WHITE);
		PesquisarField.setFont(new Font("Tahoma", Font.BOLD, 11));
		PesquisarField.setBounds(516, 434, 258, 20);
		contentPane.add(PesquisarField);
		PesquisarField.setColumns(10);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(47, 79, 79));
		btnExcluir.setForeground(new Color(0, 255, 255));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controleAluno.btnExcluir(tipoUsuario);
			}
		});
		btnExcluir.setBounds(279, 433, 89, 23);
		contentPane.add(btnExcluir);

		controleAcesso.bloqueiaButtonExcluir(tipoUsuario, btnExcluir);

	}
}
