package fr.eni.encheres.dall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private final static String SELECT_ALL = "Select * from Utilisateur";
	private final static String DELETE = "DELETE FROM Utilisateur WHERE id=?;";
	private final static String SELECT_BY_ID = "Select * FROM Utilisateur WHERE id=?;";
	
	public List<Utilisateur> selectAll() {
        List<Utilisateur> listes = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while(rs.next()) {
                int id = rs.getInt("no_utilisateur");
                String pseudo = rs.getString("pseudo");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                String rue = rs.getString("rue");
                String codePostal = rs.getString("code_postal");
                String ville = rs.getString("ville");
                
                Utilisateur utilisateur = new Utilisateur(id, pseudo, nom, prenom,email,telephone,rue,codePostal,ville);
                listes.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listes;
    }

	
	public void delete(int id) {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE);
			pStmt.setInt(1, id);
			pStmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	
	public Utilisateur selectById(int id) {
		Utilisateur utilisateur = null;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_ID);
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
			Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_BY_ID);
            
            int idUtilisateur = rs.getInt("no_utilisateur");
            String pseudo = rs.getString("pseudo");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String email = rs.getString("email");
            String telephone = rs.getString("telephone");
            String rue = rs.getString("rue");
            String codePostal = rs.getString("code_postal");
            String ville = rs.getString("ville");
            
            utilisateur = new Utilisateur(idUtilisateur, pseudo, nom, prenom,email,telephone,rue,codePostal,ville);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return utilisateur;
	}
}
