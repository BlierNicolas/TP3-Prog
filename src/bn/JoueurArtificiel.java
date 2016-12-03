package bn;

public class JoueurArtificiel extends AJoueur {
	
	boolean searchState;
	boolean isNormal;
	boolean attackState;
	private PileSimple nextTire;
	JoueurArtificiel(){
		super(); 
		searchState = true;
		attackState = false;
		isNormal = false;
	}

	@Override
	public void tire(IJoueur cible) {
		if(searchState && !attackState){
			Position posTirer = cible.getRandPositionGrille();	
			cible.recoitTire(posTirer);
			
			//S'il a toucher un navire
			if(cible.flotte.getGrille()[posTirer.getColonne()][posTirer.getRangee()].getEstOccuper()){
				attackState = true;
				setNextTire(posTirer, cible);
			}
		}
		if(isNormal && !searchState){
			if(!nextTire.estVide()){
				cible.recoitTire(nextTire.depile());
			}else{
				searchState = true;
			}
			
		}
		
		//Ajout stat
	}
	
	public void setIsNormal(boolean _value){
		this.isNormal = _value;
				
	}

	@Override
	public void recoitTire(Position position) {
		// TODO Auto-generated method stub
		
		position.setTouche(true);
		
	}
	
	private void setNextTire(Position _position, IJoueur _cible){
		//Ajouter NORD/SUD/EST/OUEST de _position dans le tableau NextTire
		
		
		nextTire.empile(new Position(_position.getColonne() + 1 ,_position.getRangee()));
		nextTire.empile(new Position(_position.getColonne() - 1 ,_position.getRangee()));
		nextTire.empile(new Position(_position.getColonne() ,_position.getRangee() + 1));
		nextTire.empile(new Position(_position.getColonne() ,_position.getRangee() - 1));
		/*
		if(_position.getRangee() + 1 <= MAX_RANGEE_COLONNE){
			if(!_cible.flotte.getGrille()[_position.getColonne()][_position.getRangee() + 1].getTouchee()){
				nextTire[0] = _cible.flotte.getGrille()[_position.getColonne()][_position.getRangee() + 1];
			}	
		}
		
		if(_position.getRangee() - 1 >= 0){
			if(!_cible.flotte.getGrille()[_position.getColonne()][_position.getRangee() - 1].getTouchee()){
				nextTire[1] = _cible.flotte.getGrille()[_position.getColonne()][_position.getRangee() - 1];
			}	
		}
		if(_position.getColonne() - 1 >= 0){
			if(!_cible.flotte.getGrille()[_position.getColonne()-1][_position.getRangee()].getTouchee()){
				nextTire[2] = _cible.flotte.getGrille()[_position.getColonne()-1][_position.getRangee()];
			}	
		}

		if(_position.getColonne() + 1 <= MAX_RANGEE_COLONNE){
			if(!_cible.flotte.getGrille()[_position.getColonne() + 1][_position.getRangee()].getTouchee()){
				nextTire[3] = _cible.flotte.getGrille()[_position.getColonne()+1][_position.getRangee()];
			}	
		}*/

		
		/*
		 * Ajouter les positions dans NextTire
		 */
		
		validationNextTire(_cible);
	}
	
	private void validationNextTire(IJoueur _cible){
		for(int i = 0; i< nextTire.getCompteur(); i++){
			Position refTemp = nextTire.getNext();
			if(refTemp.getColonne() >= 0 && refTemp.getColonne() <= MAX_RANGEE_COLONNE && 
					refTemp.getRangee() >= 0 && refTemp.getRangee() <= MAX_RANGEE_COLONNE){
				//Position est dans la grille
					
				//Si la position est toucher un set la position a null
				if(_cible.flotte.getGrille()[refTemp.getColonne()][refTemp.getRangee()].getTouchee()){
					//Remove Position from the list
					nextTire.depile();
				}
				
			}else{
				//Remove Position from the list
				nextTire.depile();
			}
			
		}
	}
	

}
