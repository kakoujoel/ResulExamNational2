package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Etudiant;

public class DetailView {
    public static void showDetailStage(Etudiant etudiant) {
        Stage detailStage = new Stage();
        detailStage.setTitle("Détails de l'étudiant");

        Label matriculeLabel = new Label("Matricule: " + etudiant.getMatricule());
        Label nomLabel = new Label("Nom: " + etudiant.getNom());
        Label prenomLabel = new Label("Prénom: " + etudiant.getPrenom());
        Label dateNaissanceLabel = new Label("Date de naissance: " + etudiant.getDateNaissance());
        Label ecoleLabel = new Label("École: " + etudiant.getEcole());
        Label moyenneLabel = new Label("Moyenne: " + etudiant.getMoyenne());

        // Ajout du bouton "Fermer"
        Button closeButton = new Button("Fermer");
        closeButton.setOnAction(e -> detailStage.close());

        // Ajouter les éléments dans un VBox
        VBox vbox = new VBox(10, matriculeLabel, nomLabel, prenomLabel, dateNaissanceLabel, ecoleLabel, moyenneLabel, closeButton);
        Scene scene = new Scene(vbox, 300, 250);
        detailStage.setScene(scene);
        detailStage.show();
    }
}
