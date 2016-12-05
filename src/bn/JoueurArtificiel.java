package bn;



public class JoueurArtificiel extends AJoueur {
	
	boolean searchState;//Determine si l'AI est en recherche d'une cible
	boolean isNormal;//Determine si L'AI est Normal(true) ou Facile(false)
	//private PileSimple nextTire;// Pile contenant les prochains tirent de l'AI  
	/**
	 * Constructeur
	 * @param _estNormal definis si le AI est de difficulte normal
	 */
	JoueurArtificiel(boolean _estNormal){
		super(); 
		searchState = true;
		//attackState = false;
		isNormal = _estNormal;
	}

	@Override
	/**
	 * Methode qui effectue un tire sur la cible selon le niveau de difficulte de l'AI
	 */
	public void tire(IJoueur _cible) {
	
		System.out.println("AI Tire: Recherche:" + searchState );
		
		/**Strategie 
		 * AI est Normal ou n'est pas en recherche
		 * Tire sur la cible avec les positions contenue dans nextTire()
		 * Si le tir frappe un navire on set les prochains tirs
		 * si la pile est vide on reactive le mode recherche
		 */
		if(isNormal && !searchState){
			if(!getNextTire().estVide()){
				Position posTirePile = getNextTire().depile();
				_cible.recoitTire(posTirePile);
				
				if(posTirePile.getEstOccuper()){
					//AI a touche un navire alors on set les prochains tires
					setNextTire(posTirePile,_cible);
				}
				
			}else{
				//Si il ni a plus de prochain tirs. On active le mode recherche
				searchState = true;
			}
			
		}else{
			/* Strategie 
			 * AI facile OU en mode recherche 
			 * Alors tir aleatoire seulement 
			 * Si le tir touche un navire On genere une pile contenant les prochains tirs
			 * et on desactive le mode recherche 
			 */
			
			//Tire de facons aleatoire sur la grille adverse
			Position posTirer = _cible.getRandPositionGrille();	
			_cible.recoitTire(posTirer);
			
			//S'il a toucher un navire
			if(_cible.flotte.getGrille()[posTirer.getColonne()][posTirer.getRangee()].getEstOccuper()){
				//Desactive le monde recherche
				searchState = false; 
				setNextTire(posTirer, _cible);
			}
		}		
		//Ajout stat
	}
	/**
	 * Change le niveau de difficulte de l'AI
	 * @param _value True si Normal, False si facile
	 */
	public void setIsNormal(boolean _value){
		this.isNormal = _value;
				
	}

	@Override
	/**
	 * Set la _position transmise en parametre a touchee(true)
	 */
	public void recoitTire(Position _position) {
		
		_position.setEstTouche(true);	
	}
}
