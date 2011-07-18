package sumo.model;

import java.sql.Date;

/*
* Ersteller: Christian Bauer 
* Klassenname: Kassa
* Superklasse: -
* Interfaces: -
* Funktionen: -
*/
public class Kassa {
	private long id;
	private Date datum;
	private float bestand;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public float getBestand() {
		return bestand;
	}
	public void setBestand(float bestand) {
		this.bestand = bestand;
	}
	

}//#Kassa
