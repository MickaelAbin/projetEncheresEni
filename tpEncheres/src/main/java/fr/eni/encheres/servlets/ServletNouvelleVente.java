package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/NouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletNouvelleVente() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur vendeur = (Utilisateur) session.getAttribute("utilisateur");
		String nomArticle = request.getParameter("article");
		String description = request.getParameter("description");
		String dateDebut = request.getParameter("DateDebut");
		String dateFin = request.getParameter("DateFin");
		String prix = request.getParameter("PRIX");
		int categorie = Integer.parseInt(request.getParameter("categorie")) ;
		System.out.println(categorie);
		
		// TODO allez chercher idVendeur de la session
		LocalDate dateDeb = null;
		dateDeb = LocalDate.parse(dateDebut);
		LocalDate dateF = null;
		dateF = LocalDate.parse(dateDebut);
		int prixf = Integer.parseInt(prix);
		
		
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");

		Retrait retrait = new Retrait(rue, codePostal, ville);
		Categorie categorieChoisi = new Categorie(categorie);
		Article article = new Article(nomArticle, description, dateDeb, dateF, prixf, vendeur, categorieChoisi,retrait);

		

		/*
		 * UtilisateurManager utilisateurManager = new UtilisateurManager();
		 * UtilisateurManager.ajouterUtilisateur(utilisateur);
		 */

		try {
			ArticleManager.getInstance().ajouterArticle(article);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
