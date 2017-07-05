package br.com.alura.controller;

import javax.inject.Inject;

import br.com.alura.dao.UsuasioDAO;
import br.com.alura.modelo.Usuario;
import br.com.alura.modelo.UsuarioLogado;
import br.com.alura.seguranca.Open;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {

	private UsuasioDAO usuasioDAO;
	private Validator validator;
	private Result result;
	private UsuarioLogado usuarioLogado;

	public LoginController() {
	}
	
	@Inject
	public LoginController(UsuasioDAO usuasioDAO, Validator validator, 
			Result result, UsuarioLogado usuarioLogado) {
		this.usuasioDAO = usuasioDAO;
		this.validator = validator;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}
	
	@Open
	public void form(){}
	
	@Post @Open
	public void autentica(String login, String senha){
		Usuario usuario = usuasioDAO.obter(login,senha);
		if(usuario == null){
			validator.add(new SimpleMessage("loginInvalido", "Usuário ou senha inválidos"));
			validator.onErrorForwardTo(this).form();
		} else {
			usuarioLogado.logar(usuario);
			result.redirectTo(UsuarioController.class).lista();
		}
	}
	
	@Open
	public void deslogar(){
		usuarioLogado.deslogar();
		result.redirectTo(LoginController.class).form();
	}
}
