package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Test;

public class CandlestickTest {

	@Test
	public void test() {
		CandleBuilder builder = new CandleBuilder();

		Candlestick candle = builder.comAbertura(10.0).comFechamento(20.0).comMaximo(100.0).comMinimo(10.0)
				.comVolume(100.0).comData(LocalDateTime.now()).geraCandle();

	}

}
