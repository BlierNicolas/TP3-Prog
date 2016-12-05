package bn;

public class PileSimple 
{
	 private Maillon tete;
	 private int compteur;

	    /**
	     * Constructeur
	     *
	     * @param La tete de l'instance de la pile
	     */
	    public PileSimple(Position _position) {
	        this.tete = new Maillon(_position);
	        compteur = 1;
	    }
	    public PileSimple(PileSimple _pile){
	    	this.setTete(_pile.tete);
	    	this.setCompteur(_pile.getCompteur());
	    }

	    /**
	     *
	     * @return Si la pile est vide
	     */
	    public boolean estVide() {
	        return this.tete == null;
	    }

	    /**
	     *
	     * @param value
	     */
	    public void empile(Position value) {
	    	Maillon maillon = new Maillon(value);
	    	maillon.setNext(tete);
	    	tete = maillon;
	    	compteur++;
	    	
	    }

	    /**
	     *Depile la tete de la pile
	     * @return La tete de la pile
	     */
	    public Position depile() {
	    	if(!estVide()){	
	    		Maillon maillonDeRetour = this.tete;
	    		this.tete = this.tete.getNext();
	    		compteur--;
	    		return maillonDeRetour.getValeur();
	    	}
	    	return null;
	    }
	    
	    public Position getNext(){
	    	return this.tete.getValeur();
	    }
	    
	    public int getCompteur(){
	    	return this.compteur;
	    }
	    public void setCompteur(int _value){
	    	this.compteur = _value;
	    }
	    public Maillon getTete(){
	    	return this.tete;
	    }
	    public void setTete(Maillon _tete){
	    	this.tete = _tete;
	    }
	    /**
	     * Vide la pile completement
	     */
	    public void clear(){
	    	for(int i = 0; i< this.getCompteur(); i++){
	    		this.depile();
	    	}
	    	this.setCompteur(0);
	    	this.setTete(null);//Plante si on le set Pas manuellement??? 
	    }

}
