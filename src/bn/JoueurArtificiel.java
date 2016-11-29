package bn;

public class JoueurArtificiel extends AJoueur {
	
	boolean isSearching;
	boolean isAttacking;
	JoueurArtificiel(){
		super(); 
		isSearching = true;
	}

	@Override
	public void tire(IJoueur cible) {
		// TODO Auto-generated method stub
		if(isSearching && !isAttacking){
			Position posTirer = cible.getRandPositionGrille();	
			cible.recoitTire(posTirer);
			
			//S'il a toucher un navire
			if(cible.flotte.getGrille()[posTirer.getColonne()][posTirer.getRangee()].getEstOccuper()){
				isAttacking = true;
			
			}
		}
		
		//Ajout stat
	}

	@Override
	public void recoitTire(Position position) {
		// TODO Auto-generated method stub
		
		position.setTouche(true);
		
	}

}
