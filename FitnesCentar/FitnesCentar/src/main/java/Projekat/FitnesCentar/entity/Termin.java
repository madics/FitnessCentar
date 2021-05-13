package Projekat.FitnesCentar.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Termin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private Date dan;
	@Column
	private double cena;
	
    @ManyToMany(mappedBy = "PrijavljeniTreninzi")
    private Set<Clan> listaPrijavljenih= new HashSet<>();
    @ManyToMany(mappedBy = "OdradjeniTreninzi")
    private Set<Clan> listaPosetioca= new HashSet<>();
    @OneToMany(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Ocena> ocene = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;    
	@ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;
    @ManyToOne(fetch = FetchType.EAGER)
	private Trening trening;
    
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Set<Clan> getListaPosetioca() {
		return listaPosetioca;
	}
	public void setListaPosetioca(Set<Clan> listaPosetioca) {
		this.listaPosetioca = listaPosetioca;
	}
	public Set<Clan> getListaPrijavljenih() {
		return listaPrijavljenih;
	}
	public void setListaPrijavljenih(Set<Clan> listaPrijavljenih) {
		this.listaPrijavljenih = listaPrijavljenih;
	}
	public Trener getTrener() {
		return trener;
	}
	public void setTrener(Trener trener) {
		this.trener = trener;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}



	public Trening getTrening() {
		return trening;
	}
	public void setTrening(Trening trening) {
		this.trening = trening;
	}
	public Date getDan() {
		return dan;
	}
	public void setDan(Date dan) {
		this.dan = dan;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
}
