/**
 * 
 */
package br.com.easii.problem;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ronyerison
 *
 */
/**
 * @author Ronyerison
 *
 */
public class Solution {
	private Estado estadoFinal;
	private List<Estado> caminho;
	private Estado estadoInicial;
	
	
	/**
	 * @param estadoFinal
	 */
	public Solution(Estado estadoFinal) {
		super();
		this.estadoFinal = estadoFinal;
		getCaminho();
	}
	
	
	/**
	 * Guarda todos os estados até o estado final encontrado
	 */
	public void getCaminho() {
		Estado estado = this.estadoFinal;
		this.caminho = new LinkedList<Estado>();
		while(estado != null){
			this.caminho.add(estado);
			this.estadoInicial = estado;
			estado = estado.getEstadoPai();
		}
	}

	/**
	 * @return the estadoFinal
	 */
	public Estado getEstadoFinal() {
		return estadoFinal;
	}

	/**
	 * @param estadoFinal the estadoFinal to set
	 */
	public void setEstadoFinal(Estado estadoFinal) {
		this.estadoFinal = estadoFinal;
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
	 * @param caminho the caminho to set
	 */
	public void setCaminho(List<Estado> caminho) {
		this.caminho = caminho;
	}
	
	
}
