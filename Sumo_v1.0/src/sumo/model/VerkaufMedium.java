package sumo.model;

public class VerkaufMedium {
	private Medium medium;
	private Verkauf verkauf;
	private short menge;
	
	public short getMenge() {
		return menge;
	}
	public void setMenge(short menge) {
		this.menge = menge;
	}
	public Medium getMedium() {
		return medium;
	}
	public void setMedium(Medium medium) {
		this.medium = medium;
	}
	public Verkauf getVerkauf() {
		return verkauf;
	}
	public void setVerkauf(Verkauf verkauf) {
		this.verkauf = verkauf;
	}
	
	
}
