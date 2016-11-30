package bn;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
		
			@Override
			public void run() {
				demarre();
			}
			
		});
		
		
			/*SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			Calculator calc = new Calculator();
			calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			calc.setVisible(true);
			}
			});*/
		JoueurArtificiel AI = new JoueurArtificiel();
		Navire navire = new Navire("Prout",3);
		//Navire navire2 = new Navire("BIG D", 5);
		AI.placeNavire(navire);
		//AI.placeNavire(navire2);
		System.out.println(navire.toString());
		//System.out.println(navire2.toString());
		
		System.out.println(navire.getPosition()[0].toString());
		
		for(int i = 0; i < navire.getPosition().length; i++){
			AI.recoitTire(navire.getPosition()[i]);
		}
		
		System.out.println(navire.toString());
		
		
		
	}
	
	public static void demarre() {
		//new Frame("Bataille navalle");
	}
}
