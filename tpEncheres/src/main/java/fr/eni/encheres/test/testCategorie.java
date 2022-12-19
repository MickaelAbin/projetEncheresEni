package fr.eni.encheres.test;

import java.util.List;



import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bo.Categorie;

public class testCategorie {
	
	
	
	public static void test() {
		
		//UtilisateurManager utilisateurManager = null ;
		List<Categorie> listeCat = CategorieManager.getInstance().selectAll();
		for (Categorie categorie : listeCat) {
			System.out.println(categorie.getLibelle());
		}

	}
}
