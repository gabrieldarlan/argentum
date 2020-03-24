package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void maximoNaoDeveSerMenorDoQueOMinimo() {

		CandleBuilder builder = new CandleBuilder();
		LocalDateTime hoje = LocalDateTime.now();

		Candlestick candle = 
				builder.comAbertura(10.0)
				.comFechamento(30.0)
				.comMinimo(25.0)
				.comMaximo(15.0)
				.comVolume(200)
				.comData(hoje)
				.geraCandle();
	}
	
	@Test
	public void ehAltaSeFechamentoForIgualAbertura() {
		CandleBuilder builder = new CandleBuilder();
		LocalDateTime hoje = LocalDateTime.now();

		Candlestick candle = 
				builder.comAbertura(30.0)
				.comFechamento(30.0)
				.comMinimo(25.0)
				.comMaximo(50.0)
				.comVolume(200)
				.comData(hoje)
				.geraCandle();
		
		Assert.assertTrue(candle.isAlta());
	}
}
