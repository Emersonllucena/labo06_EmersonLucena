package jogo;

import java.util.HashSet;
import java.util.Set;

import excecoes.ArgumentoNuloExcecao;
import excecoes.EntradaInvalidaExcecao;
import excecoes.ValorInvalidoExcecao;

public abstract class Jogo {
	private final String NL = System.lineSeparator();
	private Set <Jogabilidade> estilosJogo;
	private String nome;
	private double preco;
	private int maiorScore;
	private int qtdJogadas;
	private int qtdZeradas;
	
	public Jogo(String nome, double preco) throws Exception {
		if(!validaString(nome)) throw new EntradaInvalidaExcecao();
		if(preco <= 0) throw new ValorInvalidoExcecao();
		
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qtdJogadas = 0;
		this.qtdZeradas = 0;
		
		this.estilosJogo = new HashSet<>();
	}
	
	public Jogo(String nome, double preco, Set <Jogabilidade> estilosJogo) throws Exception {
		this(nome, preco);
		if(estilosJogo == null) throw new ArgumentoNuloExcecao("estilosJogo nao pode ser null");
		this.estilosJogo = estilosJogo;
	}
	
	public abstract int registraJogada(int pontuacao, boolean zerou);
	
	public double getPreco() {
		return this.preco;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	public int getQtdJogadas() {
		return qtdJogadas;
	}

	public void aumentaQtdJogadas() {
		this.qtdJogadas++;
	}

	public int getQtdZeradas() {
		return qtdZeradas;
	}

	public void aumentaQtdZeradas() {
		this.qtdZeradas++;
	}

	public String getNome() {
		return nome;
	}
	
	public boolean validaString(String str) {
		if(str == null || str.trim().equals("")) return false;
		return true;
	}
	
	public Set<Jogabilidade> getEstilosJogo() {
		return estilosJogo;
	}

	public String infoJogo(String tipoJogo) {
		String infoJogo = "";
		infoJogo += "+ " + nome + " - " + tipoJogo + ":" + NL;
		infoJogo += "==> Jogou " + qtdJogadas + " vez(es)" + NL;
		infoJogo += "==> Zerou " + qtdZeradas + " vez(es)" + NL;
		infoJogo += "==> Maior score: " + maiorScore + NL;
		
		return infoJogo;
	}
	
}
