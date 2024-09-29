package models;

//Declaration des variables 
public class Etudiant {
    private String matricule;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String ecole;
    private double moyenne;
    private String resultat;
    
    //Constructeur pour predefinir des valeurs exitantes dans la db pour des JUnits 
    public Etudiant(String matricule, String nom, String prenom, String resultat, Double moyenne) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.resultat = resultat;
        this.moyenne = moyenne;
    }
    //Constructeur pour Predefinir des valeurs pour des tests d'assertions    
    public Etudiant() {
        this.matricule = "";
        this.nom = "";
        this.prenom = "";
        this.resultat = "";
        this.moyenne = 0.0;
    }

	// Getters et setters pour chaque champ
    public String getMatricule() { 
    	return matricule; 
    }
    public void setMatricule(String matricule) {
    	this.matricule = matricule;
    }
    
    public String getNom() {
    	return nom; 
    }
    public void setNom(String nom) {
    	this.nom = nom; 
    }
    
    public String getPrenom() {
    	return prenom; 
	}
    public void setPrenom(String prenom) {
    	this.prenom = prenom; 
	}
    
    public String getDateNaissance() {
    	return dateNaissance; 	
	}
    public void setDateNaissance(String dateNaissance) {
    	this.dateNaissance = dateNaissance; 
	}
    
    public String getEcole() { 
    	return ecole; 
    }
    public void setEcole(String ecole) {
    	this.ecole = ecole; 
	}
    
    public double getMoyenne() { 
    	return moyenne; 
	}
    public void setMoyenne(double moyenne) {
    	this.moyenne = moyenne; 
	}
    
    public String getResultat() {
    	return resultat; 
	}
    public void setResultat(String resultat) {
    	this.resultat = resultat; 
	}
}
