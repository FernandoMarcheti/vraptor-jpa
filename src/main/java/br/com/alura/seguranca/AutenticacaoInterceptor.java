package br.com.alura.seguranca;

import javax.inject.Inject;

import br.com.alura.controller.LoginController;
import br.com.alura.modelo.UsuarioLogado;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AutenticacaoInterceptor {

	private UsuarioLogado usuarioLogado;
	private Result result;
	private ControllerMethod method;

	public AutenticacaoInterceptor() {
	}

	@Inject
	public AutenticacaoInterceptor(UsuarioLogado usuarioLogado, Result result, ControllerMethod method) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.method = method;
	}
	
	@Accepts
	public boolean accept(){
		return !method.containsAnnotation(Open.class);
	}
	
	@AroundCall
	public void autentica(SimpleInterceptorStack stack){
		if(!usuarioLogado.isLogado()){
			result.redirectTo(LoginController.class).form();	
			return;
		} 
		stack.next();
	}
}
