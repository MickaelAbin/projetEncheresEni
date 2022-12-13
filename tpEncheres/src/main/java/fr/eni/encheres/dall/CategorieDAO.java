package fr.eni.encheres.dall;

import java.util.List;

import fr.eni.encheres.bo.Categorie;


		public interface CategorieDAO {
		List<Categorie> selectAll();
	
		void insert(Categorie enchere) ;
}
