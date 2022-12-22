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
	private final static String UPDATE_PRIX_VENTE = "UPDATE ARTICLES_VENDUS set prix_vente=? where no_article=?";
	private final static String UPDATE_CREDIT= "UPDATE UTILISATEURS set credit= credit -? where no_utilisateur=?";
	private static final String SEARCH_PLUS_GROSSE_ENCHERE ="SELECT no_utilisateur,ENCHERES.montant_enchere FROM UTILISATEURS INNER JOIN ENCHERES ON UTILISATEURS.no_utilisateur=ENCHERES.no_acheteur  where (montant_enchere =( SELECT MAX(montant_enchere)from ENCHERES where no_article=?));";
	private static final String UPDATE_CREDIT_PERDANT = "UPDATE UTILISATEURS set credit= credit + ? where no_utilisateur=?";
	@Override
	public List<Enchere> selectAll() {
		List<Enchere> encheres = new ArrayList<>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();

			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				int numeroEnchere = rs.getInt("no_enchere");
				int acheteur = rs.getInt("no_acheteur");
				int article = rs.getInt("no_article ");
				Date dateEnchere = rs.getDate("date_enchere");
				int montantEnchere = rs.getInt("montant_enchere");

				Utilisateur utilisateur = new Utilisateur(acheteur);
				Article articleAVendre = new Article(article);
				Enchere uneEnchere = new Enchere(numeroEnchere, utilisateur, articleAVendre, dateEnchere.toLocalDate(),
						montantEnchere);
				encheres.add(uneEnchere);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return encheres;
	}

	@Override
	public void insert(Enchere enchere) throws SQLException {
		Connection cnx = ConnectionProvider.getConnection();
		//try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SEARCH_PLUS_GROSSE_ENCHERE);
			pStmt.setInt(1,enchere.getNoArticle().getNombreArticle());
			ResultSet rs = pStmt.executeQuery();
			
			System.out.println(rs);
			int montantEnchere = 0;
			int noUtilsateur = 0;
			if (rs.next()) {
				 noUtilsateur = rs.getInt("no_utilisateur");
				
				 montantEnchere = rs.getInt("montant_enchere");
		
			}
			
			PreparedStatement pStmt2 = cnx.prepareStatement(AJOUTER_NOUVELLE_ENCHERE);
			pStmt2.setInt(1, enchere.getNoAcheteur().getNoUtilisateur());
			pStmt2.setInt(2, enchere.getNoArticle().getNombreArticle());
			pStmt2.setDate(3, Date.valueOf(enchere.getDateEnchere()));
			pStmt2.setInt(4, enchere.getMontantEnchere());
			System.out.println(enchere);
			pStmt2.executeUpdate();

			PreparedStatement pStmt3 = cnx.prepareStatement(UPDATE_PRIX_VENTE);
			pStmt3.setInt(1, enchere.getMontantEnchere());
			pStmt3.setInt(2, enchere.getNoArticle().getNombreArticle());
			System.out.println(enchere);
			pStmt3.executeUpdate();
			System.out.println(enchere);
			
			PreparedStatement pStmt4 = cnx.prepareStatement(UPDATE_CREDIT);
			pStmt4.setInt(1, enchere.getMontantEnchere());
			pStmt4.setInt(2, enchere.getNoAcheteur().getNoUtilisateur());
			
			System.out.println(enchere);
			pStmt4.executeUpdate();
			
			System.out.println(enchere);
			
			PreparedStatement pStmt5 = cnx.prepareStatement(UPDATE_CREDIT_PERDANT);
			pStmt5.setInt(1, montantEnchere);
			pStmt5.setInt(2, noUtilsateur);
			pStmt5.executeUpdate();
			

		//} catch (SQLException e) {
		//	e.printStackTrace();
		//}

	
		}


}
