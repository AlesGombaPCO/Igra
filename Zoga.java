import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Zoga {
	//zacetna lokacija zoge
	private int x = 160;
	private int y = 160;
	
	//velikost zoge
	private final int PREMER = 30;
	
	//hitrost zoge
	private int xPremik = 1;
	private int yPremik = 1;
	
	//stevec odbojev, vsakih 5 povecaj pospesek za 1
	private int stevecOdbojev = 0;
	private int pospesek = 0;
	
	private Igra igra;
	private Zvocnik zvocnik = new Zvocnik();
	private Lopar lopar1 = new Lopar(igra);
	private Lopar2 lopar2 = new Lopar2(igra);
	
	public int tockeSpodaj = 0;
	public int tockeZgoraj = 0;
	
	private boolean tockaZaSpodnjiLopar;	//true, ce je tocko dobil spodnji lopar, false ce zgornji
	
	public Zoga(Igra igra) {
		this.igra = igra;
	}
	
	public void paint(Graphics2D g) {
		g.fillOval(this.x, this.y, PREMER, PREMER);
	}
	
	public void premakni() {
		if(this.x + this.xPremik > igra.getWidth() - PREMER) {
			//igra.zvocnik.odboj();
			zvocnik.odboj();
			this.xPremik = -1 - pospesek;	//upostevamo se pospesek pri premikanju		
		}
		
		if(this.y + this.yPremik > igra.getHeight() - PREMER) {
			/*
			if(lopar2.getTocke() < 5) {
				lopar2.setTocke(lopar2.getTocke() + 1);
				resetZoga();
			}			
			else {
				igra.konecIgre();
			}
			*/
			
			tockeZgoraj++;
			tockaZaSpodnjiLopar = false;
			resetZoga();
			
			if(tockeZgoraj == 5) {
				igra.konecIgre();
			}
		}
		
		if(this.x + this.xPremik < 0) {
			//igra.zvocnik.odboj();
			zvocnik.odboj();
			this.xPremik = 1 + pospesek;	//upostevamo se pospesek pri premikanju
		}
		/*
		if(this.y + this.yPremik < 0) {
			igra.zvocnik.odboj();
			this.yPremik = 1 + pospesek;	//upostevamo se pospesek pri premikanju
		}
		*/
		if(this.y + this.yPremik < 0) {
			/*
			if(lopar1.getTocke() < 5) {
				lopar1.setTocke(lopar1.getTocke() + 1);
				resetZoga();
			}			
			else {
				igra.konecIgre();
			}
			*/
			if(tockeSpodaj < 5) {
				tockeSpodaj++;
				tockaZaSpodnjiLopar = true;
				resetZoga();
			}			
			if(tockeSpodaj == 5) {
				igra.konecIgre();
			}
		}
		
		if(trkSpodaj()) {
			
			if(this.yPremik != -1) {
				//igra.povecajTocke();
				igra.zvocnik.trk();
				//ob vsakem trku povecamo stevilo odbojev
				this.stevecOdbojev++;
				if(this.stevecOdbojev > 0 && this.stevecOdbojev % 6 == 0) {
					pospesek++;	//vsakih 5 odbojev povecamo pospesek
				}
			}

			this.yPremik = -1 - pospesek;	//upostevamo se pospesek pri premikanju					
		}
		
		if(trkZgoraj()) {
			
			if(this.yPremik != 1) {
				//igra.povecajTocke();
				igra.zvocnik.trk();
				//ob vsakem trku povecamo stevilo odbojev
				this.stevecOdbojev++;
				if(this.stevecOdbojev > 0 && this.stevecOdbojev % 6 == 0) {
					pospesek++;	//vsakih 5 odbojev povecamo pospesek
				}
			}

			this.yPremik = 1 + pospesek;	//upostevamo se pospesek pri premikanju					
		}
		
		this.x += this.xPremik;
		this.y += this.yPremik;
	}
	
	public Rectangle getMejeZoge() {
		return new Rectangle(this.x, this.y, PREMER, PREMER);
	}
	
	public boolean trkSpodaj() {
		return igra.loparSpodaj.getMejeLoparja().intersects(getMejeZoge());
	}
	public boolean trkZgoraj() {
		return igra.loparZgoraj.getMejeLoparja().intersects(getMejeZoge());
	}
	
	//GET metode, da lahko uporabimo vrednosti v ostalih razredih
	public int getHitrost() {
		return this.xPremik;
	}
	
	public int getPospesek() {
		return this.pospesek;
	}
	
	public void resetZoga() {
		this.x = 160;
		this.y = 160;
		
		if(tockaZaSpodnjiLopar) {
			this.xPremik = 1;
			this.yPremik = -1;
		}
		else {
			this.xPremik = 1;
			this.yPremik = 1;
		}
		
		this.stevecOdbojev = 0;
		this.pospesek = 0;
	}
}