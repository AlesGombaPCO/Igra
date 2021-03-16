import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Igra extends JPanel{
	
	Zoga zoga = new Zoga(this);
	//spodnji lopar y=330, zgornji lopar y=10
	Lopar loparSpodaj = new Lopar(this);
	Lopar2 loparZgoraj = new Lopar2(this);
	//Lopar loparZgoraj = new Lopar(this, 10);
	Zvocnik zvocnik = new Zvocnik();
	
	//private int tocke = 0;
	
	public static void main(String[] args) {
		JFrame okvir = new JFrame("Igra");
		
		Igra igra = new Igra();
		
		okvir.add(igra);
		okvir.setSize(300, 400);
		okvir.setLocation(600, 200);	//kje na ekranu se okno odpre
		okvir.setVisible(true);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			igra.premakni();
			igra.repaint();
			
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Igra() {
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
				loparSpodaj.ustaviPremikanje();
				loparZgoraj.ustaviPremikanje();
			}
			public void keyPressed(KeyEvent e) {
				loparSpodaj.nastaviPremikanje(e);
				loparZgoraj.nastaviPremikanje(e);
			}
		});
		
		setFocusable(true);
	}
	
	private void premakni() {
		zoga.premakni();
		loparSpodaj.premakni();
		loparZgoraj.premakni();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		zoga.paint(g2d);
		loparSpodaj.paint(g2d);
		loparZgoraj.paint(g2d);
		
		g2d.setColor(Color.red);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(zoga.tockeZgoraj), 10, 30);
		
		//to je samo za testiranje
		//izpisuje trenutni pospesek desno zgoraj v oknu 
		g2d.setColor(Color.blue);
		g2d.drawString(String.valueOf(zoga.tockeSpodaj), 10, 350);
	}
	
	public void konecIgre() {
		zvocnik.konecIgre();
		JOptionPane.showMessageDialog(this, "Konec igre!\nRezultat:\nLoparSpodaj: "
				+ zoga.tockeSpodaj + " : " + zoga.tockeZgoraj + " LoparZgoraj");
		System.exit(0);
	}
	
	public void povecajTocke() {
		//this.tocke++;
	}
	
}























