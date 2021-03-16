import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Igra extends JPanel {

	Zoga zoga = new Zoga(this);
	Lopar lopar = new Lopar(this);
	Zvocnik zvocnik = new Zvocnik();
	
	private int tocke = 0;
	
	public static void main(String[] args) {
		JFrame okvir = new JFrame("Igra");
		
		Igra igra = new Igra();
		
		okvir.add(igra);
		okvir.setSize(300, 400);
		okvir.setVisible(true);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			igra.premakni();
			igra.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Igra() {
		addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				
			}
			
			public void keyReleased(KeyEvent e) {
				lopar.usatiPremikanje();
			}
			
			public void keyPressed(KeyEvent e) {
				lopar.nastaviPremikanje(e);
			}
		});
		
		setFocusable(true);
	}
	
	private void premakni() {
		zoga.premakni();
		lopar.premakni();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		zoga.paint(g2d);
		lopar.paint(g2d);
		
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(this.tocke), 10, 30);
		
		g2d.drawString(String.valueOf(this.tocke), 10, 330);
	}
	public void konecIgre() {
		JOptionPane.showMessageDialog(this, "Konec igre!");
		System.exit(0);
	}
	
	public void povecajTocke() {
		this.tocke++;
	}

}
