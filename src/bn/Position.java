package bn;

public class Position 
{
	private int colonne;
	private int rangee;
	private boolean touche;
	private boolean estOccuper;
	
	public final int MAX_COLONNE_RANGEE = 9;//Limite maximum pour les rangee et les colonnes
	
	public Position(int _colonne, int _rangee)
	{
		setColonne(_colonne);
		setRangee(_rangee);
		setTouche(false);
	}
	
	public int getColonne(){
		return this.colonne;
	}
	public void setColonne(int _colonne){
		if(validation(_colonne)){
			this.colonne = _colonne;
		}else{
			System.out.println("La position(Colonne) n'est pas valide");
		}
	}
	public int getRangee(){
		return this.rangee;
	}
	
	public void setRangee(int _value){
		if(validation(_value)){
			this.rangee = _value;
		}else{
			System.out.println("La position(Rangee) n'est pas valide");
		}
	}
	
	public boolean getTouchee(){
		return this.touche;
	}
	public void setTouche(boolean _value){
		this.touche = _value;
	}
	public boolean getEstOccuper(){
		return this.estOccuper;
	}
	public void setEstOccuper(boolean _value){
		this.estOccuper = _value;
	}
	/**
	 * Valide si le parametre est une colonne ou rangee valide
	 * @param _value Valeur que l'on souhaite valider
	 * @return Vrai si la valeur est inferieur au MAX_COLONNE_RANGEE et superieur a 0
	 */
	boolean validation(int _value){
		if(_value <= MAX_COLONNE_RANGEE && _value >= 0){
			return true; 
		}
		return false;
	}
	
	@Override
	public String toString(){
		String strRetour = "";
		if(getEstOccuper()){
			strRetour = "+";
		} 
		if(getTouchee()){
			strRetour = "X";
		}
		
		return strRetour;
	}
	

}
