package fr.eni.encheres.dall;

import java.util.List;

import fr.eni.encheres.bo.Enchere;



public interface EnchereDAO {
	
	List<Enchere> selectAll();
	
	void insert(Enchere enchere) ;
}
