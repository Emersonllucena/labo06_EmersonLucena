package labo06_EmersonLucena;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import jogo.JogoLuta;
import jogo.JogoPlataforma;
import jogo.JogoRPG;
import loja.Loja;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

public class LojaTest {
	private final String NL = System.lineSeparator();

	private Jogo skyrim;
	private Jogo mk;
	private Jogo lbp;
	private Jogo lol;
	
	private Usuario emerson;
	private Usuario abella;
	private Usuario ze;
	
	private Loja loja;

	@Before
	public void prepara() throws Exception {
		skyrim = new JogoRPG("Skyrim", 100);
		mk = new JogoLuta("Mortal Kombat", 30);
		lbp = new JogoPlataforma("LittleBigPlanet", 85.00);
		lol = new JogoLuta("League of Legends", 255);
		
		emerson = new Noob("Emerson", "Emiso");
		abella = new Veterano("Felipe", "fsouza");
		
		loja = new Loja();
	}
	
	@Test
	public void testAdicionaDinheiro() {
		loja.adicionaUsuario(emerson);
		loja.adicionaDinheiro("Emiso", 30);
		
		assertEquals(30, emerson.getSaldo(), 0.01);
	}

	@Test
	public void testUpgrade() throws Exception {
		loja.adicionaUsuario(emerson);
		loja.adicionaDinheiro("Emiso", 200);
		emerson.compraJogo(skyrim);
		
		assertTrue(emerson instanceof Noob);
		assertEquals(1000, emerson.getX2p());
		
		loja.upgrade("Emiso");
		
		assertTrue(loja.getUsuario("Emiso") instanceof Veterano);
	}

}
