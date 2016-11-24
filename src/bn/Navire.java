package bn;

public class Navire {
	private String nom;
	private Position[] positions;
	private int longueur;


	
	public Navire(String _nom,int _longueur) {
		this.nom = _nom;
		this.positions = null;
		this.longueur = _longueur;
	}
	
	public boolean estCoule(){
		Position[] position = getPosition();
		int compteur = 0;
		for(int i = 0; i< position.length; i++){
			if(position[i].getTouchee()){
				compteur ++;
			}	
		}
		
		if(compteur == position.length){
			return false;
		}
		return true;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String _nom) {
		this.nom = _nom;
	}
	
	public Position[] getPosition() {
		return this.positions;
	}
	
	public void setPosition(Position[] _positions){
		this.positions = _positions;
	}
	
	public int getLongueur(){
		return this.longueur;
	}
	public void setLongueur(int _longueur){
		this.longueur = _longueur;
		}
		
	public String toString() {
		return this.nom + " est long de " + getPosition().length + " cases et le bateau est vivant: " + estCoule();
	}
}
