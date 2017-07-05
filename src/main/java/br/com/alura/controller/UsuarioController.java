package br.com.alura.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.dao.UsuasioDAO;
import br.com.alura.modelo.Usuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {

	private final UsuasioDAO usuarioDAO;
	private final Result result;
	private final Validator validator;

	@Deprecated
	public UsuarioController() {
		this(null, null, null);
	}
	
	@Inject
	public UsuarioController(UsuasioDAO usuarioDAO, Result result, Validator validator) {
		this.usuarioDAO = usuarioDAO;
		this.result = result;
		this.validator = validator;
	}
	
	@Get
	public void form(){
	}

	@Get
	public void lista(){
		result.include("usuarios", usuarioDAO.lista());
	}
	
	@Post @IncludeParameters
	public void adiciona(@Valid Usuario usuario){
		validator.onErrorRedirectTo(this).form();
		usuarioDAO.adiciona(usuario);
		result.redirectTo(this).lista();
	}
}
