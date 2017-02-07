package lab06;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private String login;
	private double saldo;
	private List <Jogo> jogosComprados;
	
	public Usuario(String nome, String login) {
		this.nome = nome;
		this.login = login;
		
		this.saldo = 0;
		jogosComprados = new ArrayList<>();
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
