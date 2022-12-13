package fr.eni.encheres.dall;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
List<Utilisateur> selectAll();
void delete(int id);
}
