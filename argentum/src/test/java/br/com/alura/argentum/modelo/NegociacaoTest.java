package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Test;

public class NegociacaoTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveComecaoComPrecoNegativo() {
		new Negociacao(-20.0, 2, LocalDateTime.now());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComDataNula() {
		new Negociacao(10.0, 2, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComQuantidadeNegativa() {
		new Negociacao(10.0, -2, LocalDateTime.now());
	}
	

}
