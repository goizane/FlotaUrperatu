package logika;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class TaulaPanela extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = -6744712728807455322L;
	
	private boolean hasiera;
	private boolean pausa;
	private PosizioLaukia[][] laukiak;
	
	public TaulaPanela() {
		hasiera = true;
		int errenkadak = 10;
		int zutabeak = 10;
		this.setLayout(new GridLayout(errenkadak, zutabeak));
		laukiak = new PosizioLaukia[errenkadak][zutabeak];
		for (int i = 0; i < errenkadak; i++) {
			for (int j = 0; j < zutabeak; j++) {
				PosizioLaukia laukiBat = new PosizioLaukia();
				laukiBat.setName(i + "," + j);
				laukiBat.addMouseListener(this);
				this.add(laukiBat);
				laukiak[i][j] = laukiBat;
			}
		}
		this.setOpaque(true);
		this.pausa = false;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}