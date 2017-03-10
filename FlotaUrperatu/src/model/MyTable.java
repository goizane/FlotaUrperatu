package model;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.componentes.ButtonCellEditor;
import model.componentes.ButtonCellRenderer;
public class MyTable extends JTable {




	/**
	 * Constructor.
	 */
	public MyTable()  {

		this.setRowHeight(30);

		JComboBox noranzkoa = new JComboBox();
		noranzkoa.addItem("Horizontal");
		noranzkoa.addItem("Bertikal");
		
		MyTableModel model = new MyTableModel();

		// Establecemos el modelo
		this.setModel(model);

		// Establecemos el renderer y editor que usaremos para el boton
		this.setDefaultRenderer(JButton.class, new ButtonCellRenderer());
		this.setDefaultEditor(JButton.class, new ButtonCellEditor());

		// Editores para cada tipo de objeto, estos nos permitirán darles el comportamiento adecuado
		this.getColumn("Noranzkoa").setCellEditor(new DefaultCellEditor(noranzkoa));
		
		
		 
		//this.setDefaultEditor(JCheckBox.class, new DefaultCellEditor(new JCheckBox()));

	}


}

