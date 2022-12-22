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
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletNouvelleEnchere
 */
@WebServlet("/ServletNouvelleEnchere")
public class ServletNouvelleEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNouvelleEnchere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        
		int idArticle = (int) session.getAttribute("idArticle");
		String url = "/tpEncheres/ServletDetailVente?id=" + String.valueOf(idArticle);
		if (session.getAttribute("utilisateurConnecte") != null) {
			int prix = Integer.parseInt(request.getParameter("PRIX"));
			
			Utilisateur utilisateurSession = (Utilisateur) session.getAttribute("utilisateurConnecte");
			int credit = utilisateurSession.getCredit();
			
			if (credit >= prix) {
		        
		        Article article = new Article(idArticle);
		       
		        
		        LocalDate dateDuJour = LocalDate.now();
		        Enchere enchere = new Enchere(utilisateurSession,article,dateDuJour,prix);
				
		        EnchereManager.getInstance().ajouterEnchere(enchere);
		        session.removeAttribute("idArticle");
				response.sendRedirect("/tpEncheres/Accueil");
				
				
			}else {
				session.setAttribute("erreurCredit", "Vous n'avez pas assez de crédit");
				response.sendRedirect(url);
			}
			
	        
		} 
		else {
			response.sendRedirect(url);
		}
		
        
	}

}
