package grafika;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;

import kudeatzaileak.Kudeatzaile;

public class NagusiaUI extends JFrame{

	private JPanel nireTaula= new JPanel();
	private JPanel ordenagailua= new JPanel();
	private JPanel botoiak= new JPanel();
	private JPanel armak= new JPanel();


	public NagusiaUI(){
		super("Flota urperatu");
		getContentPane().setLayout(new GridLayout(0,3));

		nireTaula.setLayout(new GridLayout(11, 11));
		ordenagailua.setLayout(new GridLayout(11, 11));
		nireTaulaBete();
		ordenagailuTaulaBete();
		botoiakHasieratu();


		getContentPane().add(nireTaula);
		getContentPane().add(botoiak);
		getContentPane().add(ordenagailua);
		setMinimumSize(new Dimension(1100, 400));
		
		setVisible(true);
	}

	private void botoiakHasieratu() {
		botoiak.setLayout(null);

		JButton radarra= new JButton("Radar");
		JButton ezkutua= new JButton("Ezkutua");
		JButton biltegia= new JButton("Biltegia");
		
		//radar listener
		radarra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RadarUI();
				
			}
		});
		//ezkutua listener
		
		//biltegia listener
		biltegia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BiltegiUI();
				
			}
		});


		armakBete();




		botoiak.add(armak);
		armak.setBounds(120,10,100,100);
		botoiak.add(radarra);
		radarra.setBounds(120,100,100,60);
		botoiak.add(biltegia);
		biltegia.setBounds(120,250,100,60);
		botoiak.add(ezkutua);
		ezkutua.setBounds(120,175,100,60);


	}

	private void armakBete() {

		armak.setLayout(new GridLayout(2, 0));

		JLabel tituloa= new JLabel("Armak:", SwingConstants.CENTER);
		

		armak.add(tituloa);
	}

	private void ordenagailuTaulaBete() {
		int kont=1;
		int kont2=1;
		for(int i=0;i<121;i++){
			if(i==0){
				JLabel text= new JLabel();
				ordenagailua.add(text);
			}
			else if(i<=10){
				JLabel text= new JLabel(Integer.toString(kont), SwingConstants.CENTER);
				ordenagailua.add(text);
				kont++;
			}else if(i%11==0){
				JLabel text= new JLabel(Integer.toString(kont2), SwingConstants.CENTER);
				ordenagailua.add(text);
				kont2++;
			}
			else{
				JButton botoia= new JButton();
				botoia.setSize(new Dimension(5, 10));
				ordenagailua.add(botoia);
			}

		}

	}



	private void nireTaulaBete() {
		int kont=1;
		int kont2=1;
		for(int i=0;i<121;i++){
			if(i==0){
				JLabel text= new JLabel();
				nireTaula.add(text);
			}
			else if(i<=10){
				JLabel text= new JLabel(Integer.toString(kont), SwingConstants.CENTER);
				nireTaula.add(text);
				kont++;
			}else if(i%11==0){
				JLabel text= new JLabel(Integer.toString(kont2), SwingConstants.CENTER);
				nireTaula.add(text);
				kont2++;
			}
			else{
				int col= (i%11)-1;
				int row= (i/11)-1;
				if(Kudeatzaile.getInstantzia().ontzirikDago(row,col)){
					JButton botoia= new JButton();
					botoia.setSize(new Dimension(5, 10));
					nireTaula.add(botoia);
				}
				else{
					JButton botoia= new JButton();
					botoia.setSize(new Dimension(5, 10));
					botoia.setEnabled(false);
					nireTaula.add(botoia);
				}
			}

		}

	}

	public static void main(String[] args) {
		//Kudeatzaile.getInstantzia().ordenagailuaHasieratu();
		new NagusiaUI();
	}

}
