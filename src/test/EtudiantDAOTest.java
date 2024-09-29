package test;


import dao.EtudiantDAO;
import models.Etudiant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

 // Méthode exécutée avant chaque test
public class EtudiantDAOTest {
    private EtudiantDAO etudiantDAO;
    
     // Initialisation d'une instance d'EtudiantDAO
    @BeforeEach
    public void setUp() {
        etudiantDAO = new EtudiantDAO();
    }
    
   // Test de recherche d'un étudiant par matricule et verifier si les details correspondent
    @Test
    public void testRechercherEtudiantParMatriculeExist() {
        Etudiant etudiant = etudiantDAO.rechercherEtudiantParMatricule("123456");
        assertEquals("Doe", etudiant.getNom());
        assertEquals("John", etudiant.getPrenom());
        assertEquals("Succès", etudiant.getResultat());
    }

    // Test de recherche d'un étudiant avec un matricule inexistant
    @Test
    public void testRechercherEtudiantParMatriculeNotExist() {
        Etudiant etudiant = etudiantDAO.rechercherEtudiantParMatricule("999999");
        assertNull(etudiant);
    }

    // Test de recherche d'un étudiant avec un matricule existant
    @Test
    public void testRechercherEtudiantMoyenne() {
        Etudiant etudiant = etudiantDAO.rechercherEtudiantParMatricule("123456");
        assertEquals(16.5, etudiant.getMoyenne());
    }

    // Vérification que l'étudiant retourné est null
    @Test
    public void testRechercherEtudiantWithInvalidMatricule() {
        Etudiant etudiant = etudiantDAO.rechercherEtudiantParMatricule(null);
        assertNull(etudiant);
    }

    // Vérification que l'étudiant retourné est non-null
    @Test
    public void testRechercherEtudiantWithEmptyMatricule() {
        Etudiant etudiant = etudiantDAO.rechercherEtudiantParMatricule("");
        assertNull(etudiant);
    }
}

