package br.com.alura.modelo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped @Named
public class UsuarioLogado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean isLogado(){
		return usuario != null;
	}
	
	public void logar(Usuario usuario){
		this.usuario = usuario;
	}
	
	public void deslogar(){
		this.usuario = null;
	}
	
}
