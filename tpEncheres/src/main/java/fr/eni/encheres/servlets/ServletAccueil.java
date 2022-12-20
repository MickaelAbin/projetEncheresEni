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

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;



@WebServlet(description = "permet d'acceder a l'accueil du site", urlPatterns = {"/Accueil"})
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ServletAccueil() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//permet de recuperer toutes les catégories 
        List<Categorie> listeCategories = CategorieManager.getInstance().selectAll();
        session.setAttribute("listeCategories", listeCategories);
        List<Article> articles = ArticleManager.getInstance().affichageVente();
		
        session.setAttribute("listeArticles", articles);
		
		
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (request.getParameter("categorie.value").equals("toutes")) {
			session.setAttribute("rechercheCategorie", "toutes les categories");
		}
		else {
			session.setAttribute("rechercheCategorie", request.getParameter("categorie.value"));
		}
		
		if (request.getParameter("filtre").equals("achats")) {
			session.setAttribute("rechercheAchat", "Achats");
		}
		/*else {
			session.removeAttribute("rechercheAchat");
		}*/
			
		else if (request.getParameter("filtre").equals("mesVentes")) {
			session.setAttribute("rechercheVente", "ventes");
		}
		
		
		
		doGet(request, response);
		
		
	}
	
}
