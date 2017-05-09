package model.biltegi;


import java.util.Vector;


import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import kudeatzaileak.BiltegiKudeatzaile;
import logika.Biltegia;





public class MyTableModel extends AbstractTableModel {

	private Vector<LagThumbnail> data = new Vector<LagThumbnail>();
	private Vector<String> columnNames = new Vector<String>();

	public MyTableModel() {
		this.kargatu();
	}

	private void hasieratuZutabeIzenak(){
		columnNames.add("Izena");
		columnNames.add("Deskribapena") ;
		columnNames.add("Prezio");
		columnNames.add("Kantitate");
		columnNames.add("Zenbat Erosi?");
	}


	private void kargatu() {
		hasieratuZutabeIzenak();

		data.add(new LagThumbnail("Bonba","Erortzean, barkuaren posizio "
				+ "\nhori bakarrik deuseztatzen dute "));
		data.add(new LagThumbnail("Misil","Erortzean, posizio hori "
				+ "\ndaukan ontzi guztia deuseztatzen dute "));
		data.add(new LagThumbnail("Misil zuzendua","Hiru misil zuzendu"
				+ " mota daude: Horizontal, Bertikal eta BOOM "));

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
		case 4:
			emaitza= String.class;
			break;
		default:
			break;
		}
		return emaitza;
	}

	public boolean isCellEditable(int i, int j){

		if(j==4){
			return true;
		}
		else{
			return false;
		}
	}

	public void setValueAt (Object value, int i, int j){
		data.get(i).insertElementAt(value, j);
	}

	public void lerroBerria(String izena, String desk){
		data.add(new LagThumbnail(izena,desk));
	}


	public void ezabatuLerroa(int selectedRow) {
		data.remove(selectedRow);
	}






}

