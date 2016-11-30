package bn;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

public class Frame extends JFrame {

	private int increment = 0;
	
	public Frame(String titre){
		super(titre);
		
		this.setBounds(200, 200, 500, 500);
		
		//Cération des composantes
		JButton btnPlacerPA = new JButton("Placer P-A");
		JButton btnPlacerCroisseur = new JButton("Placer Croisseur");
		JButton btnPlacerContreT = new JButton("Placer Contre-T");
		JButton btnPlacerSousMarin = new JButton("Placer Sous-marin");
		JButton btnPlacerTorpilleur = new JButton("Placer Torpilleur");
		
		JButton btnAnnuler = new JButton("Annuler");
		JButton btnAide = new JButton("Aide");
		JButton btnRecommencer = new JButton("Recommencer");
		
		JTextField tbLog = new JTextField();
		
		String[] entetes = {"","A","B","C","D","E","F", "G", "H", "I", "J"};
		
		JTable grilleAI = new JTable(null, entetes);
		JTable grilleJ = new JTable(null, entetes);
		
		JFrame buttonFrame = new JFrame();
		JFrame tirsFrame = new JFrame();
		JFrame grilleFrame = new JFrame();
		JFrame logFrame = new JFrame();
		GridLayout gridL = new GridLayout(0,1);
		
		//Disposition des composantes
		this.getContentPane().add(buttonFrame, BorderLayout.LINE_START);
		this.getContentPane().add(grilleFrame, gridL);
		this.getContentPane().add(tirsFrame, gridL);
		this.getContentPane().add(tbLog, BorderLayout.PAGE_END);
		
		
		buttonFrame.getContentPane().add(btnPlacerPA, BoxLayout.Y_AXIS);
		buttonFrame.getContentPane().add(btnPlacerCroisseur, BoxLayout.Y_AXIS);
		buttonFrame.getContentPane().add(btnPlacerContreT, BoxLayout.Y_AXIS);
		buttonFrame.getContentPane().add(btnPlacerSousMarin, BoxLayout.Y_AXIS);
		buttonFrame.getContentPane().add(btnPlacerTorpilleur, BoxLayout.Y_AXIS);
		buttonFrame.getContentPane().add(btnAnnuler, BoxLayout.Y_AXIS);
		buttonFrame.getContentPane().add(btnAide, BoxLayout.Y_AXIS);
		buttonFrame.getContentPane().add(btnRecommencer, BoxLayout.Y_AXIS);
		
		
		
		JButton jb = new JButton("Ok");
		jb.addActionListener(new Listener(this));
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Second");
			}
		});
		
		this.getContentPane().add(new JButton("NOK"));
		this.getContentPane().add(jb);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}
}
