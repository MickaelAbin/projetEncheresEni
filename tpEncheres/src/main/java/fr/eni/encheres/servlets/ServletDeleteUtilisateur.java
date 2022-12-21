package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ServletDeleteUtilisateur
 */
@WebServlet("/ServletDeleteUtilisateur")
public class ServletDeleteUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletDeleteUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors = new ArrayList<>();
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Accueil.jsp");
        UtilisateurManager um = new UtilisateurManager();
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
		int idUtilisateur = utilisateur.getNoUtilisateur();
		um.delete(idUtilisateur);
		
		response.sendRedirect("/tpEncheres/Deconnexion");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
