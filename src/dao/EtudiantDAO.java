package dao;

import models.Etudiant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Méthode pour rechercher un étudiant par matricule
public class EtudiantDAO {
    private static final String URL = "jdbc:mysql://ls-0f19f4268096a452a869b6f8467bc299c51da519.cz6cgwgke8xd.eu-west-3.rds.amazonaws.com:3306/db0072464";
    private static final String USER = "user0072464";
    private static final String PASSWORD = "Yf3IgyBsOPa34WR";

    public Etudiant rechercherEtudiantParMatricule(String matricule) {
        Etudiant etudiant = null;
        String query = "SELECT * FROM etudiants WHERE matricule = ?";
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, matricule);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                etudiant = new Etudiant();
                etudiant.setMatricule(resultSet.getString("matricule"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiant.setDateNaissance(resultSet.getString("date_naissance"));
                etudiant.setEcole(resultSet.getString("ecole"));
                etudiant.setMoyenne(resultSet.getDouble("moyenne"));
                etudiant.setResultat(resultSet.getDouble("moyenne") >= 10 ? "Succès" : "Échec");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }
}
