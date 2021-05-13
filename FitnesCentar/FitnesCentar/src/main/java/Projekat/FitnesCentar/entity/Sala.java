package Projekat.FitnesCentar.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private int Kapacitet;
	@Column
	private String OznakaSale;
    @ManyToMany
    @JoinTable(name = "mesto_vreme",
            joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> listaTermina= new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnesCentar;
    
	public FitnesCentar getFitnesCentar() {
		return fitnesCentar;
	}
	public void setFitnesCentar(FitnesCentar fitnesCentar) {
		this.fitnesCentar = fitnesCentar;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<Termin> getListaTermina() {
		return listaTermina;
	}
	public void setListaTermina(Set<Termin> listaTermina) {
		this.listaTermina = listaTermina;
	}
    
	public int getKapacitet() {
		return Kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		Kapacitet = kapacitet;
	}
	public String getOznakaSale() {
		return OznakaSale;
	}
	public void setOznakaSale(String oznakaSale) {
		OznakaSale = oznakaSale;
	}
	
}
