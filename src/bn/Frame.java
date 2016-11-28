package bn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {

	private int increment = 0;
	
	public Frame(String titre){
		super(titre);
		
		this.setBounds(200, 200, 500, 500);
		
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
