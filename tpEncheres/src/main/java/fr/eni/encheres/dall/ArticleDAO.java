/**
 * 
 */
package fr.eni.encheres.dall;

import java.util.List;

import fr.eni.encheres.bo.Article;

/**
 * @author tgerdelat2022
 *
 */
public interface ArticleDAO {
List<Article> selectAll();
	
	void delete(int id);
}
