package sumo.model;

public class Artikel {
	private long id;
	private String name;
	private short menge;
	private float preis;
	private String kategorie;
	private String bemerkung;
	private short steuerklasse;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getMenge() {
		return menge;
	}
	public void setMenge(short menge) {
		this.menge = menge;
	}
	public float getPreis() {
		return preis;
	}
	public void setPreis(float preis) {
		this.preis = preis;
	}
	public String getKategorie() {
		return kategorie;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	public String getBemerkung() {
		return bemerkung;
	}
	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}
	public short getSteuerklasse() {
		return steuerklasse;
	}
	public void setSteuerklasse(short steuerklasse) {
		this.steuerklasse = steuerklasse;
	}
	
	
}
