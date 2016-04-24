package br.com.cazevedo.jdbc;
import java.sql.Connection;
import br.com.cazevedo.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class UsuarioDAO {
	
	private Connection con = Conexao.getConnectar();
	
	public void cadastrar(Usuario cliente){
		String sql = "insert into clientes (nome,login,senha) values (?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
		    preparador.setString(1,cliente.getNome());
		    preparador.setString(2,cliente.getLogin());
		    preparador.setString(3,cliente.getSenha());
		    
		    preparador.execute();
		    preparador.close();
		    
		    System.out.println("Cadastrado com sucesso");
		    
		} catch (SQLException e) {
		System.out.println("Erro ao Cadastrar");
			e.printStackTrace();
		}
		
	}
	
	public void alterar(Usuario cliente){
		String sql = "update clientes set nome=?,login=?,senha=? where cod=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
		    preparador.setString(1,cliente.getNome());
		    preparador.setString(2,cliente.getLogin());
		    preparador.setString(3,cliente.getSenha());
		    preparador.setInt(4,cliente.getCod());
		    
		    preparador.execute();
		    preparador.close();
		    
		    System.out.println("Alterado com sucesso");
		    
		} catch (SQLException e) {
		System.out.println("O registro não foi alterado");
			e.printStackTrace();
		}
		
	}

	public void excluir(Usuario cliente){
		String sql = "delete from clientes where cod=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
		    preparador.setInt(1,cliente.getCod());
		    		    
		    preparador.execute();
		    preparador.close();
		    
		    System.out.println("Excluido com sucesso");
		    
		} catch (SQLException e) {
		System.out.println("erro ao excluir");
			e.printStackTrace();
		}
		
	}
	
	/*public List BuscarTodos(){
		String sql = "select * from clientes";

		List lista = (List) new ArrayList<Usuario>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
		    		    
		    ResultSet result = preparador.executeQuery();    
		    while (result.next()){		    
		    
		    	Usuario cli = new Usuario();	    
		    cli.setCod(result.getInt("cod"));
		    cli.setNome(result.getString("nome"));
		    cli.setLogin(result.getString("login"));
		    cli.setSenha(result.getString("senha"));
		    
		    ((ArrayList<Usuario>) lista).add(cli);
		    }
		    System.out.println("Busca realizada");
		    
		} catch (SQLException e) {
		System.out.println("erro na busca");
			e.printStackTrace();
		}
		return lista;
	}*/


}