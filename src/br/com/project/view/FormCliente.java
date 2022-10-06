package br.com.project.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.project.dao.ClienteDao;
import br.com.project.model.Cliente;

import javax.swing.border.BevelBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FormCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textCep;
	private JTextField textEndereco;
	private JTextField textNumero;
	private JTable tableConsulta;
	private JTextField txtRg;
	private JTextField textCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente frame = new FormCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public void listar() {
		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = dao.listarClientes();
			DefaultTableModel dados = (DefaultTableModel) tableConsulta.getModel();
			dados.setNumRows(0);
			for(Cliente c : lista) {
				dados.addRow(new Object[] {
						c.getId(),
						c.getNome(),
						c.getBairro(),
						c.getCep(),
						c.getCidade(),
						c.getCpf(),
						c.getRg(),
						c.getEmail(),
						c.getEstado(),
						c.getEndereco()
						
						
						
				});
			}
	}
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public FormCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				listar();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 972, 117);
		contentPane.add(panel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 131, 992, 404);
		contentPane.add(tabbedPane);
		
		JPanel panel_Dados = new JPanel();
		tabbedPane.addTab("New tab", null, panel_Dados, null);
		panel_Dados.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(21, 30, 46, 14);
		panel_Dados.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(21, 83, 46, 14);
		panel_Dados.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(21, 134, 46, 14);
		panel_Dados.add(lblEmail);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(21, 186, 46, 14);
		panel_Dados.add(lblCep);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(300, 30, 98, 14);
		panel_Dados.add(lblEndereco);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(300, 99, 46, 14);
		panel_Dados.add(lblNumero);
		
		JLabel lblNewLabel_5 = new JLabel("UF");
		lblNewLabel_5.setBounds(300, 186, 46, 14);
		panel_Dados.add(lblNewLabel_5);
		
		JComboBox cbbox = new JComboBox();
		cbbox.setModel(new DefaultComboBoxModel(new String[] {"SP", "RJ"}));
		cbbox.setBounds(380, 182, 84, 22);
		panel_Dados.add(cbbox);
		
		JLabel lblNewLabel_6 = new JLabel("Observacoes");
		lblNewLabel_6.setBounds(608, 30, 84, 14);
		panel_Dados.add(lblNewLabel_6);
		
		JTextArea textObser = new JTextArea();
		textObser.setBounds(712, 25, 208, 179);
		panel_Dados.add(textObser);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(79, 300, 89, 23);
		panel_Dados.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente obj = new Cliente();
				obj.setNome(textNome.getText());
				obj.setRg(txtRg.getText());
				obj.setCep(textCpf.getText());
				obj.setEmail(textEmail.getText());
				obj.setTelefone(textNome.getText());
				obj.setCelular(textNome.getText());
				obj.setCep(textCep.getText());
				obj.setEndereco(textEndereco.getText());
				obj.setNumero(textNumero.getText());
				obj.setComplemento(textNome.getText());
				obj.setBairro(textNome.getText());
				obj.setCidade(textNome.getText());
				obj.setEstado(cbbox.getSelectedItem().toString());
				
				ClienteDao dao = new ClienteDao();
				dao.cadastrarClientes(obj);
				
				
				
			}
		});
	
				
				
			
				
			
		
		
		btnSalvar.setBounds(206, 300, 89, 23);
		panel_Dados.add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(350, 300, 89, 23);
		panel_Dados.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(483, 300, 89, 23);
		panel_Dados.add(btnExcluir);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(615, 300, 89, 23);
		panel_Dados.add(btnImprimir);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(82, 27, 86, 20);
		panel_Dados.add(textCodigo);
		textCodigo.setColumns(10);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(82, 80, 86, 20);
		panel_Dados.add(textNome);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(82, 131, 86, 20);
		panel_Dados.add(textEmail);
		
		textCep = new JTextField();
		textCep.setColumns(10);
		textCep.setBounds(77, 183, 86, 20);
		panel_Dados.add(textCep);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(388, 27, 86, 20);
		panel_Dados.add(textEndereco);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(388, 96, 86, 20);
		panel_Dados.add(textNumero);
		
		JLabel lblNewLabel_1 = new JLabel("RG");
		lblNewLabel_1.setBounds(21, 241, 46, 14);
		panel_Dados.add(lblNewLabel_1);
		
		txtRg = new JTextField();
		txtRg.setBounds(82, 238, 86, 20);
		panel_Dados.add(txtRg);
		txtRg.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(527, 99, 46, 14);
		panel_Dados.add(lblNewLabel_2);
		
		textCpf = new JTextField();
		textCpf.setBounds(588, 96, 86, 20);
		panel_Dados.add(textCpf);
		textCpf.setColumns(10);
		
		JPanel panel_Consulta = new JPanel();
		panel_Consulta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("New tab", null, panel_Consulta, null);
		panel_Consulta.setLayout(null);
		
		tableConsulta = new JTable();
		tableConsulta.setBackground(Color.GRAY);
		tableConsulta.setForeground(Color.BLACK);
		tableConsulta.setName("Clientes");
		tableConsulta.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Cod", "Nome", "Endereco", "CEP", "E-mail", "Celular", "Telefone", "CPF", "RG"
			}
		));
		tableConsulta.setBounds(10, 276, 882, -264);
		panel_Consulta.add(tableConsulta);
			}
}