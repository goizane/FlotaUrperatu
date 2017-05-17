package grafika;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import kudeatzaileak.Partida;
import model.ontziakKokatu.MyTable;


public class OntziakAukeratuUI extends JFrame{

	private JButton jokatu= new JButton("JOKATU");
	private JButton aldatu= new JButton("ALDATU");
	private JButton random= new JButton("RANDOM");
	private JPanel botoienPanela= new JPanel();
	private JPanel panela= new JPanel();
	MyTable table=new MyTable();


	public OntziakAukeratuUI(){	
		super("Ontziak kokatu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));


		aldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Partida.getInstantzia().taulaBerbiarazi();
				OntziakIkusiUI.getO().berbiarazi();
				new OntziakAukeratuUI();
				itxi();
			}
		});


		jokatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.betetaDago()){
					
					NagusiaUI.getI();
					itxi();
				}

			}
		});
		
		random.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Partida.getInstantzia().ontziakRandom();
				NagusiaUI.getI();
				itxi();
				
				
			}
		});
		
		botoienPanela.setLayout(new FlowLayout());
		botoienPanela.add(aldatu);
		botoienPanela.add(jokatu);
		botoienPanela.add(random);
		botoienPanela.setAlignmentX(CENTER_ALIGNMENT);

		panela.setLayout(new GridLayout(0, 2));
		panela.add(scrollPane);
		panela.add(OntziakIkusiUI.getO());
		
		getContentPane().add(panela);
		getContentPane().add(botoienPanela);
		//pack();
		this.setMinimumSize(new Dimension(1200, 500));
		setVisible(true);
	}

	
	



	public static void main(String[] args) {
		new OntziakAukeratuUI();
	}
	
	public void itxi(){
		this.dispose();
	}
	
	public JPanel getTaula(){
		return panela;
	}
}
