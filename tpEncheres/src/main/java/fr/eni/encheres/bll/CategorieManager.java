package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dall.DAOFactory;

public class CategorieManager {
	private static CategorieManager instance;
	
	public static CategorieManager getInstance() {
		if(instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}
	
	public List<Categorie> selectAll() {
		return DAOFactory.getCategorieDAO().selectAll();
	}
}
