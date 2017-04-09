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

import kudeatzaileak.Partida;
import model.ontziakKokatu.MyTable;


public class OntziakAukeratuUI extends JFrame{

	private JButton jokatu= new JButton("JOKATU");
	private JButton aldatu= new JButton("ALDATU");
	private JButton random= new JButton("RANDOM");
	private JPanel botoienPanela= new JPanel();
	private JPanel panela= new JPanel();
	private JPanel taula= new OntziakIkusiUI();
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
				new OntziakAukeratuUI();
				itxi();
			}
		});


		jokatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.betetaDago()){
					
					new NagusiaUI();
					itxi();
				}

			}
		});
		
		random.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Partida.getInstantzia().ontziakRandom();
				new NagusiaUI();
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
		panela.add(taula);
		
		getContentPane().add(panela);
		getContentPane().add(botoienPanela);
		//pack();
		this.setMinimumSize(new Dimension(1200, 500));
		setVisible(true);
	}

	
	
	public void ontziaJarri(int i,int j,int luzeera,char pos){
		if(pos=='h'){
			for(int kont=0;kont<luzeera;kont++){
				int n= ((i*10)+1)+(j+1);
				JButton botoia=(JButton) taula.getComponent(n);
				botoia.setEnabled(true);
			}
		}
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
