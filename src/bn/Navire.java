package bn;

public class Navire {
	private String nom;
	private Position[] positions;

	
	public Navire(String _nom, Position[] _positions) {
		this.nom = _nom;
		this.positions = _positions;
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
	public String toString() {
		return this.nom + " est long de " + getPosition().length + " cases et le bateau est vivant: " + estCoule();
	}
}
