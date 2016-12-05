package bn;

import java.util.LinkedList;

public class Navire {
	private String nom;
	private LinkedList<Position> positions;
	private int longueur;


	//Constructeur
	public Navire(String _nom,int _longueur) {
		this.nom = _nom;
		this.positions = new LinkedList<Position>();
		this.longueur = _longueur;
	}
	/**
	 * Methode servant a determiner si le navire est coulee
	 * @return Vrai si le navire est coulee
	 */
	public boolean estCoule(){
		/**Strategie 
		 * Parcours chaque position du navire et reguarde si cette position est touchee.
		 * Si oui on incremente le compteur
		 * Si le compteur est egal a la longeur du navire Alors le navire est coule
		 */
		LinkedList<Position> position = getPosition();
		int compteur = 0;
		for(int i = 0; i< position.size(); i++){
			if(position.get(i).getEstTouchee()){
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
	
	/**
	 * Retourne une description simple du navire(Nom,Position,Longueur et s'il est coulee)
	 */
	public String toString() {
		String strRetour = "Navire: Position: ";
		for(int i=0; i<getPosition().size(); i++){
			strRetour += "{" + getPosition().get(i).getColonne() + ";" + getPosition().get(i).getRangee() + "} ";
		}
		return strRetour + this.nom + " est long de " + getLongueur() + " cases et le bateau est Coulee: " + estCoule();
	}
}
