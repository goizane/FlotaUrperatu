package grafika;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kudeatzaileak.Partida;

public class BukatuIrabaziUI extends JFrame{
	

	public BukatuIrabaziUI() {
		super("Irabazi duzu!");
		getContentPane().setLayout(new GridLayout(2, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton irten= new JButton("Irten");
		JLabel mess= new JLabel("Zorionak! Irabazi duzu!!");
		mess.setHorizontalAlignment(JLabel.CENTER);
		mess.setFont(new Font("Arial", 0, 20));
		
		irten.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				itzi();
				
			}
		});

		
		
		JPanel mezua= new JPanel();
		JPanel botoiak= new JPanel();
		mezua.setLayout(new BorderLayout());
		mezua.add(mess);
		botoiak.setLayout(new GridLayout(2, 0));
		botoiak.add(irten);
		
		getContentPane().add(mezua);
		getContentPane().add(botoiak);

		
		this.setVisible(true);
		setMinimumSize(new Dimension(400, 200));
	}
	
	
	public void itzi(){
		this.dispose();
	}
}
