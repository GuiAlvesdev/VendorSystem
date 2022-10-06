package br.com.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";  // username banco
	private static final String PASSWORD = "Gg131300"; // senha do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sistemavendasdb"; //caminho do banco
	
	
	public Connection pegarconexao (){
		try {
		
			return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
	}catch (Exception e) {
			System.out.println("erro" + e);
		
		}
		return null;
		
		
	}
	

}
