package grafika;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import kudeatzaileak.KudeatzaileArmak;
import kudeatzaileak.KudeatzaileOntziak;
import kudeatzaileak.Partida;

public class NagusiaUI extends JFrame{

	private JPanel nireTaula= new JPanel();
	private JPanel ordenagailua= new JPanel();
	private JPanel botoiak= new JPanel();
	private JPanel armak= new JPanel();
	private JButton[][] ontziak= new JButton[10][10];
	private JButton[][] ordenagailuarenTaula= new JButton[10][10];
	private JLabel ezkutua= new JLabel("Ezkutu kopurua: "+ KudeatzaileArmak.getInstantzia().ezkutuKop());
	private ButtonGroup armaBotoiak = new ButtonGroup();


	public NagusiaUI(){
		super("Flota urperatu");
		getContentPane().setLayout(new GridLayout(0,3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		nireTaula.setLayout(new GridLayout(11, 11));
		ordenagailua.setLayout(new GridLayout(11, 11));
		nireTaulaBete();
		ordenagailuTaulaBete();
		botoiakHasieratu();


		getContentPane().add(nireTaula);
		getContentPane().add(botoiak);
		getContentPane().add(ordenagailua);
		setMinimumSize(new Dimension(1500, 600));

		setVisible(true);
	}

	private void botoiakHasieratu() {
		botoiak.setLayout(null);

		JLabel dirua= new JLabel("Dirua: "+ Integer.toString(KudeatzaileArmak.getInstantzia().getDirua())+ "$");
		Font font = dirua.getFont();
		// same font but bold
		Font boldFont = new Font(font.getFontName(), Font.BOLD, 20);
		dirua.setFont(boldFont);

		JButton radarra= new JButton("Radar");
		radarra.setFont(boldFont);
		JButton biltegia= new JButton("Biltegia");
		biltegia.setFont(boldFont);
		//radar listener
		radarra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RadarUI();

			}
		});


		//biltegia listener
		biltegia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BiltegiUI();

			}
		});


		armakBete();



		botoiak.add(dirua);
		dirua.setBounds(150,0,300,100);
		botoiak.add(armak);
		armak.setBounds(150,100,300,200);
		botoiak.add(radarra);
		radarra.setBounds(150,310,200,60);
		botoiak.add(biltegia);
		biltegia.setBounds(150,400,200,60);



	}

	private void armakBete() {

		armak.setLayout(new GridLayout(0, 1));

		JLabel tituloa= new JLabel("Armak:");
		Font font = tituloa.getFont();
		// same font but bold
		Font boldFont = new Font(font.getFontName(), Font.BOLD, 20);
		tituloa.setFont(boldFont);
		JRadioButton bonba= new JRadioButton("Bonba : " + Integer.toString(KudeatzaileArmak.getInstantzia().bonbaKop())+" dituzu" );
		Font font2 = bonba.getFont();
		Font bonbaF = new Font(font2.getFontName(), font2.getStyle(), 15);
		bonba.setFont(bonbaF);
		JRadioButton misil= new JRadioButton("Misil : " + Integer.toString(KudeatzaileArmak.getInstantzia().misilKop()) +" dituzu");
		misil.setFont(bonbaF);
		JRadioButton misilZ= new JRadioButton("Misil zuzendua : " + Integer.toString(KudeatzaileArmak.getInstantzia().misilZKop()) +" dituzu");
		misilZ.setFont(bonbaF);

		//botoiak talde batean sartu eta horrela bakarrik bat aukera daiteke
		bonba.setActionCommand("bonba");
		misil.setActionCommand("misil");
		misilZ.setActionCommand("misilZ");
		armaBotoiak.add(bonba);
		armaBotoiak.add(misil);
		armaBotoiak.add(misilZ);

		//defektuz bonbak selekzionatu
		bonba.setSelected(true);


		//ez daukazu armarik
		if(KudeatzaileArmak.getInstantzia().bonbaKop()==0){
			bonba.setEnabled(false);
		}
		if(KudeatzaileArmak.getInstantzia().misilKop()==0){
			misil.setEnabled(false);
		}
		if(KudeatzaileArmak.getInstantzia().misilZKop()==0){
			misilZ.setEnabled(false);
		}



		JLabel ezkutua= new JLabel("Ezkutu kopurua: "+ KudeatzaileArmak.getInstantzia().ezkutuKop());
		ezkutua.setFont(bonbaF);

		armak.add(tituloa);
		armak.add(bonba);
		armak.add(misil);
		armak.add(misilZ);
		armak.add(ezkutua);
	}

	private void ordenagailuTaulaBete() {
		int kont=1;
		int kont2=1;
		for(int i=0;i<121;i++){
			if(i==0){
				JLabel text= new JLabel();
				ordenagailua.add(text);
			}
			else if(i<=10){
				JLabel text= new JLabel(Integer.toString(kont), SwingConstants.CENTER);
				ordenagailua.add(text);
				kont++;
			}else if(i%11==0){
				JLabel text= new JLabel(Integer.toString(kont2), SwingConstants.CENTER);
				ordenagailua.add(text);
				kont2++;
			}
			else{
				JButton botoia= new JButton();
				botoia.setSize(new Dimension(10, 10));
				ordenagailuarenTaula[(i%11)-1][(i/11)-1]=botoia;
				botoia.setActionCommand(Integer.toString((i%11)-1)+","+Integer.toString((i/11)-1));
				botoia.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String i= e.getActionCommand();
						String[] emaitza= i.split(",");
						String arma= armaBotoiak.getSelection().getActionCommand();
						Partida.getInstantzia().tiroEgin(Integer.parseInt(emaitza[0]),Integer.parseInt(emaitza[1]),arma);
						String  egoera;
						for(int n=0;n<ordenagailuarenTaula.length;n++){
							for(int m=0;m<ordenagailuarenTaula.length;m++){
								egoera= Partida.getInstantzia().getEgoera(n,m,0);
								if(egoera.equals("Ukitua")){
									ordenagailuarenTaula[n][m].setEnabled(false);
									ordenagailuarenTaula[n][m].setBackground(Color.RED);
								}
								else if(egoera.equals("Hondoratua")){
									ordenagailuarenTaula[n][m].setEnabled(false);
									if(Partida.getInstantzia().hondoratua(m,n)){
										ordenagailuarenTaula[n][m].setBackground(Color.black);
									}
								}
								else if(egoera.equals("Ezkutatua")){
									String eKop=Partida.getInstantzia().ezkutuKontadore(n,m,0);
									ordenagailuarenTaula[n][m].setText(eKop);
								}
								else if(egoera.equals("Ura")&&!ordenagailuarenTaula[n][m].isEnabled()){
									ordenagailuarenTaula[n][m].setEnabled(false);
									ordenagailuarenTaula[n][m].setBackground(Color.white);
								}
							}
						}
						//ordenagailuarenTxanda();
					}
				});
				ordenagailua.add(botoia);
			}

		}

	}



	public void ordenagailuarenTxanda() {
		Partida.getInstantzia().tiroEginOrdenagailua();
		String  egoera;
		for(int n=0;n<ontziak.length;n++){
			for(int m=0;m<ontziak.length;m++){
				egoera= Partida.getInstantzia().getEgoera(n,m,1);
				if(egoera.equals("Ukitua")){
					ontziak[n][m].setBackground(Color.RED);
				}
				else if(egoera.equals("Hondoratua")){
					ontziak[n][m].setEnabled(false);
					if(Partida.getInstantzia().hondoratua(m,n)){
						ontziak[n][m].setBackground(Color.black);
					}
				}
				else if(egoera.equals("Ezkutatua")){
					String eKop=Partida.getInstantzia().ezkutuKontadore(n,m,0);
					ontziak[n][m].setText(eKop);
				}
				else if(egoera.equals("Ura")){
					ontziak[n][m].setBackground(Color.white);
				}
			}
		}
		
	}

	private void nireTaulaBete() {
		int kont=1;
		int kont2=1;
		for(int i=0;i<121;i++){
			if(i==0){
				JLabel text= new JLabel();
				nireTaula.add(text);
			}
			else if(i<=10){
				JLabel text= new JLabel(Integer.toString(kont), SwingConstants.CENTER);
				nireTaula.add(text);
				kont++;
			}else if(i%11==0){
				JLabel text= new JLabel(Integer.toString(kont2), SwingConstants.CENTER);
				nireTaula.add(text);
				kont2++;
			}
			else{
				int col= (i%11)-1;
				int row= (i/11)-1;
				if(Partida.getInstantzia().ontzirikDago(row,col)){
					JButton botoia= new JButton();
					ontziak[row][col]= botoia;
					botoia.setSize(new Dimension(5, 10));
					botoia.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!KudeatzaileOntziak.getInstantzia().ontziaUkitua(row, col)){
								if (JOptionPane.showConfirmDialog(rootPane, "Ezkutua jarri nahi duzu?",
										"Ezkutua jarri", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
									if(KudeatzaileArmak.getInstantzia().ezkutuaJarri(row, col)){
										botoiakUkitu(row,col);
									}
									else{
										JOptionPane.showMessageDialog(null, "Ezin da ezkutua jarri!");
									}

								}
							}

						}
					});
					nireTaula.add(botoia);
				}
				else{
					JButton botoia= new JButton();
					botoia.setSize(new Dimension(5, 10));
					botoia.setEnabled(false);
					nireTaula.add(botoia);
				}
			}
		}
		Partida.getInstantzia().ordenagailuarenTaulaAbiarazi();
	}

	private void botoiakUkitu(int i,int j){
		if(!ontziak[i][j].getText().equals("E")){
			ontziak[i][j].setText("E");
			ezkutua.setText("Ezkutu kopurua: "+ Integer.toString(KudeatzaileArmak.getInstantzia().ezkutuKop()));

			if(j<10&&j>=0&&i-1<10&&i-1>=0&&ontziak[i-1][j]!=null){
				botoiakUkitu(i-1, j);
			}
			if(j+1<10&&j+1>=0&&i<10&&i>=0&&ontziak[i][j+1]!=null){
				botoiakUkitu(i, j+1);
			}
			if(j<10&&j>=0&&i+1<10&&i+1>=0&&ontziak[i+1][j]!=null){
				botoiakUkitu(i+1, j);
			}
			if(j-1<10&&j-1>=0&&i<10&&i>=0&&ontziak[i][j-1]!=null){
				botoiakUkitu(i, j-1);
			}
		}
	}

	public static void main(String[] args) {
		//Kudeatzaile.getInstantzia().ordenagailuaHasieratu();
		new NagusiaUI();
	}

}
