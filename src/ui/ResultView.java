package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import dao.EtudiantDAO;
import models.Etudiant;

public class ResultView {
    private EtudiantDAO etudiantDAO = new EtudiantDAO();
    private Button detailButton;  // Déclarer le bouton une seule fois

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Consultation de Résultats d'Examen");

        Label matriculeLabel = new Label("Entrez votre matricule:");
        TextField matriculeField = new TextField();
        Button searchButton = new Button("Rechercher");

        Label resultLabel = new Label();
        detailButton = new Button("Afficher les détails");  // Initialisation ici
        detailButton.setVisible(false);  // Le bouton est caché par défaut

        // Bouton "Fermer" pour quitter l'application
        Button closeButton = new Button("Fermer");
        closeButton.setOnAction(e -> primaryStage.close());

        searchButton.setOnAction(e -> {
            String matricule = matriculeField.getText();
            Etudiant etudiant = etudiantDAO.rechercherEtudiantParMatricule(matricule);
            if (etudiant != null) {
                resultLabel.setText("Résultat: " + etudiant.getResultat());
                detailButton.setVisible(true);  // Rendre le bouton visible
                detailButton.setOnAction(event -> DetailView.showDetailStage(etudiant));  // Définir l'action
            } else {
                resultLabel.setText("Étudiant non trouvé !");
                detailButton.setVisible(false);  // Cacher le bouton si aucun étudiant n'est trouvé
            }
        });

        VBox vbox = new VBox(10, matriculeLabel, matriculeField, searchButton, resultLabel, detailButton, closeButton);
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
