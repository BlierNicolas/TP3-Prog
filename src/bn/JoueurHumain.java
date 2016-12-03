package bn;

public class JoueurHumain extends AJoueur {

	@Override
	public void tire(IJoueur cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recoitTire(Position position) {
		// TODO Auto-generated method stub
		this.flotte.getGrille()[position.getColonne()][position.getRangee()].setTouche(true);
	}

}
