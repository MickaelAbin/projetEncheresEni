package fr.eni.encheres.bo;

public class Categorie {
	private int noCategorie;
	private String libelle;
	/**
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	public Categorie(int noCategorie) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the noCategorie
	 */
	public int getNoCategorie() {
		return noCategorie;
	}
	/**
	 * @param noCategorie the noCategorie to set
	 */
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [noCategorie=")
				.append(noCategorie)
				.append(", libelle=")
				.append(libelle)
				.append("]");
		return builder.toString();
	}
	
	
}
