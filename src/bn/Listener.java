package bn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

public class Listener implements ActionListener{

	private Frame jframe;
	
	public Listener(Frame jframe){
		this.jframe = jframe;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		
		if (arg0.getSource() instanceof JButton) {
			JButton monButton = (JButton)arg0.getSource();

			switch (monButton.getText()) {
                case "Placer Porte avion":
                    Main.placerNavire("Porte avion", 5);
                    break;
                case "Placer Croiseur":
                    Main.placerNavire("Croiseur", 4);
                    break;
                case "Placer Contre-T":
                    Main.placerNavire("Contre-T", 3);
                    break;
                case "Placer Sous-Marin":
                    Main.placerNavire("Sous-Marin", 3);
                    break;
                case "Placer Torpilleur":
                    Main.placerNavire("Torpilleur", 2);
                    break;
                case "Annuler":
                    Main.annuler();
                    break;
                case "Aide":
                    Main.aide();
                    break;
                case "Recommencer":
                    Main.recommencer();
                    break;
            }
		} else if (arg0.getSource() instanceof JTable) {

		}
	}
	
}
