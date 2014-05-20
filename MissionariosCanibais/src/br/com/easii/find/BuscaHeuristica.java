/**
 * 
 */
package br.com.easii.find;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import br.com.easii.problem.Estado;
import br.com.easii.problem.Solution;

/**
 * @author Ronyerison
 *
 */
public class BuscaHeuristica {
	private List<Estado> fronteira;
	private List<Estado> visitados;
	private Estado estadoInicial;
	private Estado estadoAtual;
	private Integer maxFrontSize;

	/**
	 * @param estadoInicial
	 */
	public BuscaHeuristica(Estado estadoInicial) {
		super();
		this.estadoInicial = estadoInicial;
		this.estadoAtual = estadoInicial;
		this.visitados = new LinkedList<Estado>();
		this.fronteira = new ArrayList<Estado>();
		this.maxFrontSize = 0;
	}

	public Solution execute(){
		this.fronteira.add(estadoAtual);
		List<Estado> aux = new ArrayList<>();
		do{
			if(this.fronteira.isEmpty()){
				return null;
			}
			if(estadoAtual.isCompleted()){
				return new Solution(estadoAtual, visitados.size(), maxFrontSize);
			}else{
				aux = estadoAtual.expandir();
				this.visitados.add(estadoAtual);
				this.fronteira.remove(estadoAtual);
				for (Estado e : aux) {
					if(!testarVisitados(e)){
						this.fronteira.add(e);
					}
				}
				
				if(this.fronteira.size() > this.maxFrontSize){
					this.maxFrontSize = this.fronteira.size();
				}
			}
			
			Collections.sort(this.fronteira, new Comparator<Estado>() {
				@Override
				public int compare(Estado o1, Estado o2) {
					return o1.compareTo(o2);
				}
			});
			
			estadoAtual = this.fronteira.get(0);
		
		}while(!estadoAtual.isCompleted());
		
		return new Solution(estadoAtual,visitados.size(), maxFrontSize);
	}
	
	/**
	 * @param estado
	 * @return verifica se o estado ja esta na lista de visitados
	 */
	public boolean testarVisitados(Estado estado){
		for (Estado es : this.visitados) {
			if(es.isEqual(estado)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return the fronteira
	 */
	public List<Estado> getFronteira() {
		return fronteira;
	}

	/**
	 * @param fronteira the fronteira to set
	 */
	public void setFronteira(List<Estado> fronteira) {
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
	
	
	
}
