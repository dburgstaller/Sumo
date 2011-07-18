package sumo.model;

import java.sql.Date;
/*
 * Ersteller: Daniel Burgstaller
 * Klassenname: Rechnung
 * Superklasse: -
 * Interfaces: -
 * Funktionen: -
 */
public class Rechnung {
	private long id;
	private String ziel;
	private double betrag;
	private Date datum;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getZiel() {
		return ziel;
	}
	public void setZiel(String ziel) {
		this.ziel = ziel;
	}
	public double getBetrag() {
		return betrag;
	}
	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
}//# Rechnung
