package bn;

public class PileSimple 
{
	 private Maillon tete;
	 private int compteur;

	    /**
	     * Constructeur
	     *
	     * @param maillon
	     */
	    public PileSimple(Position _position) {
	        this.tete = new Maillon(_position);
	        compteur = 0;
	    }

	    /**
	     *
	     * @return
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
	     *
	     * @return
	     */
	    public Position depile() {
	        Maillon maillonDeRetour = this.tete;
	        this.tete = this.tete.getNext();
	        compteur--;
	        return maillonDeRetour.getValeur();
	    }
	    
	    public Position getNext(){
	    	return this.tete.getValeur();
	    }
	    
	    public int getCompteur(){
	    	return this.compteur;
	    }

}
