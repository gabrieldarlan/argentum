package br.com.alura.argentum.modelo;

import java.util.List;

public class SerieTemporal {

	private List<Candlestick> candles;

	public SerieTemporal(List<Candlestick> candles) {
		this.candles = candles;
	}

	public Candlestick getCandlestick(int posicao) {
		return candles.get(posicao);
	}

	public int getUltimaPosica() {
		return candles.size() - 1;
	}
}
