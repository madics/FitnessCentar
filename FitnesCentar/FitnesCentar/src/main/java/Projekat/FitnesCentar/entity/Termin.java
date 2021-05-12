package Projekat.FitnesCentar.entity;

public class Termin {
	
	private Trening trening;
	private String dan;
	private double cena;
	
	public Trening getTrening() {
		return trening;
	}
	public void setTrening(Trening trening) {
		this.trening = trening;
	}
	public String getDan() {
		return dan;
	}
	public void setDan(String dan) {
		this.dan = dan;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
}
