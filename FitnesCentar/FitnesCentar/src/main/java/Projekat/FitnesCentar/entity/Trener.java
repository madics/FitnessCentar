package Projekat.FitnesCentar.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Trener extends Korisnik{
    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> ListaTreninga= new HashSet<>();
	@Column(name="prosecna_ocena")
    private double ProsecnaOcena;
    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnescentar;
    
	public Set<Termin> getListaTreninga() {
		return ListaTreninga;
	}
	public void setListaTreninga(Set<Termin> listaTreninga) {
		ListaTreninga = listaTreninga;
	}
	public double getProsecnaOcena() {
		return ProsecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		ProsecnaOcena = prosecnaOcena;
	}
	public FitnesCentar getFitnesCentar() {
		return fitnescentar;
	}
	public void setFitnesCentar(FitnesCentar fitnesCentar) {
		this.fitnescentar = fitnesCentar;
	}
    
}
