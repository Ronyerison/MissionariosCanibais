/**
 * 
 */
package br.com.easii.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.easii.enums.PosicaoDoBarco;
import br.com.easii.find.AEstrela;
import br.com.easii.find.BuscaCega;
import br.com.easii.find.BuscaHeuristica;
import br.com.easii.problem.Estado;
import br.com.easii.problem.Solution;

/**
 * @author Ronyerison
 *
 */
public class TesteMissionarioscanibais {

	@Test
	public void testEquals() {
		Estado pai = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, null, 0);
		Estado estado1 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, pai, 0);
		Estado estado2 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, pai, 1);
		boolean result = estado1.isEqual(estado2);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testBuscaEmProfundidade() {
		Estado estado1 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, null, 0);
		Estado estadofinal = new Estado(0, 0, PosicaoDoBarco.DIREITA, null, 0);
		BuscaCega buscaCega = new BuscaCega(estado1);
		Long start = System.currentTimeMillis();
		Solution solution = buscaCega.buscaEmProfundidade();
		Long end = System.currentTimeMillis();
		System.out.println("\nProfundidade (Tempo = "+ (end-start) + " ms)\n");
		System.out.println(solution.mostraCaminho());
		boolean result = estadofinal.isEqual(solution.getEstadoFinal());
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testBuscaEmLargura() {
		Estado estado1 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, null, 0);
		Estado estadofinal = new Estado(0, 0, PosicaoDoBarco.DIREITA, null, 0);
		BuscaCega buscaCega = new BuscaCega(estado1);
		Long start = System.currentTimeMillis();
		Solution solution = buscaCega.buscaEmLargura();
		Long end = System.currentTimeMillis();
		System.out.println("\nLargura (Tempo = "+ (end-start) + " ms)\n");
		System.out.println(solution.mostraCaminho());
		boolean result = estadofinal.isEqual(solution.getEstadoFinal());
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testBuscaAEstrela() {
		Estado estado1 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, null, 0);
		Estado estadofinal = new Estado(0, 0, PosicaoDoBarco.DIREITA, null, 0);
		AEstrela aEstrela = new AEstrela(estado1);
		Long start = System.currentTimeMillis();
		Solution solution = aEstrela.execute();
		Long end = System.currentTimeMillis();
		System.out.println("\nAEstrela (Tempo = "+ (end-start) + " ms)\n");
		System.out.println(solution.mostraCaminho());
		boolean result = estadofinal.isEqual(solution.getEstadoFinal());
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testBuscaGulosa() {
		Estado estado1 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, null, 0);
		Estado estadofinal = new Estado(0, 0, PosicaoDoBarco.DIREITA, null, 0);
		BuscaHeuristica buscaGulosa = new BuscaHeuristica(estado1);
		Long start = System.currentTimeMillis();
		Solution solution = buscaGulosa.execute();
		Long end = System.currentTimeMillis();
		System.out.println("\nGulosa (Tempo = "+ (end-start) + " ms)\n");
		System.out.println(solution.mostraCaminho());
		boolean result = estadofinal.isEqual(solution.getEstadoFinal());
		Assert.assertEquals(true, result);
	}
}
