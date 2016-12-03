package bn;

import java.util.LinkedList;
import java.util.Random;

public abstract class AJoueur implements IJoueur {
	final int MAX_RANGEE_COLONNE = 9;

	/**
	 * Place un navire sur la grille
	 * @param navire Navire que l'on desire placer
	 */
	public void placeNavire(Navire navire){
		LinkedList<Position> positionsValide = getRandPositionsNavire(navire.getLongueur());

		navire.setPosition(positionsValide);//Enregistre les positions du navire
		//Besoin de testing... Est ce neccessaire ou le referencement fait deja ca? 
		flotte.setPositionsOccuper(positionsValide);//Enregistre les positions de navire dans la grille
		
		System.out.println("Navire Place");
	}

	/**
	  * 
	  * @return
	  */
	 public Position getRandPositionGrille(){
		do{
			int randX  = new Random().nextInt(MAX_RANGEE_COLONNE);
			int randY = new Random().nextInt(MAX_RANGEE_COLONNE);
			
			//Trouve une position aleatoire non touchee
				if(!this.flotte.getGrille()[randX][randY].getTouchee()){
					return new Position(randX,randY);
				}
		}while(true);
		
	}

	 /**
	  * Cherche parmis les positions de la grille un emplacement dans laquelle on peut placer un navire
	  * @param _longueur La longueur de navire que l'on souhaite placer
	  * @return un tableau de position pouvant acceuillir un navire de _longueur
	  */
	private LinkedList<Position> getRandPositionsNavire(int _longueur){
		
		/***
		 * *******************STRATEGIE******************
		 * Genere une position(x,y) ainsi qu'une orientation du navire aleatoire. 
		 * Si la position est deja occuper par un autre navire, on recommence l'execution
		 * Selon l'orientation genere, on regarde si les positions adjacente adjacente sont libre. 
		 * Si elle est libre, on l'ajoute a une liste contenant les positions possibles
		 * Si la liste contient autant de position que la longueur du navire, on set toute les positions a estOccuper(true)
		 * Puis on retourne ce tableau 
		 * **********************************************
		 */
		while(true){

			//Genere Position(X,Y) Aleatoire
			int randX  = new Random().nextInt(MAX_RANGEE_COLONNE);
			int randY = new Random().nextInt(MAX_RANGEE_COLONNE);
			//Genere 2 Orientations possible(Haut,Droite)
			int randOrientation = new Random().nextInt(2);
			
			//Tableau contenant les positions possible du navire
			LinkedList<Position> positionRetour = new LinkedList<Position>();//Mauvais!! On doit mettre une liste dynamique ici 

			//Si la position n'est pas deja occuper
			if(!flotte.getGrille()[randX][randY].getEstOccuper())
			{
				//Regarde si les cases adjacente sont libres dependant de l'orientation 
				switch(randOrientation){
				
				case 0: //Orientation bas
					//Si la position max est contenu dans la grille
					if(randY - _longueur <= MAX_RANGEE_COLONNE && (randY - _longueur) >= 0 ){
						//Parcours tout les cases adjacentes et ajoute la position au tableau si elle est libre
						for(int i = 0; i<_longueur; i++){
							if(!flotte.getGrille()[randX][randY - i].getEstOccuper()){
								
								positionRetour.add(flotte.getGrille()[randX][randY - i]);
							}
						}
					}
					//Si toute les cases tester peuvents acceuillir le navire
					if(positionRetour.size() == _longueur){//Mauvais as fuck
						//Met tout les cases du tableau a occupee 
						return setEstOccuper(positionRetour);
					}
					break;
				case 1: //Orientation Droite
					if((randX + _longueur) < MAX_RANGEE_COLONNE){
						//Parcours tout les cases adjacentes et ajoute la position au tableau si elle est libre
						for(int i = 0; i<_longueur; i++){
							if(!flotte.getGrille()[randX + i][randY].getEstOccuper()){
								
								positionRetour.add(flotte.getGrille()[randX + i][randY]);
							}
						}
					}
					//Si toute les cases tester peuvents acceuillir le navire
					if(positionRetour.size() == _longueur){//Mauvais as fuck
						//Met tout les cases du tableau a occupee 
						return setEstOccuper(positionRetour);
					}
					
					break;
				}

			}
		}
	}

	/**
	 * Recoit en parametre un tableau de position est setEstOccuper a true pour toute les positions du tableau
	 * @param _position Tableau de position d'un navire
	 * @return Le tableau avec les positions modifiees
	 */
	private LinkedList<Position> setEstOccuper(LinkedList<Position> _position){
		for(int i = 0; i<_position.size(); i++){
			_position.get(i).setEstOccuper(true);
		}
		
		return _position;
	}

}
