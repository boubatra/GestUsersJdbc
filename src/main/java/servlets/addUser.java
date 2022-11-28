package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import form.AddUserForm;

/**
 * Servlet implementation class addUser
 */
@WebServlet("/add")
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/ajouterUtilisateur.jsp";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		AddUserForm form = new AddUserForm(request);
		try {
			if (form.ajouter()) {
				response.sendRedirect("list");
			}
			else {
				request.setAttribute("status", form.isStatus());
				request.setAttribute("statusMessage", form.getStatusMessage());
				request.setAttribute("erreurs", form.getErreurs());
				request.setAttribute("utilisateur", form.getUtilisateur());
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR);
				dispatcher.forward(request, response);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
