package grafika;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.biltegi.MyTableModel;

public class BiltegiUI extends JFrame {
	
	private JButton botoia= new JButton("Erosi");
	public BiltegiUI() {
		super("Biltegia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTable table = new JTable(new MyTableModel());
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(800, 100));
		botoiaPrestatu();
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(botoia,BorderLayout.SOUTH);
		setMinimumSize(new Dimension(800, 100));
		pack();
		setVisible(true);
	}
	private void botoiaPrestatu() {
		
		botoia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
