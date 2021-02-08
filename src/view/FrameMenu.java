package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import controller.conexaoController;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class FrameMenu extends JFrame {
	

	private JPanel contentPane;
	private JButton btnCurso;
	private JButton btnAluno;
	private JButton btnOrientador;
	private JButton btnUsuario;
	private JButton btnPublicacao;
	private JLabel lblUsuario;
	private conexaoController conexao = new conexaoController();

	
			
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
	public FrameMenu(String nomeUsuario, String tipoUsuario) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				setResizable(false);
				setLocationRelativeTo(null);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void windowClosing(WindowEvent e) {
				FrameLogin frameLogin = new FrameLogin();
				frameLogin.show();
			}
		});
		setTitle("AcadSystem");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/Graduation Cap.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 752, 360);		
										
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				
		JPanel panelGerenciamento = new JPanel();
		panelGerenciamento.setBackground(Color.DARK_GRAY);
		panelGerenciamento.setBounds(31, 32, 318, 253);
		panelGerenciamento.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gerencenciamento", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));

		
		JPanel panelPesquisas = new JPanel();
		panelPesquisas.setBackground(Color.DARK_GRAY);
		panelPesquisas.setBounds(391, 32, 318, 177);
		panelPesquisas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pesquisas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));


		JLabel label_3 = new JLabel("Por Aluno");
		label_3.setForeground(new Color(0, 255, 255));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel label_5 = new JLabel("Por Orientador");
		label_5.setForeground(new Color(0, 255, 255));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblPorPublicao = new JLabel("Por Publicação");
		lblPorPublicao.setForeground(new Color(0, 255, 255));
		lblPorPublicao.setFont(new Font("Tahoma", Font.BOLD, 11));

		JButton btnAluno_Pesquisa = new JButton("Ir");
		btnAluno_Pesquisa.setForeground(new Color(0, 255, 255));
		btnAluno_Pesquisa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAluno_Pesquisa.setBackground(new Color(47, 79, 79));
		btnAluno_Pesquisa.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				FramePesquisaAluno pesquisaAluno = new FramePesquisaAluno(nomeUsuario, tipoUsuario);
				pesquisaAluno.show();
				dispose();
			}
		});

		JButton btnOrientador_Pesquisa = new JButton("Ir");
		btnOrientador_Pesquisa.setForeground(new Color(0, 255, 255));
		btnOrientador_Pesquisa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOrientador_Pesquisa.setBackground(new Color(47, 79, 79));
		btnOrientador_Pesquisa.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				FramePesquisaOrientador pesquisaorientador = new FramePesquisaOrientador(nomeUsuario, tipoUsuario);
				pesquisaorientador.show();
				dispose();

			}
		});

		JButton btnPublicacao_Pesquisa = new JButton("Ir");
		btnPublicacao_Pesquisa.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				FramePesquisaPublicacao framePublicacao = new FramePesquisaPublicacao(nomeUsuario, tipoUsuario);
				framePublicacao.show();
				dispose();
				
			}
		});
		btnPublicacao_Pesquisa.setForeground(new Color(0, 255, 255));
		btnPublicacao_Pesquisa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPublicacao_Pesquisa.setBackground(new Color(47, 79, 79));
		
		JLabel lblPorCurso = new JLabel("Por Curso");
		lblPorCurso.setForeground(new Color(0, 255, 255));
		lblPorCurso.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnCurso_Pesquisa = new JButton("Ir");
		btnCurso_Pesquisa.setForeground(new Color(0, 255, 255));
		btnCurso_Pesquisa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCurso_Pesquisa.setBackground(new Color(47, 79, 79));
		btnCurso_Pesquisa.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				FramePesquisaCurso frameCurso = new FramePesquisaCurso(nomeUsuario, tipoUsuario);
				frameCurso.show();
				dispose();
				
			}
		});
		GroupLayout gl_panelPesquisas = new GroupLayout(panelPesquisas);
		gl_panelPesquisas.setHorizontalGroup(
			gl_panelPesquisas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesquisas.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panelPesquisas.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_3)
						.addComponent(lblPorPublicao, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(lblPorCurso, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_panelPesquisas.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAluno_Pesquisa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOrientador_Pesquisa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPublicacao_Pesquisa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCurso_Pesquisa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(60))
		);
		gl_panelPesquisas.setVerticalGroup(
			gl_panelPesquisas.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelPesquisas.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(gl_panelPesquisas.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(btnAluno_Pesquisa))
					.addGap(9)
					.addGroup(gl_panelPesquisas.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(btnOrientador_Pesquisa))
					.addGap(9)
					.addGroup(gl_panelPesquisas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPorPublicao)
						.addComponent(btnPublicacao_Pesquisa))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelPesquisas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPorCurso)
						.addComponent(btnCurso_Pesquisa))
					.addContainerGap())
		);
		panelPesquisas.setLayout(gl_panelPesquisas);

		JPanel panelRelatorios = new JPanel();
		panelRelatorios.setBackground(Color.DARK_GRAY);
		panelRelatorios.setBounds(391, 217, 317, 68);
		panelRelatorios.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Relatorio", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));


		JLabel lblPorUsuario = new JLabel("Usu\u00E1rio");
		lblPorUsuario.setForeground(new Color(0, 255, 255));
		lblPorUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));

		JButton btnGerar = new JButton("Gerar");
		btnGerar.setForeground(new Color(0, 255, 255));
		btnGerar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGerar.setBackground(new Color(47, 79, 79));
		btnGerar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				FramePesquisaUsuario telaPesquisaUsuario = new FramePesquisaUsuario(nomeUsuario, tipoUsuario);
				telaPesquisaUsuario.show();
				dispose();

			}
		});
		// fim do bot�o gerar relat�rio

		GroupLayout gl_panelRelatorios = new GroupLayout(panelRelatorios);
		gl_panelRelatorios.setHorizontalGroup(gl_panelRelatorios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRelatorios.createSequentialGroup().addGap(57).addComponent(lblPorUsuario)
						.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
						.addComponent(btnGerar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addGap(50)));
		gl_panelRelatorios.setVerticalGroup(gl_panelRelatorios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRelatorios
						.createSequentialGroup().addContainerGap().addGroup(gl_panelRelatorios
								.createParallelGroup(Alignment.BASELINE).addComponent(lblPorUsuario).addComponent(btnGerar))
						.addContainerGap(21, Short.MAX_VALUE)));
		panelRelatorios.setLayout(gl_panelRelatorios);

		JLabel lblGerenciarUsurio = new JLabel("Gerenciar Usu\u00E1rio");
		lblGerenciarUsurio.setForeground(new Color(0, 255, 255));
		lblGerenciarUsurio.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel label = new JLabel("Gerenciar Aluno");
		label.setForeground(new Color(0, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel label_1 = new JLabel("Gerenciar Orientador");
		label_1.setForeground(new Color(0, 255, 255));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblGerenciarPublicao = new JLabel("Gerenciar Publica\u00E7\u00E3o");
		lblGerenciarPublicao.setForeground(new Color(0, 255, 255));
		lblGerenciarPublicao.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnUsuario = new JButton("Ir");
		btnUsuario.setForeground(new Color(0, 255, 255));
		btnUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUsuario.setBackground(new Color(47, 79, 79));
		btnUsuario.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				FrameUsuario frameUsuario = new FrameUsuario(nomeUsuario, tipoUsuario);
				frameUsuario.show();
				dispose();
			}
		});

		btnAluno = new JButton("Ir");
		btnAluno.setForeground(new Color(0, 255, 255));
		btnAluno.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAluno.setBackground(new Color(47, 79, 79));
		btnAluno.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				FrameAluno telaAluno = new FrameAluno(nomeUsuario, tipoUsuario);
				telaAluno.show();
				dispose();
			}
		});

		btnOrientador = new JButton("Ir");
		btnOrientador.setForeground(new Color(0, 255, 255));
		btnOrientador.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOrientador.setBackground(new Color(47, 79, 79));
		btnOrientador.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				FrameOrientador frameOrientador = new FrameOrientador(nomeUsuario, tipoUsuario);
				frameOrientador.show();
				dispose();
				
			}
		});

		btnPublicacao = new JButton("Ir");
		btnPublicacao.setForeground(new Color(0, 255, 255));
		btnPublicacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPublicacao.setBackground(new Color(47, 79, 79));
		btnPublicacao.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				FramePublicacao framePublicacao = new FramePublicacao(nomeUsuario, tipoUsuario);
				framePublicacao.show();
				dispose();
			}
		});

		JLabel lblGerenciarCurso = new JLabel("Gerenciar Curso");
		lblGerenciarCurso.setForeground(new Color(0, 255, 255));
		lblGerenciarCurso.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnCurso = new JButton("Ir");
		btnCurso.setForeground(new Color(0, 255, 255));
		btnCurso.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCurso.setBackground(new Color(47, 79, 79));
		btnCurso.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				FrameCurso frameCurso = new FrameCurso(nomeUsuario, tipoUsuario);
				frameCurso.show();
				dispose();
			}
		});
		contentPane.setLayout(null);
		GroupLayout gl_panelGerenciamento = new GroupLayout(panelGerenciamento);
		gl_panelGerenciamento.setHorizontalGroup(
			gl_panelGerenciamento.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGerenciamento.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panelGerenciamento.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelGerenciamento.createSequentialGroup()
							.addComponent(lblGerenciarCurso, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCurso, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelGerenciamento.createSequentialGroup()
							.addGroup(gl_panelGerenciamento.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblGerenciarUsurio)
								.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_1)
								.addComponent(lblGerenciarPublicao, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addGroup(gl_panelGerenciamento.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnUsuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAluno, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnOrientador, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnPublicacao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panelGerenciamento.createSequentialGroup()
									.addComponent(btnCurso, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(74))
		);
		gl_panelGerenciamento.setVerticalGroup(
			gl_panelGerenciamento.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelGerenciamento.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addGroup(gl_panelGerenciamento.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGerenciarUsurio)
						.addComponent(btnUsuario))
					.addGap(18)
					.addGroup(gl_panelGerenciamento.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(btnAluno))
					.addGap(18)
					.addGroup(gl_panelGerenciamento.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(btnOrientador))
					.addGap(18)
					.addGroup(gl_panelGerenciamento.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGerenciarPublicao)
						.addComponent(btnPublicacao))
					.addGap(18)
					.addGroup(gl_panelGerenciamento.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGerenciarCurso)
						.addComponent(btnCurso))
					.addGap(20))
		);
		panelGerenciamento.setLayout(gl_panelGerenciamento);
		contentPane.add(panelGerenciamento);
		contentPane.add(panelPesquisas);
		contentPane.add(panelRelatorios);
		
		lblUsuario = new JLabel("Usuário: <dynamic> ||| Permissão: <dynamic>");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setForeground(new Color(0, 255, 255));
		lblUsuario.setBounds(10, 296, 383, 14);
		contentPane.add(lblUsuario);
		
		conexao.bloqueiaButtonsMenu(tipoUsuario, btnUsuario, btnCurso, btnOrientador, btnAluno, btnPublicacao);
	}
	
}
