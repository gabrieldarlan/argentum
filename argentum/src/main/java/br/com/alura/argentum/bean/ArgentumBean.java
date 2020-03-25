package br.com.alura.argentum.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.alura.argentum.modelo.Negociacao;
import br.com.alura.argentum.ws.ClientWebservice;

@ManagedBean
public class ArgentumBean {

	public List<Negociacao> getNegociacoes() {
		return new ClientWebservice().getNegociacoes();
	}
}
