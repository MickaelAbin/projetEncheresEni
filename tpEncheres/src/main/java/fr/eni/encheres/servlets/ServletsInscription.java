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
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int credit = 100;
    	Utilisateur utilisateur = new Utilisateur(
               request.getParameter("pseudo"),
               request.getParameter("nom"),
               request.getParameter("prenom"),
               request.getParameter("email"),
               request.getParameter("telephone"),
               request.getParameter("rue"),
               request.getParameter("codePostal"),
               request.getParameter("ville"),
               request.getParameter("motDePasse"),
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
     }
 }

        
    
    
