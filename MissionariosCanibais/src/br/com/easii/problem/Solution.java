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
	private Integer countVisitados;
	private Integer maxFrontSize;
	
	
	
	public Solution(Estado estadoFinal, Integer countVisitados, Integer maxFrontSize) {
		super();
		this.estadoFinal = estadoFinal;
		this.countVisitados = countVisitados;
		this.maxFrontSize = maxFrontSize;
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
	
	/**
	 * @return the countVisitados
	 */
	public Integer getCountVisitados() {
		return countVisitados;
	}

	/**
	 * @param countVisitados the countVisitados to set
	 */
	public void setCountVisitados(Integer countVisitados) {
		this.countVisitados = countVisitados;
	}

	/**
	 * @return the maxFrontSize
	 */
	public Integer getMaxFrontSize() {
		return maxFrontSize;
	}

	/**
	 * @param maxFrontSize the maxFrontSize to set
	 */
	public void setMaxFrontSize(Integer maxFrontSize) {
		this.maxFrontSize = maxFrontSize;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Solution [estadoFinal=" + estadoFinal + ", estadoInicial=" + estadoInicial
				+ ", caminho=" + caminho + "]";
	}
	
	public String mostraCaminho(){
		EstruturaDeDados caminho = this.caminho;
		String string = "";
		while(!caminho.vazia()){
			string += ((Pilha)caminho).top().toString();
			caminho.remover();
		}
		string += "\nQuant nós visitados = " + countVisitados +
				"\nQuant Max Fronteira = " + maxFrontSize;
		return string;
	}
	
	
}
