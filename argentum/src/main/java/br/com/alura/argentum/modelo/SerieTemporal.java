package br.com.alura.argentum.modelo;

import java.util.List;

public class SerieTemporal {

	private List<Candle> candles;

	public SerieTemporal(List<Candle> candles) {
		this.candles = candles;
	}

	public Candle getCandle(int posicao) {
		return candles.get(posicao);
	}

	public int getUltimaPosica() {
		return candles.size() - 1;
	}
}
