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
@WebServlet("/MonProfil")
public class ServletsMonProfil extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ServletsMonProfil() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/MonProfil.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur(
               request.getParameter("pseudo"),
               request.getParameter("nom"),
               request.getParameter("prenom"),
               request.getParameter("email"),
               request.getParameter("telephone"),
               request.getParameter("rue"),
               request.getParameter("codePostal"),
               request.getParameter("ville"),
               request.getParameter("motDePasse")
               );
           /*
            UtilisateurManager utilisateurManager = new UtilisateurManager();
            UtilisateurManager.ajouterUtilisateur(utilisateur);
            */
        
   try {
	    
	     UtilisateurManager.getInstance().ajouterUtilisateur(utilisateur);
                
                HttpSession session = request.getSession();
                session.setAttribute("tilisateur",utilisateur);



               
                this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
            
            
        } catch(IOException e) {
        	e.printStackTrace();
        
        }
     }
 }

        
    
    
