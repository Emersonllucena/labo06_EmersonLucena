package labo06_EmersonLucena;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import excecoes.EntradaInvalidaExcecao;
import jogo.*;

public class JogoTest {
	private final String NL = System.lineSeparator();

	private Jogo skyrim;
	private Jogo mk;
	private Jogo lbp;
	private Jogo lol;
	private Jogo mario;
	
	private Set <Jogabilidade> estilos, estilos2;
	
	private final String CAMPO_INVALIDO = "Campo nao pode ser nulo ou vazio";
	private final String UPGRADE_IMPOSSIVEL = "Nao e possivel fazer upgrade";
	private final String VALOR_INVALIDO = "Valor invalido";
	
	@Before
	public void prepara() throws Exception {
		skyrim = new JogoRPG("Skyrim", 39.99);
		mk = new JogoLuta("Mortal Kombat", 29.90);
		lbp = new JogoPlataforma("LittleBigPlanet", 85.00);
		lol = new JogoLuta("League of Legends", 1.99);
		
		estilos = new HashSet<>();
		estilos2 = new HashSet<>();
	}
	
	@Test
	public void testConstrutor() throws Exception {
		assertTrue(skyrim instanceof JogoRPG);
		assertTrue(mk instanceof JogoLuta);
		assertTrue(lbp instanceof JogoPlataforma);
		
		assertEquals(mk.getNome(), "Mortal Kombat");
		assertEquals(mk.getPreco(), 29.90, 0.001);
		assertEquals(mk.getQtdJogadas(), 0);
		assertEquals(mk.getQtdZeradas(), 0);
		assertEquals(mk.getMaiorScore(), 0);
	}

	@Test
	public void testConstrutor2() throws Exception {
		mk = new JogoPlataforma("Mortal Kombat", 123, estilos2);
		
		estilos.add(Jogabilidade.OFFLINE);
		estilos.add(Jogabilidade.COOPERATIVO);
		
		mario = new JogoPlataforma("Mario", 10.99, estilos);
		
		assertEquals(estilos, mario.getEstilosJogo());
		
		estilos2.add(Jogabilidade.MULTIPLAYER);
		assertNotEquals(estilos2, mario.getEstilosJogo());
		
	}
	
	@Test
	public void testConstrutorException() {
		try {
			mario = new JogoPlataforma("   ", 10.99);
			fail("String vazia");
		} catch (Exception e) {
			assertEquals(CAMPO_INVALIDO, e.getMessage());
		}
		
		try {
			mario = new JogoPlataforma(null, 10.99);
			fail("String nula");
		} catch (Exception e) {
			assertEquals(CAMPO_INVALIDO, e.getMessage());
		}
		
		try {
			mario = new JogoPlataforma("Armario", -0.1);
			fail("Preco invalido");
		} catch (Exception e) {
			assertEquals(VALOR_INVALIDO, e.getMessage());
		}
	}

	@Test
	public void testConstrutor2Exception() {
		try {
			mario = new JogoPlataforma("Mario", 10.99, null);
			fail("jogabilidade nula");
		} catch (Exception e) {
			assertEquals("estilosJogo nao pode ser null", e.getMessage());
		}
	}

	@Test
	public void testRegistraJogadaPlataforma() {
		assertEquals(20, lbp.registraJogada(100, true));
		assertEquals(100, lbp.getMaiorScore());
		assertEquals(1, lbp.getQtdZeradas());
		assertEquals(1, lbp.getQtdJogadas());
		
		assertEquals(0, lbp.registraJogada(101, false));
		assertEquals(101, lbp.getMaiorScore());
		assertEquals(1, lbp.getQtdZeradas());
		assertEquals(2, lbp.getQtdJogadas());
	}
	

	@Test
	public void testRegistraJogadaRPG() {
		assertEquals(10, skyrim.registraJogada(100, true));
		assertEquals(100, skyrim.getMaiorScore());
		assertEquals(1, skyrim.getQtdZeradas());
		assertEquals(1, skyrim.getQtdJogadas());
		
		assertEquals(10, skyrim.registraJogada(110, false));
		assertEquals(110, skyrim.getMaiorScore());
		assertEquals(1, skyrim.getQtdZeradas());
		assertEquals(2, skyrim.getQtdJogadas());
	}
	
	@Test
	public void testRegistraJogadaLuta() {
		assertEquals(1, mk.registraJogada(1999, true));
		assertEquals(1999, mk.getMaiorScore());
		assertEquals(1, mk.getQtdZeradas());
		assertEquals(1, mk.getQtdJogadas());
		
		assertEquals(2, mk.registraJogada(2001, true));
		assertEquals(2001, mk.getMaiorScore());
		assertEquals(2, mk.getQtdZeradas());
		assertEquals(2, mk.getQtdJogadas());
		
		assertEquals(0, mk.registraJogada(2000, false));
		assertEquals(2001, mk.getMaiorScore());
		assertEquals(2, mk.getQtdZeradas());
		assertEquals(3, mk.getQtdJogadas());
	}

	@Test
	public void testInfoJogo() {
		skyrim.registraJogada(1, false);

		String info = "+ Skyrim - RPG:" + NL
					+ "==> Jogou 1 vez(es)" + NL
					+ "==> Zerou 0 vez(es)" + NL
					+ "==> Maior score: 1" + NL;
		
		assertEquals(info, skyrim.toString());
		
		skyrim.registraJogada(10, true);

		info = "+ Skyrim - RPG:" + NL
				+ "==> Jogou 2 vez(es)" + NL
				+ "==> Zerou 1 vez(es)" + NL
				+ "==> Maior score: 10" + NL;
		
		assertEquals(info, skyrim.toString());
	}

}
