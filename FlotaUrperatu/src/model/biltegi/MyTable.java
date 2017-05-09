package model.biltegi;
import javax.swing.DefaultCellEditor;


import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kudeatzaileak.KudeatzaileArmak;


public class MyTable extends JTable {



	private MyTableModel model = new MyTableModel();
	/**
	 * Constructor.
	 */
	public MyTable()  {

		this.setRowHeight(30);

		

		JComboBox zenbakiak= new JComboBox();	
		for(int i=0;i<=10;i++){
			zenbakiak.addItem(i);
		}
		
		
		// Establecemos el modelo
		this.setModel(model);

		
	
		// Editores para cada tipo de objeto, estos nos permitirán darles el comportamiento adecuado
		
		
		
		this.getColumn("Zenbat Erosi?").setCellEditor(new DefaultCellEditor(zenbakiak));

		

	}

	
	
	


}

