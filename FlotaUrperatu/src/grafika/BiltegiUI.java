package grafika;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import kudeatzaileak.BiltegiKudeatzaile;
import kudeatzaileak.KudeatzaileArmak;
import model.biltegi.MyTable;
import model.biltegi.MyTableModel;

public class BiltegiUI extends JFrame {
	
	private MyTable table= new MyTable();
	private JButton botoia= new JButton("Erosi");
	public BiltegiUI() {
		this.setTitle("Biltegia");
		

		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(800, 100));
		botoiaPrestatu();
		
		JLabel dirua = new JLabel("Dirua: "+ Integer.toString(KudeatzaileArmak.getInstantzia().getDirua(0))+ "$");
		Font font = dirua.getFont();
		Font boldFont = new Font(font.getFontName(), Font.BOLD, 20);
		dirua.setFont(boldFont);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(dirua,BorderLayout.NORTH);
		getContentPane().add(botoia,BorderLayout.SOUTH);
		setMinimumSize(new Dimension(800,250));
		pack();
		setVisible(true);
	}
	private void botoiaPrestatu() {
		
		botoia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTableModel model=(MyTableModel) table.getModel();
				int bonbaKop= Integer.parseInt(model.getValueAt(0, 4).toString());
				int misilKop= Integer.parseInt(model.getValueAt(1, 4).toString());
				int misilZKop= Integer.parseInt(model.getValueAt(2, 4).toString());
				//emaitzak kodetu
				//0: ondo egin da
				//1: ez daukazu diru nahikorik
				//2: ez dago kantitate nahikorik
				int erosi= BiltegiKudeatzaile.getInstantzia().erosi(bonbaKop,misilKop,misilZKop);
				if(erosi==1){
					JOptionPane.showMessageDialog(null, "Ez daukazu diru nahikorik erosketa horiek egiteko!");
					
				}
				else if(erosi==0){
					JOptionPane.showMessageDialog(null, "Erosketak ongi egin dira! \r\n"
							+ "Saldo berria: " + Integer.toString(KudeatzaileArmak.getInstantzia().getDirua(0))+ "$");
					boolean mErosi;
					if(misilZKop>0){
						mErosi=true;
					}else{
						mErosi=false;
					}
					NagusiaUI.getI().eguneratu(mErosi);
					bukatu();
				}
				else if(erosi==2){
					JOptionPane.showMessageDialog(null, "Ez dago aukeratu dituzun arma kantitate nahikorik!");
					
				}
				
				
			}
		});
		
	}
	
	public void bukatu(){
		this.dispose();
	}
}
