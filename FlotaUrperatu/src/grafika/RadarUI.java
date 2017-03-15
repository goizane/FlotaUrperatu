package grafika;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kudeatzaileak.KudeatzaileArmak;



public class RadarUI extends JFrame {
	
	private JButton erabili= new JButton("Erabili");
	private JButton posizioaAldatu= new JButton("Posizio aldatu");
	private JPanel botoienPanela= new JPanel();

	public RadarUI(){
		this.setTitle("Radar ajusteak");
		botoiakPrestatu();
		
		JLabel testua= new JLabel("Radar kopurua: " + KudeatzaileArmak.getInstantzia().radarKop(), SwingConstants.CENTER);
		
		getContentPane().add(testua, BorderLayout.CENTER);
		
		getContentPane().add(botoienPanela, BorderLayout.SOUTH);
		setMinimumSize(new Dimension(400, 200));
		setVisible(true);
	}

	private void botoiakPrestatu() {

		erabili.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		posizioaAldatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		botoienPanela.add(erabili, BorderLayout.WEST);
		botoienPanela.add(posizioaAldatu, BorderLayout.EAST);
		
	}
}