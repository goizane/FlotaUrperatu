package grafika;

import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.JFrame;

import javax.swing.JScrollPane;


import kudeatzaileak.Kudeatzaile;
import model.MyTable;


public class OntziakAukeratuUI extends JFrame{



	
	public OntziakAukeratuUI(){	
		super("Ontzia kokatu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyTable table=new MyTable();
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().setLayout(new GridLayout(0,1));
		this.setMinimumSize(new Dimension(700, 500));
		
		
		getContentPane().add(scrollPane);
		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		new OntziakAukeratuUI();
	}
}
