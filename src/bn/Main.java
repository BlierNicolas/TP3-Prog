package bn;

import javax.swing.*;

import java.awt.*;

public class Main {

	private static final int MAX_GRID_SIZE = 11;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
		
			@Override
			public void run() {
				demarre();
			}
			
		});

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
		buttonPanel.add(addButton("Placer Porte avion"));
		buttonPanel.add(addButton("Placer Croiseur"));
		buttonPanel.add(addButton("Placer Contre-T"));
		buttonPanel.add(addButton("Placer Sous-Marin"));
		buttonPanel.add(addButton("Placer Torpilleur"));
		buttonPanel.add(addButton("Annuler"));
		buttonPanel.add(addButton("Aide"));
		buttonPanel.add(addButton("Recommencer"));
		
		JPanel grillePanel = new JPanel();
		grillePanel.setLayout(new BoxLayout(grillePanel, BoxLayout.Y_AXIS));
		framePrincipal.add(grillePanel, BorderLayout.CENTER);
		Object cases[][] = {{"1", "", "", "", "", "", "", "", "", "", ""},
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
		for (int i = 0;i < MAX_GRID_SIZE-1; i++) {
			for (int j = 1; j < MAX_GRID_SIZE; j++){
				//grilleAI.isCellEditable(i, j);
				//grilleAI.setEnabled(false);
				//grilleJ.setEnabled(false);
			}
		}
		JScrollPane scrollPaneAI = new JScrollPane(grilleAI);
		JScrollPane scrollPaneJ = new JScrollPane(grilleJ);
		grillePanel.add(new JLabel("Grille adverse"));
		grillePanel.add(scrollPaneAI);
		grillePanel.add(new JLabel("Votre grille"));
		grillePanel.add(scrollPaneJ);
		
		JPanel tirsPanel = new JPanel();
		framePrincipal.add(tirsPanel, BorderLayout.LINE_END);
		tirsPanel.setLayout(new BoxLayout(tirsPanel, BoxLayout.Y_AXIS));
		JLabel dernierTirsAI = new JLabel("5 Derniers tirs AI");
		JLabel tirsAI1 = new JLabel("1");
		JLabel tirsAI2 = new JLabel("2");
		JLabel tirsAI3 = new JLabel("3");
		JLabel tirsAI4 = new JLabel("4");
		JLabel tirsAI5 = new JLabel("5");
		tirsPanel.add(dernierTirsAI);
		tirsPanel.add(tirsAI1);
		tirsPanel.add(tirsAI2);
		tirsPanel.add(tirsAI3);
		tirsPanel.add(tirsAI4);
		tirsPanel.add(tirsAI5);

		JLabel dernierTirsJ = new JLabel("5 Vos derniers tirs");
		JLabel tirsJ1 = new JLabel("1");
		JLabel tirsJ2 = new JLabel("2");
		JLabel tirsJ3 = new JLabel("3");
		JLabel tirsJ4 = new JLabel("4");
		JLabel tirsJ5 = new JLabel("5");
        tirsPanel.add(dernierTirsJ);
        tirsPanel.add(tirsJ1);
        tirsPanel.add(tirsJ2);
        tirsPanel.add(tirsJ3);
        tirsPanel.add(tirsJ4);
        tirsPanel.add(tirsJ5);

		JPanel logPanel = new JPanel();
		JTextField tbLog = new JTextField();
		framePrincipal.add(tbLog, BorderLayout.PAGE_END);
		
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setVisible(true);
	}
	
	private static void addComponentToPane(Container pane) {
		
	}
	private static JButton addButton(String text) {
		JButton button = new JButton(text);
		return button;
	}

	public static void placerNavire(String titre, int longueur) {

	}
	public static void annuler() {

	}
	public static void aide() {

	}
	public static void recommencer() {

	}
}
