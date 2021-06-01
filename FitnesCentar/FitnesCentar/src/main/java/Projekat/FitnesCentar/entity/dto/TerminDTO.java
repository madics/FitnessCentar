package Projekat.FitnesCentar.entity.dto;

import java.util.Date;

public class TerminDTO {
	private long id;
	private Date dan;
	private double cena;
	private String naziv;
	private String opis;
	private String TipTreninga;
	private String trajanje;
	
	
	
	public TerminDTO(long id, Date dan, double cena, String naziv, String opis, String tipTreninga, String trajanje) {
		super();
		this.id = id;
		this.dan = dan;
		this.cena = cena;
		this.naziv = naziv;
		this.opis = opis;
		this.TipTreninga = tipTreninga;
		this.trajanje = trajanje;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public Date getDan() {
		return dan;	
	}
	public void setDan(Date dan) {
		this.dan = dan;
	}
	public TerminDTO()
	{}


	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getTipTreninga() {
		return TipTreninga;
	}

	public void setTipTreninga(String tipTreninga) {
		this.TipTreninga = tipTreninga;
	}

	public String getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}
	
}