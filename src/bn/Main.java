package bn;

import javax.swing.*;

import java.awt.*;

public class Main {

	private static final int MAX_GRID_SIZE = 11;
    private static final int MIN_X = 0;
    private static final int MAX_X = 9;
    private static final int MIN_Y = 1;
    private static final int MAX_Y = 10;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
		
			@Override
			public void run() {
				demarre();
			}
			
		});
		
		JoueurArtificiel AI = new JoueurArtificiel(true);
		JoueurHumain JH = new JoueurHumain();
		Navire navire = new Navire("Navire 3",3);
		Navire navire2 = new Navire("Navire 5", 5);
		Navire navire3 = new Navire("Navire 4",4);
		Navire navire4 = new Navire("Navire 3-2", 3);
		Navire navire5 = new Navire("Navire 2", 2);
		
		JH.placeNavire(navire);
		JH.placeNavire(navire2);
		JH.placeNavire(navire3);
		JH.placeNavire(navire4);
		JH.placeNavire(navire5);
		
		

		
		for(int i = 0; i< 40; i++){
			AI.tire(JH);
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
        JLabel[] tirsAI = createLabels();
        tirsPanel.add(dernierTirsAI);
        for (int i = 0; i < tirsAI.length-1; i++) {
            tirsPanel.add(tirsAI[i]);
        }

        JLabel dernierTirsJ = new JLabel("5 Vos derniers tirs");
        JLabel[] tirsJ = createLabels();
        tirsPanel.add(dernierTirsJ);
        for (int i = 0; i < tirsJ.length-1; i++) {
            tirsPanel.add(tirsJ[i]);
        }

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

    /* Activer ou dÈsactiver un bouton

    * button est un des boutons prÈsents sur le cÙtÈ gauche du panneaux
    * status est un boolÈen qui dit si on active ou dÈsactive le bouton
     */
    public static void toggleButton(JButton button, boolean status) {
        button.setEnabled(status);
    }

    /* …crit dans une des cases de la table donnÈe en paramËtre
    *
    * table est la grille d'un des joueurs
    * x est la coordonnÈes x dans le tableau (doit Ítre entre 0 et 9)
    * y est la coordonnÈes dans le tableau (doit Ítre entre 1 et 10)
    * status est ce qui sera Ècrit dans la case
     */
    public static void setTextInTableCell(JTable table, int x, int y, String status) {
        if ((x >= MIN_X) && (x <= MAX_X)) {
            if ((y >= MIN_Y) && (y <= MAX_Y)) {
                table.setValueAt(status, x, y);
            }
        }
    }

    public static void actuDerniersCoups(AJoueur j, JLabel[] tirs){
        if (j instanceof JoueurHumain) { //Quand c'est le joueur humain
            for (int i = 0; i < tirs.length; i++) {
                actuLabelText(tirs[i], "");
            }
        } else if (j instanceof JoueurArtificiel) { //Quand c'est le joueur artificiel
            for (int i = 0; i < tirs.length; i++) {
                actuLabelText(tirs[i], "");
            }
        }
    }

    public static void actuLabelText(JLabel label, String action) {
        label.setText(action);
    }

    public static JLabel[] createLabels() {
        JLabel[] labels = new JLabel[4];
        for (int i = 0; i < labels.length-1; i++) {
            labels[i] = new JLabel("");
        }
        return labels;
    }
}
