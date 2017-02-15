package usuario;

import java.util.HashMap;
import java.util.Map;

import jogo.Jogo;

public abstract class Usuario {

	public final String NL = System.lineSeparator();
	private String nome;
	private String login;
	private double saldo;
	private int x2p;
	private Map <String, Jogo> jogosComprados;
	
	public Usuario(String nome, String login) {
		this.nome = nome;
		this.login = login;
		
		this.saldo = 0;
		this.x2p = 0;
		jogosComprados = new HashMap<>();
	}
	
	public abstract void registraJogada(String nomeDoJogo, int score, boolean zerou);
	
	public abstract boolean compraJogo(Jogo jogo);
	
	public void adicionaJogo(Jogo jogo) {
		jogosComprados.put(jogo.getNome(), jogo);
	}

	protected Jogo getJogo(String nomeJogo) {
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
}