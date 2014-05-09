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
public class No {
	
	private Estado estadoAtual;
	private No pai;
	private int custo;
	
	/**
	 * @param estadoAtual
	 * @param pai
	 * @param custo
	 */
	public No(Estado estadoAtual, No pai, int custo) {
		super();
		this.estadoAtual = estadoAtual;
		this.pai = pai;
		this.custo = custo;
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
	 * @return the pai
	 */
	public No getPai() {
		return pai;
	}
	
	/**
	 * @param pai the pai to set
	 */
	public void setPai(No pai) {
		this.pai = pai;
	}
	
	/**
	 * @return the custo
	 */
	public int getCusto() {
		return custo;
	}
	
	/**
	 * @param custo the custo to set
	 */
	public void setCusto(int custo) {
		this.custo = custo;
	}
	
	
	/**
	 * @return Os possiveis nós sucessores do nó atual
	 */
	public List<No> expandir(){
		Estado novoEstado;
		List<No> nosExpandidos = new LinkedList<>();
		
		novoEstado = Movimentacao.moverUmMissionario(estadoAtual);
		if(novoEstado.isValid()){
			nosExpandidos.add(new No(novoEstado, this, this.custo+1));
		}
		novoEstado = Movimentacao.moverDoisMissionarios(estadoAtual);
		if(novoEstado.isValid()){
			nosExpandidos.add(new No(novoEstado, this, this.custo+1));
		}
		novoEstado = Movimentacao.moverUmCanibal(estadoAtual);
		if(novoEstado.isValid()){
			nosExpandidos.add(new No(novoEstado, this, this.custo+1));
		}
		novoEstado = Movimentacao.moverDoisCanibais(estadoAtual);
		if(novoEstado.isValid()){
			nosExpandidos.add(new No(novoEstado, this, this.custo+1));
		}
		novoEstado = Movimentacao.moverUmDeCada(estadoAtual);
		if(novoEstado.isValid()){
			nosExpandidos.add(new No(novoEstado, this, this.custo+1));
		}
		return nosExpandidos;
	}
	
}
