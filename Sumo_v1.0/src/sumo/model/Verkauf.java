package sumo.model;

import java.sql.Date;
import java.util.List;
/*
 * Ersteller: Daniel Burgstaller
 * Klassenname: Verkauf
 * Superklasse: - 
 * Interfaces: -
 * Funktionen: -
 */
public class Verkauf {
	private long id;
	private List<VerkaufMedium> medium;
	private float gesamtbetrag;
	private Date datum;
	private String ziel;
	private Kunde kunde;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<VerkaufMedium> getMedium() {
		return medium;
	}
	public void setMedium(List<VerkaufMedium> medium) {
		this.medium = medium;
	}
	public float getGesamtbetrag() {
		return gesamtbetrag;
	}
	public void setGesamtbetrag(float gesamtbetrag) {
		this.gesamtbetrag = gesamtbetrag;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getZiel() {
		return ziel;
	}
	public void setZiel(String ziel) {
		this.ziel = ziel;
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	
	
}//#Verkauf
