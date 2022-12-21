package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dall.DAOFactory;


public class EnchereManager {
	
	public static EnchereManager instance;
	
	public static EnchereManager getInstance() {
		if(instance == null) {
			instance = new EnchereManager();
	}
		return instance;
	}
	
	private EnchereManager( ) {}
	
	public List<Enchere> selectAll(){
		return DAOFactory.getEnchereDAO().selectAll();
		
	}
	
	public void ajouterEnchere(Enchere enchere) {
		DAOFactory.getEnchereDAO().insert(enchere);
	}
	
}
