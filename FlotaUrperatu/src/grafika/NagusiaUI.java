package grafika;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
	private JLabel ezkutua;
	private ButtonGroup armaBotoiak = new ButtonGroup();
	private JRadioButton bonba;
	private JRadioButton misil;
	private JRadioButton misilZ;
	private JComboBox<String> motak;
	private JLabel dirua;
	private static NagusiaUI instantzia= null;

	public static NagusiaUI getI(){
		if(instantzia==null){
			instantzia=new NagusiaUI();
		}
		return instantzia;
	}

	private NagusiaUI(){
		super("Flota urperatu");
		getContentPane().setLayout(new GridLayout(0,3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		nireTaula.setLayout(new GridLayout(11, 11));
		ordenagailua.setLayout(new GridLayout(11, 11));
		Partida.getInstantzia().OrdenagailuarenOntziak();
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

		dirua= new JLabel("Dirua: "+ Integer.toString(KudeatzaileArmak.getInstantzia().getDirua(0))+ "$");
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
				if(Integer.parseInt(KudeatzaileArmak.getInstantzia().radarKop(0))>0){	
					new RadarUI();
				}
				else{
					JOptionPane.showMessageDialog(null, "Radar erabilerak agortu dituzu!");
				}
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
		bonba= new JRadioButton("Bonba : " + Integer.toString(KudeatzaileArmak.getInstantzia().bonbaKop(0))+" dituzu" );
		Font font2 = bonba.getFont();
		Font bonbaF = new Font(font2.getFontName(), font2.getStyle(), 15);
		bonba.setFont(bonbaF);
		misil= new JRadioButton("Misil : " + Integer.toString(KudeatzaileArmak.getInstantzia().misilKop(0)) +" dituzu");
		misil.setFont(bonbaF);
		misilZ= new JRadioButton("Misil zuzendua : " + Integer.toString(KudeatzaileArmak.getInstantzia().misilZKop(0)) +" dituzu");
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

		//misil zuzendua jartzen badugu,combobox agertu
		
 
		motak= new JComboBox<>();
		eguneratuCombo();
		motak.setVisible(false);
		bonba.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				motak.setVisible(false);

			}
		});
		misil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				motak.setVisible(false);

			}
		});

		misilZ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				motak.setVisible(true);

			}
		});


		ezkutua= new JLabel("Ezkutu kopurua: "+ KudeatzaileArmak.getInstantzia().ezkutuKop(0));
		ezkutua.setFont(bonbaF);

		armak.add(tituloa);
		armak.add(bonba);
		armak.add(misil);
		armak.add(misilZ);
		armak.add(motak);
		armak.add(ezkutua);
	}

	private void eguneratuCombo() {
		//0: bertikal
		//1: horizontal
		//2: boom
		int [] kantitateak= KudeatzaileArmak.getInstantzia().misilZuzendu();
		motak.removeItem("boom");
		motak.removeItem("bertikal");
		motak.removeItem("horizontal");
		if(kantitateak[0]>0){

			motak.addItem("bertikal");
		}
		if(kantitateak[1]>0){

			motak.addItem("horizontal");
		}
		if(kantitateak[2]>0){

			motak.addItem("boom");
		}
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
						String berezia;
						if(!arma.equals("misilZ")){
							berezia=null;
						}
						else if(KudeatzaileArmak.getInstantzia().misilZKop(0)==0){
							berezia=null;
						}else{
							berezia=motak.getSelectedItem().toString();
						}
						if(Partida.getInstantzia().armaKopuru(arma)!=0){
							Partida.getInstantzia().tiroEgin(Integer.parseInt(emaitza[0]),Integer.parseInt(emaitza[1]),arma,berezia);
							String  egoera;
							for(int n=0;n<ordenagailuarenTaula.length;n++){
								for(int m=0;m<ordenagailuarenTaula.length;m++){
									egoera= Partida.getInstantzia().getEgoera(n,m,0);
									if(egoera.equals("logika.Hondoratua")){
										ordenagailuarenTaula[n][m].setEnabled(false);
										ordenagailuarenTaula[n][m].setBackground(Color.black);
										ordenagailuarenTaula[n][m].setText(" ");
									}
									else if(Partida.getInstantzia().ukituta(n,m,0)){
										if(egoera.equals("logika.Ukitua")){
											ordenagailuarenTaula[n][m].setBackground(Color.RED);
											ordenagailuarenTaula[n][m].setEnabled(false);
										}
										else if(egoera.equals("logika.Ezkutatua")){
											String eKop=Partida.getInstantzia().ezkutuKontadore(n,m,0);
											ordenagailuarenTaula[n][m].setText(eKop);
										}
										else if(egoera.equals("Ura")){
											ordenagailuarenTaula[n][m].setBackground(Color.cyan);
											ordenagailuarenTaula[n][m].setEnabled(false);
										}
									}
								}
							}
							if(Partida.getInstantzia().irabazi(0)){
								bukatu();
							}

							ordenagailuarenTxanda();
						}
						else{
							JOptionPane.showMessageDialog(null, "Ez daukazu "+arma+"(r)ik!");
						}

						eguneratu();

					}
				});
				ordenagailua.add(botoia);
			}

		}

	}



	public void ordenagailuarenTxanda() {
		int[] emaitza=Partida.getInstantzia().tiroEginOrdenagailua();
		int i = emaitza[0];
		int j= emaitza[1];
		String  egoera= null;
		for(int n=0;n<ontziak.length;n++){
			for(int m=0;m<ontziak.length;m++){
				egoera= Partida.getInstantzia().getEgoera(n,m,1);
				if(egoera.equals("logika.Hondoratua")){
					ontziak[n][m].setEnabled(false);
					ontziak[n][m].setBackground(Color.black);
					ontziak[n][m].setText(" ");
				}
				else if(Partida.getInstantzia().ukituta(n,m,1)){
					if(egoera.equals("logika.Ukitua")){
						ontziak[n][m].setBackground(Color.RED);
					}
					else if(egoera.equals("logika.Ezkutatua")){
						String eKop=Partida.getInstantzia().ezkutuKontadore(n,m,1);
						ontziak[n][m].setText(eKop);
					}
					else if(egoera.equals("Ura")){
						ontziak[n][m].setBackground(Color.cyan);
					}
				}
			}
		}

		if(Partida.getInstantzia().irabazi(1)){
			this.dispose();
			new BukatuGalduUI();
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
					botoia.setBackground(Color.lightGray);
					botoia.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!KudeatzaileOntziak.getInstantzia().ontziaUkitua(row, col)){
								if (JOptionPane.showConfirmDialog(rootPane, "Ezkutua jarri nahi duzu?",
										"Ezkutua jarri", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
									String egoera;
									if(KudeatzaileArmak.getInstantzia().ezkutuaJarri(row, col,0)){
										for(int i=0;i<ontziak.length;i++){
											for(int j=0;j<ontziak.length;j++){
												egoera=Partida.getInstantzia().getNireEgoera(i, j, 0);
												if(egoera.equals("logika.Ezkutatua")){
													ontziak[i][j].setText("E");
												}
											}
										}
										ezkutua.setText("Ezkutu kopurua: "+ KudeatzaileArmak.getInstantzia().ezkutuKop(0));
									}
									else{
										JOptionPane.showMessageDialog(null, "Ezin da ezkutua jarri!");
									}

								}
							}
							//konpundu nahi
							else{
								if (JOptionPane.showConfirmDialog(rootPane, "Ontzia konpondu nahi duzu? \r\n "
										+ "Prezioa: " + KudeatzaileArmak.getInstantzia().ontziarenPrezioa(row,col,0)+ " $",
										"Ontzia konpondu", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
									String egoera;
									if(KudeatzaileArmak.getInstantzia().ontziaKonpondu(row, col,0)){
										for(int i=0;i<ontziak.length;i++){
											for(int j=0;j<ontziak.length;j++){
												egoera=Partida.getInstantzia().getNireEgoera(i, j, 0);
												if(egoera.equals("logika.Normala")){
													ontziak[i][j].setBackground(Color.lightGray);
												}
											}
										}
										//dirua aktualizatu
										dirua.setText("Dirua: "+ Integer.toString(KudeatzaileArmak.getInstantzia().getDirua(0))+ "$");

									}else{
										JOptionPane.showMessageDialog(null, "Ez daukazu diru nahikorik!");
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
					ontziak[row][col]= botoia;
					nireTaula.add(botoia);
				}
			}
		}
	}



	public static void main(String[] args) {
		//Kudeatzaile.getInstantzia().ordenagailuaHasieratu();
		new NagusiaUI();
	}

	public void bukatu(){
		this.dispose();
		new BukatuIrabaziUI();
	}

	public void eguneratu() {
		dirua.setText("Dirua: "+ Integer.toString(KudeatzaileArmak.getInstantzia().getDirua(0))+ "$");
		bonba.setText("Bonba : " + Integer.toString(KudeatzaileArmak.getInstantzia().bonbaKop(0))+" dituzu" );
		misil.setText("Misil : " + Integer.toString(KudeatzaileArmak.getInstantzia().misilKop(0)) +" dituzu");
		misilZ.setText("Misil zuzendua : " + Integer.toString(KudeatzaileArmak.getInstantzia().misilZKop(0)) +" dituzu");
		eguneratuCombo();

	}

}
