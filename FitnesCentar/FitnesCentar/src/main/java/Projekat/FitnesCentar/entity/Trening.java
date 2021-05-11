package Projekat.FitnesCentar.entity;

public class Trening {
	private String Naziv;
	private String Opis;
	private String TipTreninga;
	private String Trajanje;
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public String getOpis() {
		return Opis;
	}
	public void setOpis(String opis) {
		Opis = opis;
	}
	public String getTipTreninga() {
		return TipTreninga;
	}
	public void setTipTreninga(String tipTreninga) {
		TipTreninga = tipTreninga;
	}
	public String getTrajanje() {
		return Trajanje;
	}
	public void setTrajanje(String trajanje) {
		Trajanje = trajanje;
	}
}
