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

	public static ArticleDAO getArticlesDAO() {
		return new ArticleDAOjdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
	}

	public static Connexion getConnection() {
		return new Connexion();
	}
}
