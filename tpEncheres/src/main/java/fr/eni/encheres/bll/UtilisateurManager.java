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
		
		public void ajouterUtilisateur(Utilisateur utilisateur) {
			DAOFactory.getUtilisateurDAO().insert(utilisateur);
		}
		
		public static String connexionUtilisateur(Utilisateur utilisateur) {
			String identifiant = utilisateur.getPseudo();
			Utilisateur utilisateurConnecte = DAOFactory.getUtilisateurDAO().verificationIdentifiant(identifiant);
			String motDePasse = utilisateur.getMotDePasse();
			String messageConnexion = "Identifiant invalide";
			
			
			if ((utilisateurConnecte != null)) {
				Utilisateur utilisateurVerifiMotDePasse = DAOFactory.getUtilisateurDAO().verificationMotDePasse(utilisateurConnecte, motDePasse);
				if (!(utilisateurVerifiMotDePasse == null)) {
					messageConnexion = "Connexion valide";
					
				}else {
					messageConnexion = "Mot de passe invalide";
				}
				
			}
			
			return messageConnexion;
		}
		
		public static Utilisateur selectByPseudo(String pseudo) {
			Utilisateur utilisateur =  DAOFactory.getUtilisateurDAO().selectByPseudo(pseudo);
			
			return utilisateur;
		}
		public void modifier(Utilisateur utilisateur) {
			 DAOFactory.getUtilisateurDAO().modifier(utilisateur);
		}
}
