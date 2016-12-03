package bn;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
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
		Navire navire = new Navire("Navire 3",3);
		Navire navire2 = new Navire("Navire 5", 5);
		AI.placeNavire(navire);
		AI.placeNavire(navire2);
		System.out.println(navire.toString());
		System.out.println(navire2.toString());
		
		System.out.println(navire.getPosition().get(0).toString());
		
		for(int i = 0; i < navire.getPosition().size(); i++){
			AI.recoitTire(navire.getPosition().get(i));
		}
		
		System.out.println(navire.toString());
		
		
		
	}
	
	public static void demarre() {
		JFrame framePrincipal = new JFrame("Bataille navalle");
		framePrincipal.setBounds(200, 200, 800, 600);
		framePrincipal.setLayout(new BorderLayout());
				
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		framePrincipal.add(buttonPanel, BorderLayout.LINE_START);
		buttonPanel.add(addButton("Placer Porte avion", buttonPanel));
		buttonPanel.add(addButton("Placer Croisseur", buttonPanel));
		buttonPanel.add(addButton("Placer Contre-T", buttonPanel));
		buttonPanel.add(addButton("Placer Sous-Marin", buttonPanel));
		buttonPanel.add(addButton("Placer Torpilleur", buttonPanel));
		buttonPanel.add(addButton("Annuler", buttonPanel));
		buttonPanel.add(addButton("Aide", buttonPanel));
		buttonPanel.add(addButton("Recommencer", buttonPanel));
		
		JPanel grillePanel = new JPanel();
		grillePanel.setLayout(new GridLayout(0,1));
		framePrincipal.add(grillePanel, BorderLayout.CENTER);
		String cases[][] = {{"1", "", "", "", "", "", "", "", "", "", ""},
							{"2", "", "", "", "", "", "", "", "", "", ""},
							{"3", "", "", "", "", "", "", "", "", "", ""},
							{"4", "", "", "", "", "", "", "", "", "", ""},
							{"5", "", "", "", "", "", "", "", "", "", ""},
							{"6", "", "", "", "", "", "", "", "", "", ""},
							{"7", "", "", "", "", "", "", "", "", "", ""},
							{"8", "", "", "", "", "", "", "", "", "", ""},
							{"9", "", "", "", "", "", "", "", "", "", ""},
							{"10", "", "", "", "", "", "", "", "", "", ""}};
		String entetes[] = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		
		JTable grilleAI = new JTable(cases, entetes);
		JTable grilleJ = new JTable(cases, entetes);
		grillePanel.add(grilleAI);
		grillePanel.add(grilleJ);
		
		JPanel tirsPanel = new JPanel();
		framePrincipal.add(tirsPanel, BorderLayout.LINE_END);
		
		
		JPanel logPanel = new JPanel();
		JTextField tbLog = new JTextField();
		framePrincipal.add(tbLog, BorderLayout.PAGE_END);
		
		
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setVisible(true);
	}
	
	private static void addComponentToPane(Container pane) {
		
	}
	
	private static JButton addButton(String text, Container container) {
		JButton button = new JButton(text);
		button.setAlignmentX(Component.LEFT_ALIGNMENT);
		return button;
	}
}
