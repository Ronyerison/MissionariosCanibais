/**
 * 
 */
package br.com.easii.find;

import java.util.LinkedList;
import java.util.List;

import br.com.easii.problem.Estado;
import br.com.easii.util.EstruturaDeDados;

/**
 * @author Ronyerison
 *
 */
public class BuscaCega {
	private EstruturaDeDados fronteira;
	private List<Estado> visitados;
	private Estado estadoInicial;
	private Estado estadoAtual;
	
	/**
	 * @param estadoInicial
	 * @param fronteira
	 */
	public BuscaCega(Estado estadoInicial, EstruturaDeDados fronteira) {
		this.estadoInicial = estadoInicial;
		this.estadoAtual = estadoInicial;
		this.fronteira = fronteira;
		this.fronteira.inserir(this.estadoAtual);
		this.visitados = new LinkedList<Estado>();
		this.visitados.add(this.estadoAtual);
	}

	/**
	 * @param fronteira
	 * @param visitados
	 * @param estadoInicial
	 * @param estadoAtual
	 */
	public BuscaCega(EstruturaDeDados fronteira, List<Estado> visitados,
			Estado estadoInicial, Estado estadoAtual) {
		this.fronteira = fronteira;
		this.visitados = visitados;
		this.estadoInicial = estadoInicial;
		this.estadoAtual = estadoAtual;
	}
		
	public Estado buscaEmProfundidade(){
		Estado estado = null;
		
		/*TODO: Implementar o metodo busca em profundidade */
		return estado;
	}
	
	public Estado buscaEmLargura(){
		Estado estado = null;
		
		/*TODO: Implementar o metodo busca em largura */
		return estado;
	}

	/**
	 * @return the fronteira
	 */
	public EstruturaDeDados getFronteira() {
		return fronteira;
	}

	/**
	 * @param fronteira the fronteira to set
	 */
	public void setFronteira(EstruturaDeDados fronteira) {
		this.fronteira = fronteira;
	}

	/**
	 * @return the visitados
	 */
	public List<Estado> getVisitados() {
		return visitados;
	}

	/**
	 * @param visitados the visitados to set
	 */
	public void setVisitados(List<Estado> visitados) {
		this.visitados = visitados;
	}

	/**
	 * @return the estadoInicial
	 */
	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	/**
	 * @param estadoInicial the estadoInicial to set
	 */
	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	/**
	 * @return the estadoAtual
	 */
	public Estado getEstadoAtual() {
		return estadoAtual;
	}

	/**
	 * @param estadoAtual the estadoAtual to set
	 */
	public void setEstadoAtual(Estado estadoAtual) {
		this.estadoAtual = estadoAtual;
	}
	
	
}
