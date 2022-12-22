package fr.eni.encheres.bll;

import java.sql.SQLException;
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
	
	public void ajouterEnchere(Enchere enchere) throws SQLException {
		DAOFactory.getEnchereDAO().insert(enchere);
	}
	
}
