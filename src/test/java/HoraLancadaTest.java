import org.junit.Assert;
import org.junit.Test;

import br.com.alura.modelo.HoraLancada;

public class HoraLancadaTest {

	@Test
	public void calculaDuracao(){
		HoraLancada horaLancada = new HoraLancada();
		
		horaLancada.setHoraInicial("09:00");
		horaLancada.setHoraFinal("19:00");
		
		Assert.assertEquals(10.0, horaLancada.getDuracao(), 0.01);
	}
}
