/**
 * 
 */
package fr.eni.encheres.dall;


/**
 * @author tgerdelat2022
 *
 */
public class DAOfactory {

	public static ArticlesDAOjdbcImpl getArticlesDAO() {
		return new ArticlesDAOjdbcImpl();
	}
}
