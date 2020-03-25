package br.com.alura.argentum.indicadores;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class IndicadorFactory {

	private String nomeMedia;
	private String nomeIndicadorBase;

	public IndicadorFactory(String nomeMedia, String nomeIndicadorBase) {
		this.nomeMedia = nomeMedia;
		this.nomeIndicadorBase = nomeIndicadorBase;
	}

	public Indicador defineIndicador() {
		if (nomeMedia == null || nomeIndicadorBase == null) {
			return new MediaMovelSimples(new IndicadorFechamento());
		}
		try {
			String pacote = "br.com.alura.argentum.indicadores.";

			Class<?> classeIndicadorBase = Class.forName(pacote + nomeIndicadorBase);
			Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();

			Class<?> classeMedia = Class.forName(pacote + nomeMedia);
			Constructor<?> construtor = classeMedia.getConstructor(Indicador.class);
			Indicador indicador = (Indicador) construtor.newInstance(indicadorBase);

			return indicador;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException();
		}
	}
}
