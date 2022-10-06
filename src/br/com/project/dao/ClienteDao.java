package br.com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Cliente;

public class ClienteDao {
		private Connection conexao;
	
	


		public ClienteDao() {
			this.conexao = new ConnectionFactory().pegarconexao();
			
		}




		public void cadastrarClientes(Cliente obj) {
			try {
				// 1- CRIAR INSTRUCAO SQL
				String sql = "INSERT INTO tb_clientes (nome ,rg , cpf , email , telefone , celular , cep , endereco , numero , complemento , bairro , cidade , estado)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				// PREPAR SQL
				
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, obj.getNome());
				stmt.setString(2, obj.getRg());
				stmt.setString(3, obj.getCpf());
				stmt.setString(4, obj.getEmail());
				stmt.setString(5, obj.getTelefone());
				stmt.setString(6, obj.getCelular());
				stmt.setString(7, obj.getCep());
				stmt.setString(8, obj.getEndereco());
				stmt.setString(9, obj.getNumero());
				stmt.setString(10, obj.getComplemento());
				stmt.setString(11, obj.getBairro());
				stmt.setString(12, obj.getCidade());
				stmt.setString(13, obj.getEstado());
				
				
				//EXECUTA
				stmt.execute();
				stmt.close();
				JOptionPane.showInternalConfirmDialog(null, "Cliente cadastrado");
				
			}catch (SQLException erro) {
				JOptionPane.showConfirmDialog(null, "erro" +erro);
			
			
			
			
			
		}
		
		
		
	}
		
		
		
		
		// LISTAR CLIENTE
		
		public List<Cliente> listarClientes () {
			try {
				
				List<Cliente> lista = new ArrayList<>();
				
				String sql = "SELECT *FROM tb_clientes";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				
				
				while(rs.next()) {
					Cliente obj = new Cliente();
					obj.setId(rs.getInt("id"));
					obj.setNome(rs.getString("nome"));
					obj.setRg(rs.getString("rg"));
					obj.setCpf(rs.getString("cpf"));
					obj.setEmail(rs.getString("email"));
					obj.setTelefone(rs.getString("telefone"));
					obj.setCelular(rs.getString("celular"));
					obj.setCelular(rs.getString("cep"));
					obj.setCelular(rs.getString("endereco"));
					obj.setCelular(rs.getString("numero"));
					obj.setComplemento(rs.getString("complemento"));
					obj.setBairro(rs.getString("bairro"));
					obj.setCidade(rs.getString("cidade"));
					obj.setEstado(rs.getString("estado"));
					
					lista.add(obj);
					
				}
				return lista;
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"erro" +e);
				
			}
			return null;
		}
	

}
