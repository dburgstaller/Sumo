package sumo.model;

public class Artikeleingang {
	private Eingangsrechnung eingangsrechnung;
	private Artikel artikel;

	private float eingangspreis;
	private short menge;
	
	
	public Eingangsrechnung getEingangsrechnung() {
		return eingangsrechnung;
	}
	public void setEingangsrechnung(Eingangsrechnung eingangsrechnung) {
		this.eingangsrechnung = eingangsrechnung;
	}
	public float getEingangspreis() {
		return eingangspreis;
	}
	public void setEingangspreis(float eingangspreis) {
		this.eingangspreis = eingangspreis;
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
