package bn;

import listeDouble.ListeDouble;

public class Flotte {
	private ListeDouble navires;
	private Position[][] grille;
	
	
	
	public Flotte() {
		//this.navires = 0; 
		initGrille();
		
	}
	
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
	
	public void setPositionsOccuper(Position[] _positions){
		for(int i = 0; i< _positions.length; i++){
			grille[_positions[i].getColonne()][_positions[i].getRangee()].setEstOccuper(true);
		}
		
	}
}
