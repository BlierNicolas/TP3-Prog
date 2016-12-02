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
		
		//C�ration des composantes
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
		
		JPanel buttonPanel = new JPanel();
		JPanel tirsPanel = new JPanel();
		JPanel grillePanel = new JPanel();
		JPanel logPanel = new JPanel();
		GridLayout gridL = new GridLayout(0,1);
		
		
		buttonPanel.setLayout(new GridLayout(5,1));
		
		
		//Disposition des composantes
		this.getContentPane().add(buttonPanel, BorderLayout.LINE_START);
		this.getContentPane().add(grillePanel, BorderLayout.NORTH);
		this.getContentPane().add(tirsPanel, BorderLayout.SOUTH);
		this.getContentPane().add(tbLog, BorderLayout.PAGE_END);
		
		
		
		buttonPanel.add(btnPlacerPA);
		//buttonPanel.add(btnPlacerPA, BoxLayout.Y_AXIS);
		//buttonPanel.add(btnPlacerCroisseur, BoxLayout.Y_AXIS);
		buttonPanel.add(btnPlacerCroisseur);
		/*
		buttonPanel.add(btnPlacerContreT, BoxLayout.Y_AXIS);
		buttonPanel.add(btnPlacerSousMarin, BoxLayout.Y_AXIS);
		buttonPanel.add(btnPlacerTorpilleur, BoxLayout.Y_AXIS);
		buttonPanel.add(btnAnnuler, BoxLayout.Y_AXIS);
		buttonPanel.add(btnAide, BoxLayout.Y_AXIS);
		buttonPanel.add(btnRecommencer, BoxLayout.Y_AXIS);*/
		
		
		
		//JButton jb = new JButton("Ok");
		//jb.addActionListener(new Listener(this));
		
		/*jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Second");
			}
		});*/
		
		//this.getContentPane().add(new JButton("NOK"));
		//this.getContentPane().add(jb);
		
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
