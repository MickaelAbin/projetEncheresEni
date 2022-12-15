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
import fr.eni.encheres.bo.Utilisateur;


/**
 * @author tgerdelat2022
 *
 */
public class ArticleDAOjdbcImpl implements ArticleDAO{
	
	private final static String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS;";
	
	private final static String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE idListe=?;";

	public List<Article> selectAll() {
		List<Article> listes = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			Statement stmt = cnx.createStatement();
			
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				int idArticle = rs.getInt("nombreArticle");
				String nom = rs.getString("nomArticle");
				String desc = rs.getString("description");
				Date debut = rs.getDate("dateDebutEncheres", null);
				Date fin = rs.getDate("dateFinEncheres", null);
				int prixEntre = rs.getInt("prixInitial");
				int prixSortie = rs.getInt("prixVente");
				int idVendeur = rs.getInt("vendeur");
				int idCategorie = rs.getInt("categorie");
				
				Article article = new Article(idArticle, nom, desc, debut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), fin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), prixEntre, prixSortie, idVendeur, idCategorie);
				listes.add(article);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listes;
	}

	public void delete(int idListe) {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE);
			pStmt.setInt(1, idListe);
			pStmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
