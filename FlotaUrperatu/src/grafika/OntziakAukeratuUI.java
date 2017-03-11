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
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import kudeatzaileak.Kudeatzaile;
import model.MyTable;


public class OntziakAukeratuUI extends JFrame{

	private JButton jokatu= new JButton("JOKATU");
	private JButton aldatu= new JButton("ALDATU");
	private JPanel botoienPanela= new JPanel();
	private static OntziakAukeratuUI aukeratu;
	MyTable table=new MyTable();

	
	public OntziakAukeratuUI(){	
		super("Ontzia kokatu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		
		
		aldatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				aukeratu.dispose();
				Kudeatzaile.getInstantzia().taulaBerbiarazi();
				aukeratu=new OntziakAukeratuUI();
				
			}
		});
		
		
		jokatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.betetaDago()){
					aukeratu.dispose();
					new NagusiaUI();
					
				}
				
			}
		});
		botoienPanela.setLayout(new FlowLayout());
		botoienPanela.add(aldatu);
		botoienPanela.add(jokatu);
		botoienPanela.setAlignmentX(CENTER_ALIGNMENT);
		getContentPane().add(scrollPane);
		getContentPane().add(botoienPanela);
		//pack();
		this.setMinimumSize(new Dimension(700, 500));
		setVisible(true);
	}

	public static void main(String[] args) {
		aukeratu=new OntziakAukeratuUI();
	}
}
