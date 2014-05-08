/**
 * 
 */
package br.com.easii.problem;

import br.com.easii.enums.PosicaoDoBarco;

/**
 * @author Ronyerison
 *
 */
public class Estado {
	
	private int missionarios;
	private int canibais;
	private PosicaoDoBarco posicaoDoBarco;
	
	/**
	 * @param missionarios
	 * @param canibais
	 * @param posicaoDoBarco
	 */
	public Estado(int missionarios, int canibais, PosicaoDoBarco posicaoDoBarco) {
		super();
		this.missionarios = missionarios;
		this.canibais = canibais;
		this.posicaoDoBarco = posicaoDoBarco;
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
	 * @return True se o objetivo foi atingido e False se não
	 */
	public boolean isCompleted(){
		if(this.missionarios == 0 && this.canibais == 0 && this.posicaoDoBarco == PosicaoDoBarco.DIREITA){
			return true;
		}
		return false;
	}
	
	public boolean isValid(){
		if(this.canibais > this.missionarios && this.missionarios != 0){
			return false;
		}else if((3 - this.canibais) > (3 - this.missionarios) && (3 - this.missionarios) != 0){
			return false;
		}else{
			return true;
		}
		
	}
}
