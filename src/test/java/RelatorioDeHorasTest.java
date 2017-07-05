import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.controller.RelatorioDeHoras;
import br.com.alura.modelo.HoraLancada;
import br.com.alura.modelo.HorasPorDia;

public class RelatorioDeHorasTest {

	@Test
	public void calculaRelatorioDatasIguais(){
		
		GregorianCalendar calendar = new GregorianCalendar(2017, 07, 04);
		HoraLancada hora1 = novaHoraLancada(calendar, "10:00", "18:00");
		HoraLancada hora2 = novaHoraLancada(calendar, "18:00", "20:00");
		RelatorioDeHoras relatorioDeHoras = new RelatorioDeHoras(Arrays.asList(hora1, hora2));
		
		HorasPorDia horasPorDia = relatorioDeHoras.getHorasPorDia().get(0);
		Assert.assertEquals(1, relatorioDeHoras.getHorasPorDia().size());
        Assert.assertEquals(8.0, horasPorDia.getHorasNormais(), 0.001);
        Assert.assertEquals(2.0, horasPorDia.getHorasExtras(), 0.001);
        Assert.assertEquals(calendar, horasPorDia.getData());
	}

	@Test
	public void calculaRelatorioDatasDiferentes(){
		GregorianCalendar data1 = new GregorianCalendar(2017, 07, 04);
		GregorianCalendar data2 = new GregorianCalendar(2017, 07, 05);
		GregorianCalendar data3 = new GregorianCalendar(2017, 07, 06);
		HoraLancada hora1 = novaHoraLancada(data1, "10:00", "18:00");
		HoraLancada hora2 = novaHoraLancada(data2, "10:00", "20:00");
		HoraLancada hora3 = novaHoraLancada(data3, "10:00", "20:00");
		RelatorioDeHoras relatorioDeHoras = new RelatorioDeHoras(Arrays.asList(hora1, hora2, hora3));
		
		HorasPorDia horasPorDia1 = relatorioDeHoras.getHorasPorDia().get(0);
		HorasPorDia horasPorDia2 = relatorioDeHoras.getHorasPorDia().get(1);
		HorasPorDia horasPorDia3 = relatorioDeHoras.getHorasPorDia().get(2);
		Assert.assertEquals(3, relatorioDeHoras.getHorasPorDia().size());
		
        Assert.assertEquals(8.0, horasPorDia1.getHorasNormais(), 0.001);
        Assert.assertEquals(0.0, horasPorDia1.getHorasExtras(), 0.001);
        Assert.assertEquals(data1, horasPorDia1.getData());
        
        Assert.assertEquals(8.0, horasPorDia2.getHorasNormais(), 0.001);
        Assert.assertEquals(2.0, horasPorDia2.getHorasExtras(), 0.001);
        Assert.assertEquals(data2, horasPorDia2.getData());
        
        Assert.assertEquals(8.0, horasPorDia3.getHorasNormais(), 0.001);
        Assert.assertEquals(2.0, horasPorDia3.getHorasExtras(), 0.001);
        Assert.assertEquals(data3, horasPorDia3.getData());
	}
	
	private HoraLancada novaHoraLancada(GregorianCalendar calendar, String horaInicio, String horaFim) {
		HoraLancada horaLancada = new HoraLancada();
		horaLancada.setData(calendar);
		horaLancada.setHoraInicial(horaInicio);
		horaLancada.setHoraFinal(horaFim);
		return horaLancada;
	}
}
