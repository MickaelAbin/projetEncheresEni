package fr.eni.encheres.dall;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.util.ConnectionProvider;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private final static String SELECT_ALL = "SELECT * FROM ENCHERES;";

	@Override
	public List<Enchere> selectAll() {
		List<Enchere> encheres = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection()){
			Statement stmt = cnx.createStatement();
			
				ResultSet rs = stmt.executeQuery(SELECT_ALL);
				while(rs.next()) {
					int numeroEnchere = rs.getInt("no_enchere");
					Utilisateur acheteur = rs.getInt("no_acheteur");
					Article article = rs.getInt("no_article ");	
					Date dateEnchere = rs.getDate("date_enchere");
					int montantEnchere = rs.getInt("montant_enchere");
					Enchere uneEnchere = new Enchere(numeroEnchere,acheteur,article,dateEnchere,montantEnchere);
					encheres.add(uneEnchere);
				}
		} catch (SQLException e) {
		
				e.printStackTrace();
			}
	
		return encheres;
	}

	@Override
	public void insert(Enchere enchere) {
		// TODO Auto-generated method stub

	}

}
