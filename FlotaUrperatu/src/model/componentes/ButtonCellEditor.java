package model.componentes;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import kudeatzaileak.Kudeatzaile;
import logika.Jokalaria;
import model.MyTableModel;

public class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor {

	/** Componente que estamos editando. */
	private Component currentValue;

	@Override
	public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, final int row, int column) {

		JButton button = null;

		if (value instanceof JButton) {
			button = (JButton) value;
			// Action que permite "limpiar" los valores de una fila
			
			button.setAction(new AbstractAction("Kokatu") {

				@Override
				public void actionPerformed(ActionEvent e) {
					MyTableModel model=(MyTableModel) table.getModel();
					int xAr=Integer.parseInt(model.getValueAt(row, 2).toString());
					int yAr=Integer.parseInt(model.getValueAt(row, 3).toString());
					String no= model.getValueAt(row, 4).toString();
					char n;
					if(no.equals("Horizontal")){
						n='h';
					}
					else{
						n='b';
					}
					String ontziIzena= model.getValueAt(row, 0).toString();
					if (Kudeatzaile.getInstantzia().JokalariarenOntziak(xAr, yAr, ontziIzena, n)){
						model.setValueAt(true, row, 5);
						model.fireTableDataChanged();
						this.setEnabled(false);
					}
					else{
						JOptionPane.showMessageDialog(null, "Ezin da ontzia posizio horretan kokatu!");
					}
					
				}
			});
		}

		currentValue = button;

		return button;
	}

	@Override
	public Object getCellEditorValue() {
		return currentValue;
	}

}