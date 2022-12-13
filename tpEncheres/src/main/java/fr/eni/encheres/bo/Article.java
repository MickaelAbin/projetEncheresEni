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
	 */
	public Article(int nombreArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int prixVente, Utilisateur vendeur, int categorie) {
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
	public int getCategorie() {
		return categorie;
	}
	public void setNo_categorie(int categorie) {
		this.categorie = categorie;
	}
	
	@Override
	public String toString() {
		return "Articles [no_article=" + nombreArticle + ", nom_article=" + nomArticle + ", description=" + description
				+ ", date_debut_encheres=" + dateDebutEncheres + ", date_fin_encheres=" + dateFinEncheres
				+ ", prix_initial=" + prixInitial + ", prix_vente=" + prixVente + ", no_vendeur=" + vendeur
				+ ", no_categorie=" + categorie + "]";
	}

}
