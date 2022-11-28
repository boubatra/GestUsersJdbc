package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import beans.Utilisateur;
public class UtilisateurDao {
		private static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		
		public static boolean ajouter(Utilisateur utilisateur) throws SQLException {
			String query="Insert into utilisateurs (nom, prenom,login,password) values (?,?,?,?)";
			try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_utilisateurs", "root", "");
	            PreparedStatement preparedStmt = connect.prepareStatement(query);
	            preparedStmt.setString(1, utilisateur.getNom());
	            preparedStmt.setString(2, utilisateur.getPrenom());
	            preparedStmt.setString(3, utilisateur.getLogin());
	            preparedStmt.setString(4, utilisateur.getPassword());
	            preparedStmt.executeUpdate();
	            System.out.println("Votre compte a bien ete cree !");
	            connect.close();
	            return true;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
		}
		
		public static ArrayList<Utilisateur> lister() throws SQLException{
			ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
			String query = "select id,nom,prenom,login,password from utilisateurs";
			try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_utilisateurs", "root", "");
	            PreparedStatement preparedStmt = connect.prepareStatement(query);
	            ResultSet rs = preparedStmt.executeQuery();
	            while (rs.next()) {
	                utilisateurs.add(new Utilisateur(rs.getInt(1),rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password")));
	            }
	            connect.close();
	            
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
			return utilisateurs;
		}
		
		public static boolean modifier(Utilisateur user) throws SQLException {
			
			for(Utilisateur utilisateur: utilisateurs) {
				
				if (utilisateur.getId() == user.getId()){
					
					String query = "update utilisateurs set nom=?, prenom=?, login=?, password=? where ('"+user.getId()+"')";
					user.setNom(utilisateur.getNom());
					user.setPrenom(utilisateur.getPrenom());
					user.setLogin(utilisateur.getLogin());
					user.setPassword(utilisateur.getPassword());
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_utilisateurs", "root", "");
						
						PreparedStatement ps = conn.prepareStatement(query);
						ps.setString(1, utilisateur.getNom());
						ps.setString(2, utilisateur.getPrenom());
						ps.setString(3, utilisateur.getLogin());
						ps.setString(4, utilisateur.getPassword());
						if(ps.executeUpdate()!=0) {
							return true;
						}
					}catch(SQLException | ClassNotFoundException e) {
						e.printStackTrace();
					}
					return true;
				}
			}
			
			return false;
		}
		
		public static boolean supprimer(int id) {
			String query = "delete from utilisateurs where id =?;";
			
			try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_utilisateurs", "root", "");
	            PreparedStatement preparedStmt = connect.prepareStatement(query);
	            preparedStmt.setInt(1, id);
	            preparedStmt.executeUpdate();
				System.out.println("Suppression effectuee !");
				connect.close();
				return true;
	    		
	        } 
			catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
			
		}
		
		public static Utilisateur get(int id) {
			for(Utilisateur  utilisateur : utilisateurs) {
				if (utilisateur.getId() == id) {
					return utilisateur;
				}
				
			}
			return null;
		}
		
		public static boolean login(String login, String password) throws ClassNotFoundException, SQLException {
			int isReg = 0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_utilisateurs", "root", "");
			if( connect != null) {
				String req = "SELECT * FROM utilisateurs WHERE login = '"+login+"' AND password ='"+password+"'";
				try {
					Statement ps = connect.createStatement();
					
					ResultSet rs = ps.executeQuery(req);
					while(rs.next()) {
						isReg++;
					}
					
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		   return isReg == 1 ? true : false;
		}

		public static Utilisateur getByUsername(String login) {
			
			for(Utilisateur user : utilisateurs) {
				if(login.equals(user.getLogin())) {
					return user;
				}
			}
			return null;
		}
}
