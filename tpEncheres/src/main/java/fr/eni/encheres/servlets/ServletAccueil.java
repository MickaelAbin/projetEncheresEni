package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bo.Utilisateur;


@WebServlet(description = "permet d'acceder a l'accueil du site", urlPatterns = {"/Accueil"})
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ServletAccueil() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
		Utilisateur utilisateurCo = (Utilisateur) session.getAttribute("utilisateurConnecte");
		Utilisateur test = new Utilisateur("test", "test");
		//session.setAttribute("utilisateurConnecte", test);
		request.setAttribute("test", test);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}
	
}
