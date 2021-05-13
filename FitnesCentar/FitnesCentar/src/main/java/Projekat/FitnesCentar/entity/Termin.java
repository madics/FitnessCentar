package Projekat.FitnesCentar.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Termin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private Trening trening;
	@Column
	private Date dan;
	@Column
	private double cena;

    @ManyToMany(mappedBy = "sala_termin")
    private Set<Sala> employees = new HashSet<>();

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
