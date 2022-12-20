/**
 * 
 */
package fr.eni.encheres.dall;

import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;

/**
 * @author tgerdelat2022
 *
 */
public interface ArticleDAO {
	List<Article> selectAll();
	Categorie selectByLibelle(String libelle);
	
	void delete(int id);
}
