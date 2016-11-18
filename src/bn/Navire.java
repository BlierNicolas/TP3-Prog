package bn;

public class Navire {
	private String nom;
	private int longueur;
	private int cases;
	private boolean vivant;
	
	public Navire(String nom, int longueur, int cases, boolean vivant) {
		this.nom = nom;
		this.longueur = longueur;
		this.cases = cases;
		this.vivant = vivant;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		if (longueur < 2) {
			this.longueur = 2;
		} else if (longueur > 5) {
			this.longueur = 5;
		} else {
			this.longueur = longueur;
		}
	}
	
	public int getCases() {
		return this.cases;
	}
	public void setCases(int cases) {
		if (cases > longueur) {
			this.cases = this.longueur;
		} else if (cases < 0) {
			this.cases = 0;
		} else {
			this.cases = cases;
		}
		verifVivant();
	}
	
	public boolean getVivant() {
		return this.vivant;
	}
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}
	public void verifVivant() {
		if (this.cases == 0) {
			setVivant(false);
		} else {
			setVivant(true);
		}
	}
	
	public String toString() {
		return this.nom + " est long de " + this.longueur + " cases, " + this.cases + " cases sont encore en surface et le bateau est " + getVivant();
	}
}
