package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SerrvletsProfil
 */
@WebServlet(description = "permet de voir son profil", urlPatterns = {"/MonProfil"})
public class ServletsMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletsMonProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Profil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Profil.jsp").forward(request, response);
		doGet(request, response);
	}

}
