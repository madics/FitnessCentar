package Projekat.FitnesCentar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ocena {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private int Ocena;
    @ManyToOne(fetch = FetchType.EAGER)
    private Clan clan;
    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;
	public Ocena() {}
	public Ocena(int ocena, Clan clan, Termin termin) {
		super();
		Ocena = ocena;
		this.clan = clan;
		this.termin = termin;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan fitnesCentar) {
		this.clan = fitnesCentar;
	}

	public int getOcena() {
		return Ocena;
	}
	public void setOcena(int ocena) {
		Ocena = ocena;
	}
	public Termin getTermin() {
		return termin;
	}
	public void setTermin(Termin termin) {
		this.termin = termin;
	}
	
}
