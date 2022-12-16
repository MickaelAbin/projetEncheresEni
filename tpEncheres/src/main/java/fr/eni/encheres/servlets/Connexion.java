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

/**
 * Servlet implementation class Connexion
 */
@WebServlet(description = "permet de se connecter au site d'enchere", urlPatterns = { "/Connexion" })
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateurConnexion = new Utilisateur(
				request.getParameter("identifiant"),
				request.getParameter("motDePasse")
				);
		String messageConnexion = UtilisateurManager.connexionUtilisateur(utilisateurConnexion);
		session.setAttribute("messageConnexion", messageConnexion);
		String pseudo = utilisateurConnexion.getPseudo();
		
		session.setAttribute("testUtilisateur", utilisateurConnexion);
		
		Utilisateur utilisateurConnecte = null;
		if(messageConnexion.equals("Connexion valide")) {
			utilisateurConnecte = UtilisateurManager.selectByPseudo(pseudo);
			try {
				
				session.setAttribute("utilisateurConnecte", utilisateurConnecte);
			} catch (Exception e) {
				
			}
			
			response.sendRedirect("/tpEncheres/Accueil");
			//request.getRequestDispatcher("/WEB-INF/Accueil.jsp").FORWARD_SERVLET_PATH;
			//this.getServletContext().getRequestDispatcher("/WEB-INF/MonProfil.jsp").forward(request, response);
		}
		else {
			doGet(request, response);
		}
		
		
		
		
	}

}
