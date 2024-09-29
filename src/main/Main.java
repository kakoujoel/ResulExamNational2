package main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import dao.EtudiantDAO;
import models.Etudiant;
import ui.DetailView;

public class Main extends Application {
    private EtudiantDAO etudiantDAO = new EtudiantDAO();

    @Override
    public void start(Stage primaryStage) {
    	
    	 // Créer les éléments de l'interface utilisateur
        primaryStage.setTitle("Consultation de Résultats d'Examen");

        // Layout
        Label matriculeLabel = new Label("Entrez votre matricule:");
        TextField matriculeField = new TextField();
        Button searchButton = new Button("Rechercher");
        Button closeButton  = new Button("Fermer");
        Label resultLabel = new Label();

        // Action du bouton
        searchButton.setOnAction(e -> {
            String matricule = matriculeField.getText();
            Etudiant etudiant = etudiantDAO.rechercherEtudiantParMatricule(matricule);
            if (etudiant != null) {
                resultLabel.setText("Résultat: " + etudiant.getResultat());
                Button detailButton = new Button("Afficher les détails");
                detailButton.setOnAction(event -> {
                    DetailView.showDetailStage(etudiant);
                });
                ((VBox) primaryStage.getScene().getRoot()).getChildren().add(detailButton); 
                closeButton.setOnAction(event -> {
                	primaryStage.close();   
        	    });
            } else {
                resultLabel.setText("Étudiant non trouvé !");
            }
        });

        // Configuration de la scène
        VBox root = new VBox();
        root.getChildren().addAll( matriculeLabel, matriculeField,searchButton,closeButton, resultLabel);
        root.setSpacing(15);
        root.setAlignment(Pos.BASELINE_CENTER);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

