package bn;

public class Main {
	
	static Flotte flotteJoueur;
	static Flotte flotteEnnemie;
	public static void main(String[] args) {
		/*SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			Calculator calc = new Calculator();
			calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			calc.setVisible(true);
			}
			});*/
		JoueurArtificiel AI = new JoueurArtificiel();
		Navire navire = new Navire("Prout",3);
		
		AI.placeNavire(navire);
		
		

	}
}
