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
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

/**
 * @author tgerdelat2022
 *
 */
public class ArticleDAOjdbcImpl implements ArticleDAO {

	private final static String AJOUTER_NOUVELLE_VENTE = "insert into ARTICLES_VENDUS  (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_vendeur,no_categorie)values (?,?,?,?,?,?,?);";

	private final static String SELECT_ALL = "SELECT nom_article,prix_initial,date_fin_encheres,pseudo FROM ARTICLES_VENDUS INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_vendeur=UTILISATEURS.no_utilisateur;";

	private final static String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE idListe=?;";

	private static final String AJOUTER_RETRAIT = "insert into RETRAITS (no_article,rue,code_postal,ville)  values (?,?,?,?);";

	public List<Article> selectAll() {
		List<Article> listes = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			Statement stmt = cnx.createStatement();

			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				
				String nom = rs.getString("nom_article");
				int prixEntre = rs.getInt("prix_initial");
				Date fin = rs.getDate("date_fin_encheres");
				String vendeur = rs.getString("pseudo");
				
				
				
				
			Utilisateur utilisateur = new Utilisateur(vendeur);
			Article article = new Article( nom, fin.toLocalDate(), prixEntre,utilisateur );
				listes.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listes;
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
