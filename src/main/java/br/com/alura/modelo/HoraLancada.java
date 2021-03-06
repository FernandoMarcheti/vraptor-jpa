package br.com.alura.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class HoraLancada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Calendar data;

	private String comentario;

	@NotEmpty
	@Pattern(regexp = "\\d{2}:\\d{2}")
	private String horaInicial;

	@NotEmpty
	@Pattern(regexp = "\\d{2}:\\d{2}")
	private String horaFinal;

	@ManyToOne
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getDuracao() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		try {
			Date fim = format.parse(horaFinal);
			Date inicio = format.parse(horaInicial);
			final long millis = fim.getTime() - inicio.getTime();
			return millis / (1000.0 * 60.0 * 60.0);
		} catch (ParseException e) {
			return 0;
		} 
	}
	
}
