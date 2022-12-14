package fr.eni.encheres.test;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

public class testUtilisateur {
	public static void test() {
		
		//UtilisateurManager utilisateurManager = null ;
		Utilisateur utilisateur = UtilisateurManager.selectById(2);
		System.out.println(utilisateur);

	}
}
