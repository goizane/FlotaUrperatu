package model;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JTable;


import model.componentes.ButtonCellEditor;
import model.componentes.ButtonCellRenderer;
public class MyTable extends JTable {



	private MyTableModel model = new MyTableModel();
	/**
	 * Constructor.
	 */
	public MyTable()  {

		this.setRowHeight(30);

		JComboBox noranzkoa = new JComboBox();
		noranzkoa.addItem("Horizontal");
		noranzkoa.addItem("Bertikal");

		JComboBox zenbakiak= new JComboBox();	
		for(int i=1;i<=10;i++){
			zenbakiak.addItem(i);
		}
		
		// Establecemos el modelo
		this.setModel(model);

		// Establecemos el renderer y editor que usaremos para el boton
		this.setDefaultRenderer(JButton.class, new ButtonCellRenderer());
		this.setDefaultEditor(JButton.class, new ButtonCellEditor());

		// Editores para cada tipo de objeto, estos nos permitirán darles el comportamiento adecuado
		this.getColumn("Noranzkoa").setCellEditor(new DefaultCellEditor(noranzkoa));
		this.getColumn("Errenkada").setCellEditor(new DefaultCellEditor(zenbakiak));
		this.getColumn("Zutabea").setCellEditor(new DefaultCellEditor(zenbakiak));

	}

	public boolean betetaDago() {
		boolean emaitza=true;
		for(int i=0;i<model.getRowCount();i++){
			if(!(boolean)model.getValueAt(i, 5)){
				emaitza=false;
				break;
			}
		}
		
		return emaitza;
	}
	
	


}

