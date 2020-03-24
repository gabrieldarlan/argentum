package br.com.alura.argentum.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CandlestickFactoryTest {

	@Test
	public void sequenciaDeNegociacoesSimples() {
		LocalDateTime hoje = LocalDateTime.now();

		Negociacao negociacao1 = new Negociacao(40.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(35.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(20.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.geraCandleParaData(negociacoes, hoje);

		assertEquals(20.0, candle.getMinimo(), 0.000001);
		assertEquals(45.0, candle.getMaximo(), 0.000001);
		assertEquals(40.0, candle.getAbertura(), 0.000001);
		assertEquals(20.0, candle.getFechamento(), 0.000001);
		assertEquals(14000, candle.getVolume(), 0.000001);
	}

	@Test
	public void geraCandlestickComApenasUmaNegociacao() {
		LocalDateTime data = LocalDateTime.now();
		Negociacao negociacao = new Negociacao(40, 100, data);

		List<Negociacao> negociacoes = Arrays.asList(negociacao);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.geraCandleParaData(negociacoes, data);

		assertEquals(40.0, candle.getMinimo(), 0.000001);
		assertEquals(40.0, candle.getMaximo(), 0.000001);
		assertEquals(40.0, candle.getAbertura(), 0.000001);
		assertEquals(40.0, candle.getFechamento(), 0.000001);
		assertEquals(4000, candle.getVolume(), 0.000001);
	}

	@Test
	public void geraCandlestickComZerosEmCasosDeNenhumNegociacao() {

		LocalDateTime data = LocalDateTime.now();

		List<Negociacao> negociacoes = new ArrayList<>();

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.geraCandleParaData(negociacoes, data);

		assertEquals(0, candle.getMinimo(), 0.000001);
		assertEquals(0, candle.getMaximo(), 0.000001);
		assertEquals(0, candle.getAbertura(), 0.000001);
		assertEquals(0, candle.getFechamento(), 0.000001);
		assertEquals(0, candle.getVolume(), 0.000001);
	}

	@Test
	public void negociacaoDeTresDiasDiferentesGeraTresCandleDiferentes() {
		LocalDateTime hoje = LocalDateTime.now();

		Negociacao negociacao1 = new Negociacao(50.0, 20, hoje);
		Negociacao negociacao2 = new Negociacao(100.0, 20, hoje);
		Negociacao negociacao3 = new Negociacao(150.0, 20, hoje);

		LocalDateTime amanha = hoje.plusDays(1);

		Negociacao negociacao4 = new Negociacao(50.0, 100, amanha);
		Negociacao negociacao5 = new Negociacao(10.0, 20, amanha);

		LocalDateTime depois = amanha.plusDays(1);

		Negociacao negociacao6 = new Negociacao(35.0, 20, depois);
		Negociacao negociacao7 = new Negociacao(35.0, 20, depois);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, negociacao5,
				negociacao6, negociacao7);

		CandlestickFactory fabrica = new CandlestickFactory();

		List<Candlestick> candlesticks = fabrica.constroiCandles(negociacoes);

		assertEquals(3, candlesticks.size());
		assertTrue(negociacoes.get(0).isMesmoDia(candlesticks.get(0).getData()));
		assertTrue(negociacoes.get(3).isMesmoDia(candlesticks.get(1).getData()));
		assertTrue(negociacoes.get(5).isMesmoDia(candlesticks.get(2).getData()));

		assertEquals(6000.0, candlesticks.get(0).getVolume(), 0.000001);
		assertEquals(50.0, candlesticks.get(0).getMinimo(), 0.000001);
		assertEquals(150.0, candlesticks.get(0).getMaximo(), 0.000001);
		assertEquals(50.0, candlesticks.get(0).getAbertura(), 0.000001);
		assertEquals(150.0, candlesticks.get(0).getFechamento(), 0.000001);

	}

}
