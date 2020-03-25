package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeSerie {

	public static SerieTemporal criaSerie(double... valores) {

		List<Candlestick> candles = new ArrayList<Candlestick>();

		for (double d : valores) {
			candles.add(new Candlestick(d, d, d, d, 1000, LocalDateTime.now()));
		}
		return new SerieTemporal(candles);
	}
}
