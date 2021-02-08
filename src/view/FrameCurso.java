package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.TitledBorder;

import controller.cursoController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.UIManager;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameCurso extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField descricaoField;
	private JButton btnEditar;
	private JButton btnSalvar;
	private JButton btnNovo;
	public JLabel lblUsuario;

	private cursoController controleCurso = new cursoController();


	/**
	 * Create the frame.
	 */
	public FrameCurso(String nomeUsuario, String tipoUsuario) {
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
		setBounds(100, 100, 520, 190);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GERENCIAR CURSO", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
		contentPane.setBackground(Color.DARK_GRAY);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setForeground(new Color(0, 255, 255));
		lblId.setBounds(10, 52, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescrio.setForeground(new Color(0, 255, 255));
		lblDescrio.setBounds(138, 52, 90, 14);
		contentPane.add(lblDescrio);

		idField = new JTextField();
		controleCurso.gerarID(idField);
		idField.setForeground(Color.WHITE);
		idField.setBackground(new Color(47, 79, 79));
		idField.setFont(new Font("Tahoma", Font.BOLD, 13));
		idField.setEnabled(false);
		idField.setBounds(33, 49, 70, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		descricaoField = new JTextField();
		descricaoField.setForeground(Color.WHITE);
		descricaoField.setFont(new Font("Tahoma", Font.BOLD, 13));
		descricaoField.setBackground(new Color(47, 79, 79));
		descricaoField.setBounds(217, 49, 277, 20);
		contentPane.add(descricaoField);
		descricaoField.setColumns(10);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBackground(SystemColor.textInactiveText);
		btnEditar.setForeground(new Color(0, 255, 255));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {

				Boolean validaCampos = false;
				
				validaCampos = controleCurso.verificarCampos(idField, descricaoField);
				
				if (validaCampos == true) {
					btnEditar.setEnabled(true);
				}else{
					btnEditar.setEnabled(false);
				}
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleCurso.btnEditar(idField, descricaoField, btnEditar);
			}
		});
		btnEditar.setBounds(207, 117, 80, 23);
		contentPane.add(btnEditar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(SystemColor.textInactiveText);
		btnSalvar.setForeground(new Color(0, 255, 255));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleCurso.btnSalvar(idField, descricaoField);
			}
		});
		btnSalvar.setBounds(115, 117, 80, 23);
		contentPane.add(btnSalvar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(SystemColor.textInactiveText);
		btnPesquisar.setForeground(new Color(0, 255, 255));
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleCurso.btnPesquisar(btnSalvar, btnEditar, idField, descricaoField);
			}
		});
		btnPesquisar.setBounds(299, 117, 108, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(SystemColor.textInactiveText);
		btnVoltar.setForeground(new Color(0, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				FrameMenu frameMenu = new FrameMenu(nomeUsuario, tipoUsuario);
				frameMenu.show();
				dispose();
			}
		});
		btnVoltar.setBounds(419, 117, 75, 23);
		contentPane.add(btnVoltar);
		
		btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovo.setForeground(new Color(0, 255, 255));
		btnNovo.setBackground(SystemColor.textInactiveText);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				controleCurso.ClearFields(idField, descricaoField);
				controleCurso.DesbloquearFields(idField, descricaoField);
				
				controleCurso.gerarID(idField);
			}
		});
		btnNovo.setBounds(10, 117, 80, 23);
		contentPane.add(btnNovo);
	}
}
