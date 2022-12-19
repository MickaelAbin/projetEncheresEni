package fr.eni.encheres.dall;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	private final static String SELECT_ALL = "Select * from Categories";

	@Override
	public List<Categorie> selectAll() {
		List<Categorie> listes = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while(rs.next()) {
            	int id = rs.getInt("no_categorie");
                String libelle = rs.getString("libelle");
                
                Categorie categorie = new Categorie(id, libelle);
                listes.add(categorie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listes;
	}

	@Override
	public void insert(Categorie enchere) {
		// TODO Auto-generated method stub

	}

}
