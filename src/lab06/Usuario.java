package lab06;

import java.util.HashMap;
import java.util.Map;

public abstract class Usuario {
	//TODO metodos protected
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
	
		
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}