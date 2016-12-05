package bn;

public class JoueurHumain extends AJoueur {

	@Override
	public void tire(IJoueur cible) {
		// TODO Auto-generated method stub

		//Je n'ai pas réussi à obtenir les données pour les dispositions de la cases de la grille
		Position position = new Position(grilleAI.getColumns(), grilleAI.getRows(), false, false);
		this.setNextTire(position, cible);
		this.getNextTire().depile();
		
	}
	@Override
	public void placeNavire(Navire _navire){
		//Pour placer le navire du joueur humain
	}

	@Override
	public void recoitTire(Position position) {
		// TODO Auto-generated method stub
		System.out.println("Joueur Tire a: {" + position.getColonne() + "," + position.getRangee() + "} Occuper:" + this.flotte.getGrille()[position.getColonne()][position.getRangee()].getEstOccuper());
		this.flotte.getGrille()[position.getColonne()][position.getRangee()].setEstTouche(true);
	}

}
