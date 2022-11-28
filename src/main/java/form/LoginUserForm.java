package form;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class LoginUserForm {

	
		private static final String LOGIN = "login";
		private static final String PASSWORD = "password";
		private static final String ERROR_LOGIN = "Login ou mot de passe incorrect";

		
		
		private HttpServletRequest request;
		private Map<String, String> errors;
		private Map<String, String> credidentials;
		private boolean status;
		
		
		public LoginUserForm(HttpServletRequest request) {
			this.request = request;
			this.status = false;
			this.errors = new HashMap<String, String>();
			this.credidentials = new HashMap<String, String>();
		}

		public Map<String, String> getCredidentials() {
			return credidentials;
		}

		public boolean login() throws ClassNotFoundException, SQLException {
			
		
			this.validerChamps(LOGIN, PASSWORD);
			this.processLogin();
			
			if(this.errors.isEmpty()) {
				
				 this.status = true;
				
			}
			
			return status;
		
		}
		
		public Map<String, String> getErrors() {
			return errors;
		}

		public boolean isStatus() {
			return status;
		}


		public String getParameter(String parametre) {
			String valeur = this.request.getParameter(parametre);
			return (valeur == null || valeur.trim().isEmpty()) ? null : valeur.trim();
		}
		
		private void validerChamps(String...champs) {
			for(String champ : champs){
				if(this.getParameter(champ) == null) {
					errors.put("error", ERROR_LOGIN);
				}
			}
		}
		
		private void processLogin() throws ClassNotFoundException, SQLException {
			String login = this.getParameter(LOGIN);
			String password = this.getParameter(PASSWORD);
			if(password != null || login != null) {
				if(UtilisateurDao.login(login,password)) {
					credidentials.put("login",login);
				} else {
					errors.put("error",ERROR_LOGIN);
					errors.put("login",login);
				}
			}
		}
	}


