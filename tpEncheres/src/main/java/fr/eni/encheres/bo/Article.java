/**
 * 
 */
package fr.eni.encheres.bo;


import java.time.LocalDate;
import java.util.Locale.Category;

/**
 * @author tgerdelat2022
 *
 */
public class Article {
	private int nombreArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private Utilisateur vendeur;
	private Categorie categorie;
	private Retrait retrait;
	private String etatVente;
	
	
	
	/**
	 * @param nombreArticle
	 */
	public Article(int nombreArticle) {
		super();
		this.nombreArticle = nombreArticle;
	}


	/**
	 * @param nombreArticle
	 * @param nomArticle
	 * @param description
	 * @param dateFinEncheres
	 * @param prixVente
	 * @param vendeur
	 * @param categorie
	 * @param retrait
	 */
	public Article(int nombreArticle, String nomArticle, String description, LocalDate dateFinEncheres, int prixVente,
			Utilisateur vendeur, Categorie categorie, Retrait retrait) {
		super();
		this.nombreArticle = nombreArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEncheres = dateFinEncheres;
		this.prixVente = prixVente;
		this.vendeur = vendeur;
		this.categorie = categorie;
		this.retrait = retrait;
	}


	


	/**
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param vendeur
	 * @param categorie
	 * @param retrait
	 */
	public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int prixInitial, Utilisateur vendeur, Categorie categorie, Retrait retrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.vendeur = vendeur;
		this.categorie = categorie;
		this.retrait = retrait;
	}


	/**
	 * @param nomArticle
	 * @param description
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param vendeur
	 * @param categorie
	 * @param retrait
	 */
	public Article(String nomArticle, String description, LocalDate dateFinEncheres, int prixInitial,
			Utilisateur vendeur, Categorie categorie, Retrait retrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.vendeur = vendeur;
		this.categorie = categorie;
		this.retrait = retrait;
	}


	/**
	 * @param nomArticle
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param vendeur
	 */
	public Article(String nomArticle, LocalDate dateFinEncheres, int prixInitial, Utilisateur vendeur) {
		super();
		this.nomArticle = nomArticle;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.vendeur = vendeur;
	}


	/**
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 */
	public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int prixInitial) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
	}


	/**
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param vendeur
	 * @param categorie
	 */
	public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int prixInitial, Utilisateur vendeur, Categorie categorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.vendeur = vendeur;
		this.categorie = categorie;
	}


	/**
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param categorie
	 */
	public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int prixInitial, Categorie categorie) {
	
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.categorie = categorie;
	}


	/**
	 * @param nombreArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param vendeur
	 * @param categorie
	 * @param etatVente
	 */
	public Article(int nombreArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int prixVente, Utilisateur vendeur, Categorie categorie, String etatVente) {
		super();
		this.nombreArticle = nombreArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.vendeur = vendeur;
		this.categorie = categorie;
		this.etatVente = etatVente;
	}
	
	
	public String getEtatVente() {
		return etatVente;
	}


	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}


	public int getNombreArticle() {
		return nombreArticle;
	}
	public void setNombreArticle(int nombreArticle) {
		this.nombreArticle = nombreArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public int getPrixInitial() {
		return prixInitial;
	}
	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public Utilisateur getVendeur() {
		return vendeur;
	}
	public void setNo_vendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setNo_categorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	/**
	 * @return the retrait
	 */
	public Retrait getRetrait() {
		return retrait;
	}


	/**
	 * @param retrait the retrait to set
	 */
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}


	/**
	 * @param vendeur the vendeur to set
	 */
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}


	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [nombreArticle=").append(nombreArticle).append(", nomArticle=").append(nomArticle)
				.append(", description=").append(description).append(", dateDebutEncheres=").append(dateDebutEncheres)
				.append(", dateFinEncheres=").append(dateFinEncheres).append(", prixInitial=").append(prixInitial)
				.append(", prixVente=").append(prixVente).append(", vendeur=").append(vendeur).append(", categorie=")
				.append(categorie).append(", retrait=").append(retrait).append(", etatVente=").append(etatVente)
				.append("]");
		return builder.toString();
	}

	
	

}
