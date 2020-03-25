package br.com.alura.argentum.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {

	private String mensagem = "Essa mensagem veio direto do meu bean";
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void botaoClicado() {
		System.out.println("O botao foi clicado!! Seu nome é: " + this.nome);
		this.nome = "";
	}
}
