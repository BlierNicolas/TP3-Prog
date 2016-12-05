package bn;

public class JoueurHumain extends AJoueur {

	@Override
	public void tire(IJoueur cible) {
		// TODO Auto-generated method stub
		
		
		//Pour aide 
		//Appel this.setNextTire(_position, _cible);
		//Il suffira juste a envoyer la position du dernier dire du joueur 
		//et de faire this.getNextTire().depile();
		
	}

	@Override
	public void recoitTire(Position position) {
		// TODO Auto-generated method stub
		System.out.println("Joueur Tire a: {" + position.getColonne() + "," + position.getRangee() + "} Occuper:" + this.flotte.getGrille()[position.getColonne()][position.getRangee()].getEstOccuper());
		this.flotte.getGrille()[position.getColonne()][position.getRangee()].setEstTouche(true);
	}

}
