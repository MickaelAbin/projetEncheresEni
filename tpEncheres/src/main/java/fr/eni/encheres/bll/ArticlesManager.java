/**
 * 
 */
package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Articles;
import fr.eni.encheres.dall.DAOfactory;


/**
 * @author tgerdelat2022
 *
 */
public class ArticlesManager {
private static ArticlesManager instance;
	
	public static ArticlesManager getInstance() {
		if(instance == null) {
			instance = new ArticlesManager();
		}
		return instance;
	}
	
	private ArticlesManager() { }
	
	public List<Articles> selectAll() {
		return DAOfactory.getArticlesDAO().selectAll();
	}
	
	public void delete(int idListe) {
		//TODO: vérification des données
		DAOfactory.getArticlesDAO().delete(idListe);
	}
}
