package fr.eni.encheres.bo;

import java.sql.Date;
import java.time.LocalDate;


public class Enchere {
	private int noEnchere;
	private Utilisateur acheteur;
	private Article article;
	private LocalDate dateEnchere;
	private int montantEnchere;
	/**
	 * @param noEnchere
	 * @param acheteur
	 * @param article
	 * @param dateEnchere
	 * @param montantEnchere
	 */
	public Enchere(int noEnchere, Utilisateur acheteur, Article article, LocalDate dateEnchere, int montantEnchere) {
		this.noEnchere = noEnchere;
		this.acheteur = acheteur;
		this.article = article;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	
	/**
	 * @param acheteur
	 * @param article
	 * @param dateEnchere
	 * @param montantEnchere
	 */
	public Enchere(Utilisateur acheteur, Article article, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.acheteur = acheteur;
		this.article = article;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}


	/**
	 * @param acheteur
	 * @param montantEnchere
	 */
	public Enchere(Utilisateur acheteur, int montantEnchere) {
		super();
		this.acheteur = acheteur;
		this.montantEnchere = montantEnchere;
	}


	/**
	 * @return the noEnchere
	 */
	public int getNoEnchere() {
		return noEnchere;
	}
	/**
	 * @param noEnchere the noEnchere to set
	 */
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	/**
	 * @return the noAcheteur
	 */
	public Utilisateur getNoAcheteur() {
		return acheteur;
	}
	/**
	 * @param noAcheteur the noAcheteur to set
	 */
	public void setNoAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}
	/**
	 * @return the noArticle
	 */
	public Article getNoArticle() {
		return article;
	}
	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(Article article) {
		this.article = article;
	}

	/**
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}
	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [noEnchere=")
				.append(noEnchere)
				.append(", noAcheteur=")
				.append(acheteur)
				.append(", noArticle=")
				.append(article)
				.append(", dateEnchere=")
				.append(dateEnchere)
				.append(", montantEnchere=")
				.append(montantEnchere)
				.append("]");
		return builder.toString();
	}
	
	
	

}
