/**
 * 
 */
package br.com.easii.find;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.easii.problem.Estado;
import br.com.easii.problem.Solution;
import br.com.easii.util.EstruturaDeDados;
import br.com.easii.util.Fila;
import br.com.easii.util.Pilha;

/**
 * @author Ronyerison
 *
 */
public class BuscaCega {
	private EstruturaDeDados fronteira;
	private List<Estado> visitados;
	private Estado estadoInicial;
	private Estado estadoAtual;
	private Integer maxFrontSize;
	
	/**
	 * @param estadoInicial
	 * @param fronteira
	 */
	public BuscaCega(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
		this.estadoAtual = estadoInicial;
		this.visitados = new LinkedList<Estado>();
		this.maxFrontSize = 0;
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
		this.maxFrontSize = 0;
	}
		
	/**
	 * @return retorna uma solução utilizando busca em profundidade
	 */
	public Solution buscaEmProfundidade(){
		this.estadoAtual = this.estadoInicial;
		this.fronteira = new Pilha();
		List<Estado> aux = new ArrayList<Estado>();
		this.fronteira.inserir(estadoAtual);
		do{
			if(this.fronteira.vazia()){
				return null;
			}
			if(estadoAtual.isCompleted()){
				return new Solution(estadoAtual, visitados.size(), maxFrontSize);
			}else{
				aux = estadoAtual.expandir();
				this.visitados.add(estadoAtual);
				this.fronteira.remover();
				for (Estado e : aux) {
					if(!testarVisitados(e)){
						this.fronteira.inserir(e);
					}
				}
				if(this.fronteira.size() > this.maxFrontSize){
					this.maxFrontSize = this.fronteira.size();
				}
			}
			estadoAtual = (Estado) ((Pilha) fronteira).top();
		}while(!estadoAtual.isCompleted());
		
		return new Solution(estadoAtual, visitados.size(), maxFrontSize);
	}
		
	/**
	 * @return retorna uma solução utilizando busca em largura
	 */
	public Solution buscaEmLargura(){
		this.estadoAtual = this.estadoInicial;
		this.fronteira = new Fila();
		List<Estado> aux = new ArrayList<Estado>();
		this.fronteira.inserir(estadoAtual);
		do{
			if(this.fronteira.vazia()){
				return null;
			}
			if(estadoAtual.isCompleted()){
				return new Solution(estadoAtual, visitados.size(), maxFrontSize);
			}else{
				aux = estadoAtual.expandir();
				this.visitados.add(estadoAtual);
				this.fronteira.remover();
				for (Estado e : aux) {
					if(!testarVisitados(e)){
						this.fronteira.inserir(e);
					}
				}
				
				if(this.fronteira.size() > this.maxFrontSize){
					this.maxFrontSize = this.fronteira.size();
				}
				
			}
			estadoAtual = ((Fila) this.fronteira).primeiroElemento();
		}while(!estadoAtual.isCompleted());
		
		return new Solution(estadoAtual, visitados.size(), maxFrontSize);
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
