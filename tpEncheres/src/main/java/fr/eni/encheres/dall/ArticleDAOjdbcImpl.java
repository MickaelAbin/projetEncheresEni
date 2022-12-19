/**
 * 
 */
package fr.eni.encheres.dall;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

/**
 * @author tgerdelat2022
 *
 */
public class ArticleDAOjdbcImpl implements ArticleDAO {

	private final static String AJOUTER_NOUVELLE_VENTE = "insert into ARTICLES_VENDUS  (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_vendeur,no_categorie)values (?,?,?,?,?,?,?);";

	private final static String SELECT_ALL = "SELECT ARTICLES_VENDUS.no_article,nom_article,prix_initial,date_fin_encheres,pseudo,description,libelle,RETRAITS.rue,RETRAITS.code_postal,RETRAITS.ville FROM ARTICLES_VENDUS INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_vendeur=UTILISATEURS.no_utilisateur INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie=CATEGORIES.no_categorie INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article=RETRAITS.no_article;";

	private final static String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE idListe=?;";

	private static final String AJOUTER_RETRAIT = "insert into RETRAITS (no_article,rue,code_postal,ville)  values (?,?,?,?);";
	
	private static final String SEARCH_BY_ID ="SELECT ARTICLES_VENDUS.no_article, nom_article,prix_initial,date_fin_encheres,pseudo,description,libelle,RETRAITS.rue,RETRAITS.code_postal,RETRAITS.ville FROM ARTICLES_VENDUS INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_vendeur=UTILISATEURS.no_utilisateur INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie=CATEGORIES.no_categorie INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article=RETRAITS.no_article where ARTICLES_VENDUS.no_article=?;";
	
	public List<Article> selectAll() {
		List<Article> listes = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			Statement stmt = cnx.createStatement();

			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				
				int noArticle = rs.getInt("no_article");
				String nom = rs.getString("nom_article");
				int prixEntre = rs.getInt("prix_initial");
				Date fin = rs.getDate("date_fin_encheres");
				String vendeur = rs.getString("pseudo");
				String description = rs.getString("description");
				String libelle = rs.getString("libelle");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				
				
			Categorie categorie = new Categorie(libelle);	
			Retrait retrait = new Retrait(rue,codePostal,ville)	;
			Utilisateur utilisateur = new Utilisateur(vendeur);
			Article article = new Article( noArticle, nom,description, fin.toLocalDate(), prixEntre,utilisateur,categorie,retrait );
				listes.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listes;
	}
	public Article selectById(int id) {
		
		Article article= null;
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(SEARCH_BY_ID);
			
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				int noArticle = rs.getInt("no_article");
				String nom = rs.getString("nom_article");
				int prixEntre = rs.getInt("prix_initial");
				Date fin = rs.getDate("date_fin_encheres");
				String vendeur = rs.getString("pseudo");
				String description = rs.getString("description");
				String libelle = rs.getString("libelle");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				
				
			Categorie categorie = new Categorie(libelle);	
			Retrait retrait = new Retrait(rue,codePostal,ville)	;
			Utilisateur utilisateur = new Utilisateur(vendeur);
		  article = new Article( noArticle, nom,description, fin.toLocalDate(), prixEntre,utilisateur,categorie,retrait );
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return article ;
	}	

	public void delete(int idListe) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE);
			pStmt.setInt(1, idListe);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Article article) {
		System.out.println(article);
		System.out.println("test");
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(AJOUTER_NOUVELLE_VENTE, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, article.getNomArticle());
			pStmt.setString(2, article.getDescription());
			pStmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			pStmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			pStmt.setInt(5, article.getPrixInitial());
			pStmt.setInt(6, article.getVendeur().getNoUtilisateur());
			pStmt.setInt(7, article.getCategorie().getNoCategorie());
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				article.setNombreArticle(rs.getInt(1));
				System.out.println("test");
System.out.println(article);
System.out.println("test");

				PreparedStatement pStmt2 = cnx.prepareStatement(AJOUTER_RETRAIT);

				pStmt2.setInt(1, article.getNombreArticle());
				pStmt2.setString(2, article.getRetrait().getRue());
				pStmt2.setString(3, article.getRetrait().getCodePostal());
				pStmt2.setString(4, article.getRetrait().getVille());
				pStmt2.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
