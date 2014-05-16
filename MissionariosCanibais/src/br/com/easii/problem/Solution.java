/**
 * 
 */
package br.com.easii.problem;

import br.com.easii.util.EstruturaDeDados;
import br.com.easii.util.Pilha;

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
	private EstruturaDeDados caminho;
	private Estado estadoInicial;
	
	
	/**
	 * @param estadoFinal
	 */
	public Solution(Estado estadoFinal) {
		super();
		this.estadoFinal = estadoFinal;
		gerarCaminho();
	}
	
	
	/**
	 * Guarda todos os estados até o estado final encontrado
	 */
	public void gerarCaminho() {
		Estado estado = this.estadoFinal;
		this.caminho = new Pilha();
		while(estado != null){
			this.caminho.inserir(estado);;
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
	 * @return the caminho
	 */
	public EstruturaDeDados getCaminho() {
		return caminho;
	}


	/**
	 * @param caminho the caminho to set
	 */
	public void setCaminho(EstruturaDeDados caminho) {
		this.caminho = caminho;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Solution [estadoFinal=" + estadoFinal + ", estadoInicial=" + estadoInicial
				+ ", caminho=" + caminho + "]";
	}
	
	
	
	
}
