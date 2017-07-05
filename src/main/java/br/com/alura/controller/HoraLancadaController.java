package br.com.alura.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.dao.HoraLancadaDAO;
import br.com.alura.modelo.HoraLancada;
import br.com.alura.modelo.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@Path(value="/horalancada")
public class HoraLancadaController {

	private HoraLancadaDAO dao;
	private Result result;
	private Validator validator;
	private UsuarioLogado logado;

	public HoraLancadaController() {
	}
	
	@Inject
	public HoraLancadaController(HoraLancadaDAO dao, Result result,
			Validator validator, UsuarioLogado logado) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.logado = logado;
	}
	
	public void form(){}
	
	public void lista(){
		result.include("horas", dao.lista());
	}

	@Post @IncludeParameters
	public void salva(@Valid HoraLancada horaLancada){
		validator.onErrorRedirectTo(this).form();
		horaLancada.setUsuario(logado.getUsuario());
		dao.salva(horaLancada);
		result.redirectTo(this).lista();
	}
	
	public void relatorioDeHoras(){
		List<HoraLancada> horasPorUsuario = dao.getRelatorioDeHoras(logado.getUsuario());
		RelatorioDeHoras relatorioDeHoras = new RelatorioDeHoras(horasPorUsuario);
		result.include("relatorio", relatorioDeHoras.getHorasPorDia());
	}
}
