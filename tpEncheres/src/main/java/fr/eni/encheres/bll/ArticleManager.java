/**
 * 
 */
package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dall.DAOFactory;


/**
 * @author tgerdelat2022
 *
 */
public class ArticleManager {
private static ArticleManager instance;
	
	public static ArticleManager getInstance() {
		if(instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	
	private ArticleManager() { }
	
	public List<Article> selectAll() {
		return DAOFactory.getArticlesDAO().selectAll();
	}
	
	public void delete(int idListe) {
		//TODO: vérification des données
		DAOFactory.getArticlesDAO().delete(idListe);
	}
}
