package bn;

import java.util.LinkedList;

import listeDouble.ListeDouble;

public class Flotte {
	private Navire[] navires;
	private Position[][] grille;
	
	
	
	public Flotte() {
		initGrille();
		navires = new Navire[4];
		
	}
	
	/**
	 * Initialise la grille de jeu avec des positions par defauts
	 */
	private void initGrille(){
		grille = new Position[9][9];
		for(int i = 0; i<9; i++){
			for (int j = 0; j<9;j++){
				grille[i][j] = new Position(i,j);
			}
		}
	}
	
	
	
	public Position[][] getGrille(){
		return this.grille;
	}
	public void setGrille(Position[][] _grille){
		this.grille = _grille;
	}
	
	/**
	 * Set a Occuper les positions transmisent en parametre
	 * @param _positions Tableau de position que l'on souhaite rendre occuper
	 */
	public void setPositionsOccuper(LinkedList<Position> _positions){
		for(int i = 0; i< _positions.size(); i++){
			grille[_positions.get(i).getColonne()][_positions.get(i).getRangee()].setEstOccuper(true);
		}
		
	}
}
