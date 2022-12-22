package fr.eni.encheres.servlets;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
/**
 * Servlet implementation class Profil
 */
@WebServlet(description = "permet de s'inscrire au site d'enchere", urlPatterns = {"/Inscription"})
public class ServletsInscription extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ServletsInscription() {
        super();
       
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String pseudo = request.getParameter("pseudo");
    	String nom = request.getParameter("nom");
    	String prenom = request.getParameter("prenom");
    	String email = request.getParameter("email");
    	String telephone = request.getParameter("telephone");
    	String rue = request.getParameter("rue");
    	String codePostal = request.getParameter("codePostal");
    	String ville = request.getParameter("ville");
    	String motDePasse = request.getParameter("motDePasse");
    	String reMotDePasse = request.getParameter("reMotDePasse");
    	if (motDePasse.equals(reMotDePasse)) {
    		int credit = 100;
        	Utilisateur utilisateur = new Utilisateur(
                   pseudo,
                   nom,
                   prenom,
                   email,
                   telephone,
                   rue,
                   codePostal,
                   ville,
                   motDePasse,
                   credit //initialisation des crédits a 100
                   );
            
    	   try {
    		    
    		     UtilisateurManager.getInstance().ajouterUtilisateur(utilisateur);
    	                
    	                HttpSession session = request.getSession();
    	                session.setAttribute("utilisateurConnecte",utilisateur);
    	             
    	                this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
    	              
    	        } catch(IOException e) {
    	        	e.printStackTrace();
    	        
    	        }
		} else {
			request.setAttribute("pseudo", pseudo);
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("email", email);
			request.setAttribute("telephone", telephone);
			request.setAttribute("rue", rue);
			request.setAttribute("codePostal", codePostal);
			request.setAttribute("ville", ville);
			request.setAttribute("errorMDP", "Veuiller saisir un mot de passe identique au premier");
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);

		} 
        
     }
 }

        
    
    
