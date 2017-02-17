package usuario;

import java.util.HashMap;
import java.util.Map;

import excecoes.ArgumentoNuloExcecao;
import excecoes.EntradaInvalidaExcecao;
import excecoes.ValorInvalidoExcecao;
import jogo.Jogo;

public abstract class Usuario {

	public final String NL = System.lineSeparator();
	private String nome;
	private String login;
	private double saldo;
	private int x2p;
	private Map <String, Jogo> jogosComprados;
	
	public Usuario(String nome, String login) throws EntradaInvalidaExcecao {
		if(!validaString(nome) || !validaString(login)) throw new EntradaInvalidaExcecao();
		
		this.nome = nome;
		this.login = login;
		
		this.saldo = 0;
		this.x2p = 0;
		jogosComprados = new HashMap<>();
	}
	
	public Usuario(String nome, String login, double saldo, int x2p, Map<String, Jogo> jogosComprados) throws Exception {
		if(!validaString(nome) || !validaString(login)) throw new EntradaInvalidaExcecao();
		if(saldo < 0 || x2p < 0) throw new ValorInvalidoExcecao();
		if(jogosComprados == null) throw new ArgumentoNuloExcecao("jogosComprados nao pode ser null");
		
		this.nome = nome;
		this.login = login;
		
		this.saldo = saldo;
		this.x2p = x2p;
		this.jogosComprados = jogosComprados;
	}

	public abstract void registraJogada(String nomeDoJogo, int score, boolean zerou) throws Exception;
	
	public abstract boolean compraJogo(Jogo jogo) throws ArgumentoNuloExcecao;
	
	public abstract boolean podeFazerUpgrade();
	
	public void adicionaJogo(Jogo jogo) throws ArgumentoNuloExcecao {
		if(jogo == null) throw new ArgumentoNuloExcecao("jogo nao pode ser null");
		jogosComprados.put(jogo.getNome(), jogo);
	}

	protected Jogo getJogo(String nomeJogo) throws EntradaInvalidaExcecao {
		if(!validaString(nomeJogo)) throw new EntradaInvalidaExcecao();
		return jogosComprados.get(nomeJogo);
	}
		
	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String infoUsuario(String tipoUsuario) {
		double totalPreco = 0;
		String infoUsuario = "";
		
		infoUsuario += this.login + NL;
		infoUsuario += this.nome + " - Jogador " + tipoUsuario + NL;
		
		infoUsuario += "Lista de Jogos:" + NL;
		for(Jogo jogo : jogosComprados.values()) {
			infoUsuario += jogo.toString() + NL;
			totalPreco += jogo.getPreco();
		}
		
		infoUsuario += NL + "Total de preco dos jogos: R$ " + totalPreco + NL;
		
		return infoUsuario;
	}

	public Map<String, Jogo> getJogosComprados() {
		return jogosComprados;
	}
	
	public void setJogosComprados(Map<String, Jogo> jogosComprados) {
		this.jogosComprados = jogosComprados;
	}
	
	public boolean validaString(String str) {
		if(str == null || str.trim().equals("")) return false;
		return true;
	}
}