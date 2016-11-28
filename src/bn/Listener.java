package bn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Listener implements ActionListener{

	private Frame jframe;
	
	public Listener(Frame jframe){
		this.jframe = jframe;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		
		if (arg0.getSource() instanceof JButton) {
			
			this.jframe.setIncrement(this.jframe.getIncrement()+1);
			JButton monButton = (JButton)arg0.getSource();
			monButton.setText("20");
		}
	}
	
}
