package bn;

public interface IJoueur {
	Flotte flotte = new Flotte();
	void tire(IJoueur cible);
	
	void recoitTire(Position position);
	
	Position getRandPositionGrille();

}
