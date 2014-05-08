package br.com.easii.enums;


/**
 * @author Ronyerison
 *
 */
public enum PosicaoDoBarco {
	DIREITA("direita", "O Barco encontra-se na margem direita do rio"),
	ESQUERDA("esquerda", "O Barco encontra-se na margem esquerda do rio");
	
	private String identifier;
	
	private String description;
	
	
	/**
	 * @param identifier
	 * @param description
	 */
	private PosicaoDoBarco(String identifier, String description) {
		this.identifier = identifier;
		this.description = description;
	}
	
	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}
	
	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	/**
	 * @param identifier
	 * @return
	 */
	public String getDescription(String identifier) {
		if(identifier != null){
			for (PosicaoDoBarco position : PosicaoDoBarco.values()) {
				if(position.getIdentifier().equalsIgnoreCase(identifier)){
					return position.description;
				}
			}
		}
		return null;
	}
	
	
	
	
}
