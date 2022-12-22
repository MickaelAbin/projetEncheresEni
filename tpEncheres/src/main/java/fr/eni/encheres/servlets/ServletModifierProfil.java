package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dall.UtilisateurDAO;
import fr.eni.encheres.dall.UtilisateurDAOJdbcImpl;


@WebServlet("/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletModifierProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/ModifierProfil.jsp").forward(request, response);    
	}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email= request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String motDePasse = request.getParameter("motDePasse");
        int idUtilisateur = ((Utilisateur) session.getAttribute("utilisateurConnecte")).getNoUtilisateur();
        int credit = ((Utilisateur) session.getAttribute("utilisateurConnecte")).getCredit();
        Utilisateur utilisateur = new Utilisateur(idUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit);
        
        try {
    	    
   	     UtilisateurManager.getInstance().modifier(utilisateur);
                   
                   
                   session.setAttribute("utilisateurConnecte",utilisateur);
                
                   this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
                   
               
           } catch(IOException e) {
           	e.printStackTrace();
           
           }
     	
	}

}
