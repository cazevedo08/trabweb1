package br.com.cazevedo.teste;
import br.com.cazevedo.entidades.Usuario;
import br.com.cazevedo.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		testCadastrar();
		//testAlterar();
		//testExcluir();
		//testBuscarTodos();
			
	}

	private static void testCadastrar() {
		Usuario cli = new Usuario();
		cli.setNome("Amelia Nunes");
		cli.setLogin("anu");
		cli.setSenha("an123");
		
		UsuarioDAO clDao = new UsuarioDAO();
		clDao.cadastrar(cli);
	}
	
		private static void testAlterar() {
		Usuario cli = new Usuario();
		cli.setCod(6);
		cli.setNome("Roberto Brito");
		cli.setLogin("Robert");
		cli.setSenha("rb123");
			
		UsuarioDAO clDao = new UsuarioDAO();
		clDao.alterar(cli);
	}
		
		private static void testExcluir() {
			Usuario cli = new Usuario();
			cli.setCod(8);
							
			UsuarioDAO clDao = new UsuarioDAO();
			clDao.excluir(cli);
		}
		
		/*
		private static void testBuscarTodos() {
			UsuarioDAO clDao= new UsuarioDAO();
			List listResult = clDao.BuscarTodos();
							
			for(Usuario cl: listResult){
				System.out.println(cl.getCod()+" " + cl.getNome()+" "+ cl.getLogin() +" "+ cl.getLogin()+" "+cl.getSenha());
				
			}
		}*/

}
