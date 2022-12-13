/**
 * 
 */
package fr.eni.encheres.dall;


/**
 * @author tgerdelat2022
 *
 */
public class DAOFactory {

	public static ArticleDAOjdbcImpl getArticlesDAO() {
		return new ArticleDAOjdbcImpl();
	}
}
