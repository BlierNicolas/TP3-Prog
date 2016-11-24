package bn;

import java.util.Random;

public abstract class AJoueur implements IJoueur {
	Flotte flotte;
	final int MAX_RANGEE_COLONNE = 9;
	AJoueur()
	{
		flotte = new Flotte();
	}
	//placerRandom
	public void placeNavire(Navire navire){
		Position[] positionsValide = getRandPositions(navire.getLongueur());

		navire.setPosition(positionsValide);//Enregistre les positions du navire
		flotte.setPositionsOccuper(positionsValide);//Enregistre les positions de navire dans la grille
		
		System.out.println("Navire Place");
	}




	private Position[] getRandPositions(int _longueur){
		while(true){

			//Genere Position(X,Y) Aleatoire
			int randX  = new Random().nextInt(MAX_RANGEE_COLONNE);
			int randY = new Random().nextInt(MAX_RANGEE_COLONNE);
			//Genere 4 Orientations possible(Haut,Bas,Gauche,Droite)
			int randOrientation = new Random().nextInt(3);//4 Orientations possible(Haut,Bas,Gauche,Droite)
			
			//Tableau contenant les positions possible du navire
			Position[] positionRetour = new Position[_longueur];


			if(!flotte.getGrille()[randX][randY].getEstOccuper())
			{
				//Regarde si les cases adjacente sont libres dependant de l'orientation 
				switch(randOrientation){
				
				case 0: //Orientation haut
					//Si la position max est contenu dans la grille
					if(randY - _longueur <= MAX_RANGEE_COLONNE && (randY - _longueur) >= 0 ){
						//Parcours tout les cases adjacentes et ajoute la position au tableau si elle est libre
						for(int i = 0; i<_longueur; i++){
							if(!flotte.getGrille()[randX][randY - i].getEstOccuper()){
								
								positionRetour[i] = flotte.getGrille()[randX][randY - i];
							}
						}
					}
					//Si toute les cases tester peuvents acceuillir le navire
					if(positionRetour.length == _longueur){
						//Met tout les cases du tableau a occupee 
						return setEstOccuper(positionRetour);
					}
					break;
				case 1: //Orientation gauche
					break;
				case 2: //Orientation bas
					break;
				case 3: //Orientation droite 

				}

			}
		}

	}

	private Position[] setEstOccuper(Position[] _position){
		for(int i = 0; i<_position.length; i++){
			_position[i].setEstOccuper(true);
		}
		
		return _position;
	}
	//normal
	//Facile

}
