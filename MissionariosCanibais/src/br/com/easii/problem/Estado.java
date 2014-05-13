/**
 * 
 */
package br.com.easii.problem;

import java.util.LinkedList;
import java.util.List;

import br.com.easii.enums.PosicaoDoBarco;

/**
 * @author Ronyerison
 *
 */
public class Estado {
	
	private Integer missionarios;
	private Integer canibais;
	private PosicaoDoBarco posicaoDoBarco;
	private Estado estadoPai;
	private Integer custo;
	
	/**
	 * @param missionarios
	 * @param canibais
	 * @param posicaoDoBarco
	 * @param estadoPai
	 * @param custo
	 */
	public Estado(Integer missionarios, Integer canibais,
			PosicaoDoBarco posicaoDoBarco, Estado estadoPai, Integer custo) {
		super();
		this.missionarios = missionarios;
		this.canibais = canibais;
		this.posicaoDoBarco = posicaoDoBarco;
		this.estadoPai = estadoPai;
		this.custo = custo;
	}
	
	
	/**
	 * @return the missionarios
	 */
	public int getMissionarios() {
		return missionarios;
	}

	/**
	 * @param missionarios the missionarios to set
	 */
	public void setMissionarios(int missionarios) {
		this.missionarios = missionarios;
	}


	/**
	 * @return the canibais
	 */
	public int getCanibais() {
		return canibais;
	}

	/**
	 * @param canibais the canibais to set
	 */
	public void setCanibais(int canibais) {
		this.canibais = canibais;
	}

	/**
	 * @return the posicaoDoBarco
	 */
	public PosicaoDoBarco getPosicaoDoBarco() {
		return posicaoDoBarco;
	}

	/**
	 * @param posicaoDoBarco the posicaoDoBarco to set
	 */
	public void setPosicaoDoBarco(PosicaoDoBarco posicaoDoBarco) {
		this.posicaoDoBarco = posicaoDoBarco;
	}

	/**
	 * @return the estadoPai
	 */
	public Estado getEstadoPai() {
		return estadoPai;
	}

	/**
	 * @param estadoPai the estadoPai to set
	 */
	public void setEstadoPai(Estado estadoPai) {
		this.estadoPai = estadoPai;
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
	 * @return True se o objetivo foi atingido e False se não
	 */
	public boolean isCompleted(){
		if(this.missionarios == 0 && this.canibais == 0 && this.posicaoDoBarco == PosicaoDoBarco.DIREITA){
			return true;
		}
		return false;
	}
	
	
	/**
	 * @return True se a quantidade de missionarios em cada margem é maior 
	 * ou igual a quantidade de canibais
	 */
	public boolean isValid(){
		if(this.canibais > this.missionarios && this.missionarios != 0){
			return false;
		}else if((3 - this.canibais) > (3 - this.missionarios) && (3 - this.missionarios) != 0){
			return false;
		}else if(this.missionarios < 0 || this.canibais < 0){
			return false;
		}else{
			return true;
		}
		
	}
	
	
	/**
	 * @return Lista dos possiveis estados a serem expandidos para o estado atual
	 */
	public List<Estado> expandir(){
		Estado novoEstado;
		List<Estado> fronteira = new LinkedList<>();
		novoEstado = Movimentacao.moverUmMissionario(this);
		if(novoEstado.isValid()){
			fronteira.add(novoEstado);
		}
		novoEstado = Movimentacao.moverDoisMissionarios(this);
		if(novoEstado.isValid()){
			fronteira.add(novoEstado);
		}
		novoEstado = Movimentacao.moverUmCanibal(this);
		if(novoEstado.isValid()){
			fronteira.add(novoEstado);
		}
		novoEstado = Movimentacao.moverDoisCanibais(this);
		if(novoEstado.isValid()){
			fronteira.add(novoEstado);
		}
		novoEstado = Movimentacao.moverUmDeCada(this);
		if(novoEstado.isValid()){
			fronteira.add(novoEstado);
		}
		
		return fronteira;
	}
	
	public Estado getClone(Estado estado) {
		return new Estado(estado.getMissionarios(), estado.getCanibais(), estado.getPosicaoDoBarco(), estado.getEstadoPai(), null);
	}
	
	@Override
	public boolean equals(Object obj) {
		Estado estado = (Estado) obj;
		if(this.getCanibais() == estado.getCanibais() && 
				this.getMissionarios() == estado.getMissionarios() &&
				this.getPosicaoDoBarco().equals(estado.getPosicaoDoBarco()) &&
				this.getEstadoPai().equals(estado.getEstadoPai())){
			return true;
		}
		return false;
	}
}
