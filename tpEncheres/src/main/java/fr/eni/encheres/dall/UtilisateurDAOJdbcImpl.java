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
	private final static String AJOUTER_UTILISATEUR = "Insert into Utilisateur values ("
			+ "pseudo=?,"
			+ "nom=?,"
			+ "prenom=?,"
			+ "email=?,"
			+ "telephone=?,"
			+ "rue=?,"
			+ "code_postal=?,"
			+ "ville=?,"
			+ "mot_de_passe=?,"
			+ "credit=0,"
			+ "administrateur=0);"
			;
	
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
	
	//manque ajout de controle dans la BDD que email et pseudo ne soient pas deja présent 
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(AJOUTER_UTILISATEUR);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
