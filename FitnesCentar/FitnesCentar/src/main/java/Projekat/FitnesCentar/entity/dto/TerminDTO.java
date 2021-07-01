package Projekat.FitnesCentar.entity.dto;

import java.util.Date;

import Projekat.FitnesCentar.entity.Termin;
import Projekat.FitnesCentar.entity.Trening;

public class TerminDTO {
	private long id;
	private Date dan;
	private double cena;
	private String naziv;
	private String opis;
	private String tip;
	private String trajanje;
	private long trenerId;
	private long salaId;
	private long treningId;

	
	
	public TerminDTO(long id, Date dan, double cena, String naziv, String opis, String tip, String trajanje) {
		super();
		this.id = id;
		this.dan = dan;
		this.cena = cena;
		this.naziv = naziv;
		this.opis = opis;
		this.tip=tip;
		this.trajanje = trajanje;
	}
	
/*
 */
	public TerminDTO(Date dan, double cena, String naziv, String opis, String tip, String trajanje) {
		super();
		this.dan = dan;
		this.cena = cena;
		this.naziv = naziv;
		this.opis = opis;
		this.tip=tip;
		this.trajanje = trajanje;
	}
		public TerminDTO(Date dan, double cena, String naziv, String opis, String tip, String trajanje,long idtrenera,long idsale,long idtreninga) {
			super();
			this.dan = dan;
			this.cena = cena;
			this.naziv = naziv;
			this.opis = opis;
			this.tip=tip;
			this.trajanje = trajanje;
			this.trenerId=idtrenera;
			this.salaId=idsale;
			this.treningId=idtreninga;
		}
	public TerminDTO(Trening trening,Termin termin) {
		this.id = termin.getId();
		this.dan = termin.getDan();
		this.cena = termin.getCena();
		this.naziv = trening.getNaziv();
		this.opis = trening.getOpis();
		this.tip=trening.getTipTreninga();
		this.trajanje = trening.getTrajanje();
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


	public String getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}

	public String getTipTreninga() {
		return tip;
	}

	public void setTipTreninga(String tip) {
		this.tip = tip;
	}

	public long getTrenerId() {
		return trenerId;
	}

	public void setTrenerId(long trenerId) {
		this.trenerId = trenerId;
	}

	public long getSalaId() {
		return salaId;
	}

	public void setSalaId(long salaId) {
		this.salaId = salaId;
	}

	public long getTreningId() {
		return treningId;
	}

	public void setTreningId(long treningId) {
		this.treningId = treningId;
	}
	
}
