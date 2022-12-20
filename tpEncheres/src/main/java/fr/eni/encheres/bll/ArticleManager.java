/**
 * 
 */
package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dall.DAOFactory;
import fr.eni.encheres.exception.ApplicationException;


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
	
	public List<Article> affichageVente() {
		return DAOFactory.getArticlesDAO().selectAll();
	}
	
	public void delete(int idListe) {
		//TODO: vérification des données
		DAOFactory.getArticlesDAO().delete(idListe);
	}
	public void ajouterArticle(Article article) {
		DAOFactory.getArticlesDAO().insert(article);
	}
	public Article affichageArticle(int id) throws ApplicationException {
		return DAOFactory.getArticlesDAO().selectById( id);
	}
}
