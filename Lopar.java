import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Lopar {

	private final int Y = 330;
	private final int Y2 = 60;
	private final int SIRINA = 60;
	private final int VISINA = 20;
	
	
	private int x = 0;
	private int xPremik = 1;
	private Igra igra;
	
	public Lopar(Igra igra) {
		this.igra = igra;
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(this.x, Y, SIRINA, VISINA);
	}
	
	public void nastaviPremikanje(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.xPremik = 1;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.xPremik = -1;
		}
	}
	
	public void usatiPremikanje() {
		this.xPremik = 0;
	}
	
	public void premakni() {
		if(this.x + this.xPremik > 0 && 
		   this.x + this.xPremik < igra.getWidth() - SIRINA) {
			this.x += this.xPremik; 
		}
		
	}
	
	public Rectangle getMejeLoparja() {
		return new Rectangle(this.x, Y, SIRINA, VISINA);
	}
}
