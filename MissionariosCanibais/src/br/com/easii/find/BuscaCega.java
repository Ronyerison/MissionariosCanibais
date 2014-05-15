/**
 * 
 */
package br.com.easii.find;

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
		this.visitados.add(this.estadoAtual.getClone(this.estadoAtual));
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
		
	/**
	 * @return retorna uma solução utilizando busca em profundidade
	 */
	public Solution buscaEmProfundidade(){
		this.estadoAtual = this.estadoInicial;
		this.fronteira = new Pilha();
		List<Estado> aux = new LinkedList<Estado>();
		do{
			if(estadoAtual.isCompleted()){
				return new Solution(estadoAtual);
			}else{
				aux = estadoAtual.expandir();
				((Pilha) this.fronteira.getObjetos()).remover();
				for (Estado e : aux) {
					if(!testarVisitados(e)){
						this.fronteira.inserir(e);
					}
				}
				this.visitados.add(estadoAtual);
			}
			estadoAtual = (Estado) ((Pilha) fronteira.getObjetos()).top();
		}while(!estadoAtual.isCompleted());
		
		return new Solution(estadoAtual);
	}
		
	/**
	 * @return retorna uma solução utilizando busca em largura
	 */
	public Solution buscaEmLargura(){
		this.estadoAtual = this.estadoInicial;
		this.fronteira = new Fila();
		List<Estado> aux = new LinkedList<Estado>();
		do{
			if(estadoAtual.isCompleted()){
				return new Solution(estadoAtual);
			}else{
				aux = estadoAtual.expandir();
				((Fila) this.fronteira.getObjetos()).remover();
				for (Estado e : aux) {
					if(!testarVisitados(e)){
						this.fronteira.inserir(e);
					}
				}
				this.visitados.add(estadoAtual);
			}
			estadoAtual = (Estado) fronteira.getObjetos().get(0);
		}while(!estadoAtual.isCompleted());
		
		return new Solution(estadoAtual);
	}
	
	/**
	 * @param estado
	 * @return verifica se o estado ja esta na lista de visitados
	 */
	public boolean testarVisitados(Estado estado){
		for (Estado e : this.visitados) {
			if(e.equals(estado)){
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
