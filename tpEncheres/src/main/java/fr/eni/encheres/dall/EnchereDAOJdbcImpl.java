package fr.eni.encheres.dall;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private final static String SELECT_ALL = "SELECT * FROM ENCHERES;";
	private final static String AJOUTER_NOUVELLE_ENCHERE = "insert into ENCHERES  (no_acheteur,no_article,date_enchere,montant_enchere)values (?,?,?,?);";

	@Override
	public List<Enchere> selectAll() {
		List<Enchere> encheres = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection()){
			Statement stmt = cnx.createStatement();
			
				ResultSet rs = stmt.executeQuery(SELECT_ALL);
				while(rs.next()) {
					int numeroEnchere = rs.getInt("no_enchere");
					int acheteur = rs.getInt("no_acheteur");
					int article = rs.getInt("no_article ");
					Date dateEnchere = rs.getDate("date_enchere");
					int montantEnchere = rs.getInt("montant_enchere");
					
					Utilisateur utilisateur = new Utilisateur(acheteur);
					Article articleAVendre = new Article(article);
					Enchere uneEnchere = new Enchere(numeroEnchere,utilisateur,articleAVendre,dateEnchere.toLocalDate(),montantEnchere);
					encheres.add(uneEnchere);
				}
		} catch (SQLException e) {
		
				e.printStackTrace();
			}
	
		return encheres;
	}

	@Override
	public void insert(Enchere enchere) {
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(AJOUTER_NOUVELLE_ENCHERE, Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, enchere.getNoAcheteur().getNoUtilisateur());
			pStmt.setInt(2, enchere.getNoArticle().getNombreArticle());
			pStmt.setDate(3, Date.valueOf(enchere.getDateEnchere()));
			pStmt.setInt(4, enchere.getMontantEnchere());
	
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				enchere.setNoEnchere(rs.getInt(1));
			

			

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
