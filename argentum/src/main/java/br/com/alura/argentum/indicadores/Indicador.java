package br.com.alura.argentum.indicadores;

import br.com.alura.argentum.modelo.SerieTemporal;

public interface Indicador {

	double calcula(int posicao, SerieTemporal serie);

}