/**
 * 
 */
package fr.eni.encheres.dall;

import fr.eni.encheres.servlets.Connexion;

/**
 * @author tgerdelat2022
 *
 */
public class DAOFactory {

	public static ArticleDAOjdbcImpl getArticlesDAO() {
		return new ArticleDAOjdbcImpl();
	}
	
	public static EnchereDAOJdbcImpl getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}
	
	public static UtilisateurDAOJdbcImpl getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	public static CategorieDAOJdbcImpl getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
	public static RetraitDAOJdbcImpl getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
	}

	public static Connexion getConnection() {
		return new Connexion();
	}
}
