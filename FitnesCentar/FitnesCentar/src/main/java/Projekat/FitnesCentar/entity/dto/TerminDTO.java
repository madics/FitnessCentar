package Projekat.FitnesCentar.entity.dto;

import java.util.Date;

public class TerminDTO {
	private long id;
	private Date dan;
	private double cena;

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
	public TerminDTO(long id, Date dan,double cena) {
		super();
		this.id = id;
		this.dan = dan;
		this.cena =cena;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
}
