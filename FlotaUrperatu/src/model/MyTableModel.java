package model;


import java.util.Vector;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;





public class MyTableModel extends AbstractTableModel {

	private Vector<LagThumbnail> data = new Vector<LagThumbnail>();
	private Vector<String> columnNames = new Vector<String>();

	public MyTableModel() {
		this.kargatu();
	}

	private void hasieratuZutabeIzenak(){
		columnNames.add("Izena");
		columnNames.add("Luzeera") ;
		columnNames.add("X ardatza");
		columnNames.add("Y ardatza");
		columnNames.add("Noranzkoa");
		columnNames.add("Kokatua");
		columnNames.add("Botoia");
	}

	
	private void kargatu() {
		hasieratuZutabeIzenak();
		
		for(int i=0; i<10;i++){
			if (i<1){
				data.add(new LagThumbnail("Hegazkin-ontzi", "4", "0", "5", false, new JButton("Kokatu")));
			}
			else if(i<3){
				data.add(new LagThumbnail("Itsaspeko", "3", "0", "0", false, new JButton("Kokatu")));
			}
			else if(i<6){
				data.add(new LagThumbnail("Suntsitzaile", "2", "0", "0", false, new JButton("Kokatu")));
			}
			else{
				data.add(new LagThumbnail("Fragata", "1", "0", "0", false, new JButton("Kokatu")));
			}
		}
		
	}


	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).getBalioa(columnIndex);
	}

	public String getColumnName(int i){
		return columnNames.get(i);
	}

	public Class<?> getColumnClass(int col){
		Class<?> emaitza=null;
		switch (col) {
		case 0:
		case 1:
		case 2:
		case 3:
			emaitza= String.class;
			break;
		case 4:
			emaitza= JComboBox.class;
			break;
		case 5:
			emaitza= Boolean.class;
			break;
		case 6:
			emaitza= JButton.class;
		default:
			break;
		}
		return emaitza;
	}

	public boolean isCellEditable(int i, int j){

		boolean emaitza=false;
		if (j==3 || j==2){
			emaitza= true;
		}
		return emaitza;
	}

	public void setValueAt (Object value, int i, int j){
		data.get(i).insertElementAt(value, j);
	}

	public void lerroBerria(String i, String a, String k, String u, Boolean b, JButton bo){
		data.add(new LagThumbnail(i,a,k,u,b,bo));
	}


	public void ezabatuLerroa(int selectedRow) {
		data.remove(selectedRow);
	}






}

