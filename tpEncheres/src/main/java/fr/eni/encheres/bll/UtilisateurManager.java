package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dall.DAOFactory;

public class UtilisateurManager {

	private static UtilisateurManager instance;
		
		public static UtilisateurManager getInstance() {
			if(instance == null) {
				instance = new UtilisateurManager();
			}
			return instance;
		}
		
		private UtilisateurManager() { }
		
		public List<Utilisateur> selectAll() {
			return DAOFactory.getUtilisateurDAO().selectAll();
		}
		
		public void delete(int idListe) {
			//TODO: vérification des données
			DAOFactory.getUtilisateurDAO().delete(idListe);
		}
		
		public static Utilisateur selectById(int id) {
			return DAOFactory.getUtilisateurDAO().selectById(id);
		}
		
}
