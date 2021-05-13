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
	private Trening trening;
	@Column
	private int Ocena;
    @ManyToOne(fetch = FetchType.EAGER)
    private Clan clan;
	
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
	public Trening getTrening() {
		return trening;
	}
	public void setTrening(Trening trening) {
		this.trening = trening;
	}
	public int getOcena() {
		return Ocena;
	}
	public void setOcena(int ocena) {
		Ocena = ocena;
	}
}
