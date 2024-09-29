package test;

import models.Etudiant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EtudiantAssertJTest {

    private Etudiant etudiant;

    @BeforeEach
    public void setUp() {
        // Initialisation d'un objet Etudiant avec des valeurs prédéfinies
        etudiant = new Etudiant("123456", "Kakou", "Doe", "Succès", 15.5);
    }


    // Test pour assertFalse - Vérifie que la condition est fausse
    @Test
    public void testEtudiantEchec() {
        etudiant.setMoyenne(8.0);
        assertFalse(etudiant.getMoyenne() > 10, "La moyenne ne devrait pas être supérieure à 10");
    }

    // Test pour assertEquals - Vérifie que les valeurs attendue et réelle sont égales
    @Test
    public void testEtudiantNomEquals() {
        assertEquals("Kakou", etudiant.getNom(), "Le nom de l'étudiant devrait être Kakou");
    }

    // Test pour assertNotEquals - Vérifie que les valeurs attendue et réelle ne sont pas égales
    @Test
    public void testEtudiantNomNotEquals() {
        assertNotEquals("John", etudiant.getNom(), "Le nom de l'étudiant ne devrait pas être John");
    }

    // Test pour assertArrayEquals - Vérifie que les tableaux attendus et réels sont égaux
    @Test
    public void testEtudiantMoyenneArrayEquals() {
        double[] moyennesAttendue = {15.5, 14.0, 18.0};
        double[] moyennesReelle = {15.5, 14.0, 18.0};
        assertArrayEquals(moyennesAttendue, moyennesReelle, "Les tableaux de moyennes devraient être identiques");
    }

    // Test pour assertSame - Vérifie que les objets attendus et réels font référence au même objet
    @Test
    public void testEtudiantReferenceSame() {
        Etudiant etudiant2 = etudiant; // Référence à etudiant
        assertSame(etudiant, etudiant2, "Les deux objets devraient être les mêmes références");
    }

}
