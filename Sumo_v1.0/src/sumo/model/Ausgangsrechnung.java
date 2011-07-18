package sumo.model;

import java.util.List;

public class Ausgangsrechnung extends Rechnung {
	private Kunde kunde;
	private List<Artikelausgang> artikellst;

	public List<Artikelausgang> getArtikel() {
		return artikellst;
	}

	public void setArtikel(List<Artikelausgang> artikel) {
		this.artikellst = artikel;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	
	
}
