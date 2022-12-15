package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;


@WebServlet("/NouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ServletNouvelleVente() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article article = new Article(
	               request.getParameter("article"),
	               request.getParameter("description"),
	               request.getParameter("DateDebut"),
	               request.getParameter("DateFin"),
	               request.getParameter("PRIX"),
	               request.getParameter("categorie")
	               );
			   /*
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				UtilisateurManager.ajouterUtilisateur(utilisateur);
				*/
			
			UtilisateurManager.getInstance().ajouterUtilisateur(utilisateur);
		doGet(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp");
		rd.forward(request, response);
		
	}
	
}

