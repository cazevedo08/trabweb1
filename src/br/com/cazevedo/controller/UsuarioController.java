package br.com.cazevedo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cazevedo.entidades.Usuario;
import br.com.cazevedo.jdbc.UsuarioDAO;

@WebServlet("/usucontrol.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UsuarioController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("chama GET");
		
		String nome = request.getParameter("nome");
		//System.out.println("nome: " + nome);
		
		String empresa = request.getParameter("empresa");
		//System.out.println("empresa: " + empresa);
		
		PrintWriter saida = response.getWriter();
		//saida.println("Nome:" + nome + "Empresa:" + empresa);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		System.out.println("chama POST");
		
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
			
		//cria objeto usuTela e seta os valores vindos da tela 
		Usuario usuTela = new Usuario();
		usuTela.setNome(nome);
		usuTela.setLogin(login);
		usuTela.setSenha(senha);
				
		//pede para o usuarioDAO cadastrar no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usuTela);
				
		//saída no Browser
		PrintWriter saida = response.getWriter();
		saida.print("Cadastro feito com sucesso!");
		
	}

}
