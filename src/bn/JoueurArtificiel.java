package bn;

public class JoueurArtificiel extends AJoueur {
	
	boolean searchState;
	boolean isNormal;
	boolean attackState;
	private Position[] nextTire;//Ajouter File
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
				setNextTire(posTirer);
			}
		}
		if(isNormal && !searchState){
			if(nextTire[0] != null){
				cible.recoitTire(nextTire[0]);
			}else{
				searchState = true;
			}
			
		}
		
		//Ajout stat
	}
	
	private void setIsNormal(boolean _value){
		this.isNormal = _value;
				
	}

	@Override
	public void recoitTire(Position position) {
		// TODO Auto-generated method stub
		
		position.setTouche(true);
		
	}
	
	private void setNextTire(Position _position){
		//Ajouter NORD/SUD/EST/OUEST de _position dans le tableau NextTire
		
		Position Nord = new Position(_position.getColonne(), _position.getRangee() + 1);
		Position Sud =  new Position(_position.getColonne(), _position.getRangee() - 1);
		Position Ouest =  new Position(_position.getColonne() - 1, _position.getRangee());
		Position Est =  new Position(_position.getColonne() + 1, _position.getRangee());
		
		/*
		 * Ajouter les positions dans NextTire
		 */
		
		validationNextTire();
	}
	
	private void validationNextTire(){
		for(int i = 0; i< nextTire.length; i++){
			if(nextTire[i].getColonne() > 0 && nextTire[i].getColonne() < MAX_RANGEE_COLONNE && 
					nextTire[i].getRangee() > 0 && nextTire[i].getRangee() < MAX_RANGEE_COLONNE){
					//Position est bonne
					//Position doit pas etre tirer
				
			}else{
				//Remove Position from the list
				nextTire[i] = null;
			}
			
		}
	}
	

}
