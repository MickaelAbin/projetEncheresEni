package fr.eni.encheres.dall;

import java.util.List;

import fr.eni.encheres.bo.Enchere;




public class test {

	public static void main(String[] args) {
		EnchereDAO enchereDAO = DAOfactory.getEnchereDAO();
		List<Enchere> encheres = EnchereDAO.selectAll();
		System.out.println("Sélection de tous les articles  : " + encheres.toString() );

	}

}
