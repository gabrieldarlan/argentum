package br.com.alura.argentum.indicadores;

import br.com.alura.argentum.modelo.SerieTemporal;

public class MediaMovelSimples {

	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0;

		for (int i = posicao; i > posicao - 3; i--) {
			soma += serie.getCandlestick(i).getFechamento();
		}

		return soma / 3;
	}
}
