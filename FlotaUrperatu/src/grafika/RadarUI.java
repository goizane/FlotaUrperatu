package grafika;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kudeatzaileak.KudeatzaileArmak;



public class RadarUI extends JFrame {
	
	private JButton erabili= new JButton("Erabili");
	private JButton posizioaAldatu= new JButton("Posizio aldatu");
	private JButton gorde= new JButton("Gorde");
	private JButton utzi= new JButton("Deuseztatu");
	private JPanel botoienPanela= new JPanel();
	private JPanel zenbakienPanela= new JPanel();
	private JLabel posizioa;
	private JComboBox row;
	private JComboBox col;
	

	public RadarUI(){
		this.setTitle("Radar ajusteak");
		botoiakPrestatu();
		getContentPane().setLayout(new GridLayout(4, 0));
		
		JLabel testua= new JLabel("Radar kopurua: " + KudeatzaileArmak.getInstantzia().radarKop(0), SwingConstants.CENTER);
		testua.setFont(new Font("Arial", 0, 20));
		String pos= Integer.toString(KudeatzaileArmak.getInstantzia().radarPos(0)[0]+1);
		String pos1= Integer.toString(KudeatzaileArmak.getInstantzia().radarPos(0)[1]+1);
		posizioa= new JLabel("Posizioa: " + pos +"-" + pos1, SwingConstants.CENTER);
		posizioa.setFont(new Font("Arial", 0, 20));
		getContentPane().add(testua);
		getContentPane().add(posizioa);
		
		row= new JComboBox();	
		for(int i=1;i<=10;i++){
			row.addItem(i);
		}
		col= new JComboBox();	
		for(int i=1;i<=10;i++){
			col.addItem(i);
		}
		zenbakienPanela.setVisible(false);
		zenbakienPanela.setLayout(new GridLayout(0, 2));
		zenbakienPanela.add(row);
		zenbakienPanela.add(col);
		
		getContentPane().add(zenbakienPanela);
		getContentPane().add(botoienPanela);
		setMinimumSize(new Dimension(400, 300));
		setVisible(true);
	}

	private void botoiakPrestatu() {

		erabili.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] ontziaDago= erabili();
				System.out.println(ontziaDago[0]);
				if(ontziaDago[0].equals("true")){
					JOptionPane.showMessageDialog(null, "Hurbil dagoen ontziaren posizioa:" +
				ontziaDago[1]+ "-"+ ontziaDago[2] + " da.");
				}
				else{
					JOptionPane.showMessageDialog(null, "Radar inguruan ez dago ontzirik");
				}
				
			}
		});
		
		posizioaAldatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				posizioa.setVisible(false);
				zenbakienPanela.setVisible(true);
				posizioaAldatu.setVisible(false);
				erabili.setVisible(false);
				gorde.setVisible(true);
				utzi.setVisible(true);
			}
		});
		
		gorde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KudeatzaileArmak.getInstantzia().radarPosAldatu((int)row.getSelectedItem(),(int)col.getSelectedItem());
				String pos= Integer.toString(KudeatzaileArmak.getInstantzia().radarPos(0)[0]+1);
				String pos1= Integer.toString(KudeatzaileArmak.getInstantzia().radarPos(0)[1]+1);
				posizioa.setText("Posizioa: " + pos +"-" + pos1);
				zenbakienPanela.setVisible(false);
				posizioaAldatu.setVisible(true);
				erabili.setVisible(true);
				gorde.setVisible(false);
				utzi.setVisible(false);
				posizioa.setVisible(true);
				
			}
		});
		
		utzi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				posizioa.setVisible(true);
				zenbakienPanela.setVisible(false);
				posizioaAldatu.setVisible(true);
				erabili.setVisible(true);
				gorde.setVisible(false);
				utzi.setVisible(false);
				
			}
		});
		
		gorde.setVisible(false);
		utzi.setVisible(false);
		botoienPanela.setLayout(new GridLayout(0,2));
		botoienPanela.add(utzi, BorderLayout.EAST);
		botoienPanela.add(gorde, BorderLayout.WEST);
		botoienPanela.add(erabili, BorderLayout.EAST);
		botoienPanela.add(posizioaAldatu, BorderLayout.WEST);
		
	}
	
	public String[] erabili(){
		this.dispose();
		KudeatzaileArmak.getInstantzia().radarErabili();
		return KudeatzaileArmak.getInstantzia().ontziarenPos();
	}
}
