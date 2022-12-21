package fr.eni.encheres.dall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.servlets.Connexion;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private final static String SELECT_ALL = "Select * from Utilisateurs";
	private final static String DELETE = "DELETE FROM Utilisateurs WHERE no_utilisateur=?;";
	private final static String SELECT_BY_ID = "Select * FROM Utilisateurs WHERE no_utilisateur=?;";
	private final static String AJOUTER_UTILISATEUR = "insert into UTILISATEURS values (?,?,?,?,?,?,?,?,?,100,0);";
	private final static String SELECT_BY_PSEUDO = "Select * FROM Utilisateurs WHERE pseudo=?;";
	private final static String SQL_UPDATE = "update UTILISATEURS set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=? WHERE no_utilisateur=?";
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
	public void insert(Utilisateur utilisateur) {
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
	
	public Utilisateur verificationIdentifiant(String identifiant) {
		Utilisateur identifiantTrouve = null;
		try(Connection cnx = ConnectionProvider.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while(rs.next()) {
            	if (rs.getString("pseudo").equals(identifiant)) {
                    String pseudo = rs.getString("pseudo");
                    String motDePasse = rs.getString("mot_de_passe");
                    
                    identifiantTrouve = new Utilisateur(pseudo, motDePasse);
                    
				}
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return identifiantTrouve;
	}
	
	public Utilisateur verificationMotDePasse(Utilisateur utilisateur, String motDePasse) {
		
		Utilisateur utilisateurConnecter = null;
		
		if (utilisateur.getMotDePasse().equals(motDePasse)) {
			utilisateurConnecter = utilisateur;
		}
		
		return utilisateurConnecter;
		
	}


	public Utilisateur selectByPseudo(String pseudo) {
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		Utilisateur utilisateur = null;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			pStmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pStmt.setString(1, pseudo);
			
            rs = pStmt.executeQuery();
            
            if (rs.next()) {
            	int idUtilisateur = rs.getInt("no_utilisateur");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                String rue = rs.getString("rue");
                String codePostal = rs.getString("code_postal");
                String ville = rs.getString("ville");
                
                utilisateur = new Utilisateur(idUtilisateur, pseudo, nom, prenom,email,telephone,rue,codePostal,ville);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return utilisateur;
	}
	
	public void modifier(Utilisateur utilisateur) {
        PreparedStatement preparedStatement = null;
 
        try (Connection cnx = ConnectionProvider.getConnection()){
 
            preparedStatement = cnx.prepareStatement(SQL_UPDATE);        		
            preparedStatement.setString(1, utilisateur.getPseudo());
            preparedStatement.setString(2, utilisateur.getNom());
            preparedStatement.setString(3, utilisateur.getPrenom());
            preparedStatement.setString(4, utilisateur.getEmail());
            preparedStatement.setString(5, utilisateur.getTelephone());
			preparedStatement.setString(6, utilisateur.getRue());
			preparedStatement.setString(7, utilisateur.getCodePostal());
			preparedStatement.setString(8, utilisateur.getVille());
			preparedStatement.setString(9, utilisateur.getMotDePasse());
 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
    }
	}
	
	/*public Utilisateur selectUtilisateurByPseudo(String pseudo) throws SQLException{
		Connection cnx = ConnectionProvider.getConnection();
        Utilisateur utilisateur = null;
        try {
            String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
            stmt.setString(1, pseudo);
            stmt.execute();
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;*/
    }
	/*public Eleve rechercher(Eleve eleve) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Eleve unEleve= null;
		
		cnx = DBConnexion.seConnecter();
		
		try {
			pstmt = cnx.prepareStatement(RECHERCHER);
			pstmt.setString(1, eleve.getNom());
			pstmt.setString(2, eleve.getPrenom());
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				unEleve = new Eleve();
				unEleve.setNom(rs.getString("nom"));
				unEleve.setPrenom(rs.getString("prenom"));
				rs.getString("adresse");
				if (rs.wasNull()) {
					unEleve.setAdresse("<<non renseignée>>");
				} else {
					unEleve.setAdresse(rs.getString("adresse"));
				}
			}
			
		} catch (SQLException e) {
			throw new DALException("probleme methode rechercher", e);
		} finally {
			DBConnexion.seDeconnecter(pstmt, cnx);
		}
		
		return unEleve;
	}*/
	


