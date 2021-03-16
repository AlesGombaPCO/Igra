import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Zoga {

	private final int PREMER = 30;
	private int x = 0;
	private int y = 0;
	private int xPremik = 1;
	private int yPremik = 1;
	private Igra igra;
	
	public Zoga(Igra igra) {
		this.igra = igra;
	}
	
	public void paint(Graphics2D g) {
		g.fillOval(this.x, this.y, this.PREMER, this.PREMER);
	}
	
	public void premakni() {
		if(this.x + this.xPremik > igra.getWidth() - PREMER) {
			this.xPremik = -1;
			igra.zvocnik.odboj();
		} 
		if(this.y + this.yPremik > igra.getHeight() - PREMER ) {
			igra.konecIgre();
		}
		if(this.x + this.xPremik < 0) {
			this.xPremik = 1;
			igra.zvocnik.odboj();
		}
		if(this.y + this.yPremik < 0) {
			this.yPremik = 1;
			igra.zvocnik.odboj();
		}
		
		if(trk()) {
			if(this.yPremik != -1) {
				igra.zvocnik.trk();
				igra.povecajTocke();
			}
			
			this.yPremik = -1;
		}
		
		this.x += this.xPremik;
		this.y += this.yPremik;
	}
	
	public Rectangle getMejeZoge() {
		return new Rectangle(this.x, this.y, PREMER, PREMER);
	}
	
	public boolean trk() {
		return igra.lopar.getMejeLoparja().intersects(getMejeZoge());
	}
}
