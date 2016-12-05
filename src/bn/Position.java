package bn;

public class Position 
{
	private int colonne;//Coordonnee X 
	private int rangee;//Coordonnee Y
	private boolean estTouchee;
	private boolean estOccupee;
	
	public final int MAX_COLONNE_RANGEE = 10;//Limite maximum pour les rangee et les colonnes
	
	//Constructeur
	public Position(int _colonne, int _rangee)
	{
		setColonne(_colonne);
		setRangee(_rangee);
		setEstTouche(false);
	}
	//Constructeur
	public Position(Position _position){
		setColonne(_position.getColonne());
		setRangee(_position.getRangee());
		setEstTouche(_position.getEstTouchee());
	}
	
	public int getColonne(){
		return this.colonne;
	}
	public void setColonne(int _colonne){
			this.colonne = _colonne;
	}
	public int getRangee(){
		return this.rangee;
	}
	
	public void setRangee(int _value){
		this.rangee = _value;
	}
	
	public boolean getEstTouchee(){
		return this.estTouchee;
	}
	public void setEstTouche(boolean _value){
		this.estTouchee = _value;
	}
	public boolean getEstOccuper(){
		return this.estOccupee;
	}
	public void setEstOccuper(boolean _value){
		this.estOccupee = _value;
	}

	/**
	 * Retourne "+" si la position est occupee
	 * Retourne "0" si la position est touchee
	 * Retourne "X" si la position est occupee et touchee
	 */
	@Override
	public String toString(){
		String strRetour = "";
		if(getEstOccuper()){
			strRetour = "+";
		} 
		if(getEstTouchee()){
			strRetour = "0";
		}
		if(getEstOccuper() && getEstTouchee()){
			strRetour = "X";
		}
		
		return strRetour;
	}
	

}
