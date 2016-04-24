package br.com.cazevedo.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
		
	public static Connection getConnectar(){
		Connection con = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LojaCris","postgres","cris");
		    System.out.println("Conectado com sucesso");
		    
		} catch (SQLException e) {
			System.out.println("Erro ao conectar" +e.getMessage());
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado");
			e.printStackTrace();
		}
	return con;
				
	}

}
