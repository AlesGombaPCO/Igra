import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Lopar2 {
	private final int Y = 10;
	private final int SIRINA = 60;
	private final int VISINA = 20;
	//private final int startX = 130;
	
	//private int x = 0;
	private int x = 110;
	//private int Y;
	private int xPremik = 0;
	private Igra igra;	
	
	private int tocke = 0;
	
	public Lopar2(Igra igra) {
		this.igra = igra;
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(this.x, Y, SIRINA, VISINA);
	}
	
	public void nastaviPremikanje(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			this.xPremik = 1;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A) {
			this.xPremik = -1;
		}
	}
	
	public void ustaviPremikanje() {
		this.xPremik = 0;
	}

	public void premakni() {
		if(this.x + this.xPremik > 0 && this.x + this.xPremik < igra.getWidth() - SIRINA) {
			this.x += this.xPremik;
		}		
	}

	public Rectangle getMejeLoparja() {
		return new Rectangle(this.x, Y, SIRINA, VISINA);
	}
	
	public void setTocke(int tocke) {
		this.tocke = tocke;
	}
	
	public int getTocke() {
		return this.tocke;
	}
}