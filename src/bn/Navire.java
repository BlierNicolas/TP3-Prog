package bn;

import java.util.LinkedList;

public class Navire {
	private String nom;
	private LinkedList<Position> positions;
	private int longueur;


	
	public Navire(String _nom,int _longueur) {
		this.nom = _nom;
		this.positions = new LinkedList<Position>();
		this.longueur = _longueur;
	}
	
	public boolean estCoule(){
		LinkedList<Position> position = getPosition();
		int compteur = 0;
		for(int i = 0; i< position.size(); i++){
			if(position.get(i).getTouchee()){
				compteur ++;
			}	
		}
		
		if(compteur == position.size()){
			return true;
		}
		return false;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String _nom) {
		this.nom = _nom;
	}
	
	public LinkedList<Position> getPosition() {
		return this.positions;
	}
	
	public void setPosition(LinkedList<Position> _positions){
		this.positions = _positions;
	}
	
	public int getLongueur(){
		return this.longueur;
	}
	public void setLongueur(int _longueur){
		this.longueur = _longueur;
		}
		
	public String toString() {
		String strRetour = "Navire: Position: ";
		for(int i=0; i<getPosition().size(); i++){
			strRetour += "{" + getPosition().get(i).getColonne() + ";" + getPosition().get(i).getRangee() + "} ";
		}
		return strRetour + this.nom + " est long de " + getLongueur() + " cases et le bateau est Coulee: " + estCoule();
	}
}
