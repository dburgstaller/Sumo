package sumo.model;

import java.util.List;

public class Eingangsrechnung extends Rechnung {
	private Lieferant lieferant;
	private List<Artikeleingang> artikellst;

	public List<Artikeleingang> getArtikel() {
		return artikellst;
	}

	public void setArtikel(List<Artikeleingang> artikellst) {
		this.artikellst = artikellst;
	}

	public Lieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}
	
}
