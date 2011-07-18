package sumo.model;

public class Artikelausgang {
	private Ausgangsrechnung ausgangsrechnung;
	private Artikel artikel;
	
	private short menge;
	
	
	
	public Ausgangsrechnung getAusgangsrechnung() {
		return ausgangsrechnung;
	}
	public void setAusgangsrechnung(Ausgangsrechnung ausgangsrechnung) {
		this.ausgangsrechnung = ausgangsrechnung;
	}
	public Artikel getArtikel() {
		return artikel;
	}
	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}
	
	public short getMenge() {
		return menge;
	}
	public void setMenge(short menge) {
		this.menge = menge;
	}
	
	
}
