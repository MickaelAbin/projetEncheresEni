package fr.eni.encheres.bll;

import java.util.List;

import javax.servlet.http.HttpSession;

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
		
		public UtilisateurManager() { }
		
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
		
		public static void ajouterUtilisateur(Utilisateur utilisateur) {
			DAOFactory.getUtilisateurDAO().ajouterUtilisateur(utilisateur);
		}
		
		public static void connexionUtilisateur(Utilisateur utilisateur) {
			String identifiant = utilisateur.getPseudo();
			Utilisateur utilisateurConnecte = DAOFactory.getUtilisateurDAO().verificationIdentifiant(identifiant);
			String motDePasse = utilisateurConnecte.getMotDePasse();
			HttpSession utilisateurEnSession;
			
			if (!(utilisateurConnecte == null)) {
				Utilisateur utilisateurVerifiMotDePasse = DAOFactory.getUtilisateurDAO().verificationMotDePasse(utilisateurConnecte, motDePasse);
				if (!(utilisateurVerifiMotDePasse == null)) {
					//pseudo et mot de passe valide 
					
					
				}
				else {
					//mot de passe incorrect
				}
				
			}
			else {
				//pseudo non existant
			}
		}
		
}
