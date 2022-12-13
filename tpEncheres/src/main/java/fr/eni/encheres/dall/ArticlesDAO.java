/**
 * 
 */
package fr.eni.encheres.dall;

import java.util.List;

import fr.eni.encheres.bo.Articles;

/**
 * @author tgerdelat2022
 *
 */
public interface ArticlesDAO {
List<Articles> selectAll();
	
	void delete(int id);
}
