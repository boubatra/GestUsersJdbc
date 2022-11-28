package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDao;
import form.UpdateUserForm;

/**
 * Servlet implementation class modifierUser
 */
@WebServlet("/update")
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_MODIF_UTILISATEUR = "/WEB-INF/modifierUtilisateur.jsp";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null && id.matches("[0-9]+")) {

			Utilisateur utilisateur = UtilisateurDao.get(Integer.parseInt(id));
			if (utilisateur != null) {
				request.setAttribute("utilisateur", utilisateur);
				getServletContext().getRequestDispatcher(VUE_MODIF_UTILISATEUR).forward(request, response);
				return;
			}

		}
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateUserForm form= new UpdateUserForm(request);
		request.setAttribute("statusMessage", form.getStatusMessage());
		try {
			if(form.modifier()) {
				response.sendRedirect("list");
				//getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
			}

			else {
				request.setAttribute("status", form.isStatus());
				request.setAttribute("statusMessage", form.getStatusMessage());
				request.setAttribute("utilisateur", form.getUtilisateur());
				request.setAttribute("erreurs", form.getErreurs());
				getServletContext().getRequestDispatcher(VUE_MODIF_UTILISATEUR).forward(request, response);
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
