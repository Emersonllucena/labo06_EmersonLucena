package labo06_EmersonLucena;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import jogo.*;
import usuario.*;

public class UsuarioTest {
	private final String NL = System.lineSeparator();

	private Jogo skyrim;
	private Jogo mk;
	private Jogo lbp;
	private Jogo lol;
	
	private Usuario emerson;
	private Usuario abella;
	private Usuario ze;
	
	private Map <String, Jogo> jogosComprados;
	private Map <String, Jogo> jogosComprados2;

	private final String CAMPO_INVALIDO = "Campo nao pode ser nulo ou vazio";
	private final String UPGRADE_IMPOSSIVEL = "Nao e possivel fazer upgrade";
	private final String VALOR_INVALIDO = "Valor invalido";
	
	@Before
	public void prepara() throws Exception {
		skyrim = new JogoRPG("Skyrim", 100);
		mk = new JogoLuta("Mortal Kombat", 30);
		lbp = new JogoPlataforma("LittleBigPlanet", 85.00);
		lol = new JogoLuta("League of Legends", 255);
		
		emerson = new Noob("Emerson", "Emiso");
		abella = new Veterano("Felipe", "fsouza");
		
		jogosComprados = new HashMap<>();
		jogosComprados2 = new HashMap<>();
	}
	
	@Test
	public void testConstrutor() {
		assertTrue(emerson instanceof Noob);
		assertEquals("Emerson", emerson.getNome());
		assertEquals("Emiso", emerson.getLogin());
		assertEquals(0, emerson.getSaldo(), 0.01);
		assertEquals(0, emerson.getX2p());
		
		assertTrue(abella instanceof Veterano);
		assertEquals("Felipe", abella.getNome());
		assertEquals("fsouza", abella.getLogin());
		assertEquals(0, abella.getSaldo(), 0.01);
		assertEquals(0, abella.getX2p());
	}

	@Test
	public void testConstrutor2() throws Exception {
		jogosComprados.put("Skyrim", skyrim);
		
		ze = new Veterano("Jose Carlos", "zeca", 300, 1200, jogosComprados);
		assertEquals("Jose Carlos", ze.getNome());
		assertEquals("zeca", ze.getLogin());
		assertEquals(300, ze.getSaldo(), 0.01);
		assertEquals(1200, ze.getX2p());
		
		assertNotEquals(jogosComprados2, ze.getJogosComprados());
		jogosComprados2.put("Skyrim", skyrim);
		assertEquals(jogosComprados2, ze.getJogosComprados());
	}
	
	@Test
	public void testConstrutorException() {
		try {
			ze = new Noob(" ", "zeca");
			fail("String vazia");
		} catch (Exception e) {
			assertEquals(CAMPO_INVALIDO, e.getMessage());
		}
		
		try {
			ze = new Noob(null, "zeca");
			fail("String nula");
		} catch (Exception e) {
			assertEquals(CAMPO_INVALIDO, e.getMessage());
		}
		
		try {
			ze = new Veterano("  ", "zeca", 300, 1200, jogosComprados);
			fail("String vazia");
		} catch (Exception e) {
			assertEquals(CAMPO_INVALIDO, e.getMessage());
		}
		
		try {
			ze = new Veterano(null, "zeca", 300, 1200, jogosComprados);
			fail("String nula");
		} catch (Exception e) {
			assertEquals(CAMPO_INVALIDO, e.getMessage());
		}

		try {
			ze = new Noob("Jose", "zeca", 300, 1200, null);
			fail("map null");
		} catch (Exception e) {
			assertEquals("jogosComprados nao pode ser null", e.getMessage());
		}
		
		try {
			ze = new Noob("Jose Carlos", "zeca", -3, 1200, jogosComprados);
			fail("Saldo negativo");
		} catch (Exception e) {
			assertEquals(VALOR_INVALIDO, e.getMessage());
		}
	}
	
	@Test
	public void testCompraJogoNoob() throws Exception {
		ze = new Noob("Jose Carlos", "zeca", 300, 0, jogosComprados);
		
		assertTrue(ze.compraJogo(skyrim));
		assertEquals(210, ze.getSaldo(), 0.01);
		assertEquals(1000, ze.getX2p());
		
		assertTrue(ze.compraJogo(mk));
		assertEquals(183, ze.getSaldo(), 0.01);
		assertEquals(1300, ze.getX2p());
		
		assertFalse(ze.compraJogo(lol));
		assertEquals(183, ze.getSaldo(), 0.01);
		assertEquals(1300, ze.getX2p());
	}
	
	@Test
	public void testCompraJogoVeterano() throws Exception {
		ze = new Veterano("Jose Carlos", "zeca", 300, 1000, jogosComprados);
		assertEquals(1000, ze.getX2p());

		
		assertTrue(ze.compraJogo(skyrim));
		assertEquals(220, ze.getSaldo(), 0.01);
		assertEquals(2500, ze.getX2p());
		
		assertTrue(ze.compraJogo(mk));
		assertEquals(196, ze.getSaldo(), 0.01);
		
		assertFalse(ze.compraJogo(lol));
		assertEquals(196, ze.getSaldo(), 0.01);
	}
	
	@Test
	public void testCompraJogoExcecao() {
		try {
			emerson.compraJogo(null);
			fail("Jogo nulo");
		} catch (Exception e) {
			assertEquals("jogo nao pode ser null", e.getMessage());
		}
	}
	
	@Test
	public void testRegistraJogada() throws Exception {
		emerson = new Noob("Emerson", "Emiso", 300, 0, jogosComprados);
		emerson.compraJogo(skyrim);
		
		emerson.registraJogada("Skyrim", 100, true);
		assertEquals(1010, emerson.getX2p());
		
		emerson.registraJogada("Skyrim", 110, false);
		assertEquals(1020, emerson.getX2p());
	}

}
