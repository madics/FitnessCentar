package Projekat.FitnesCentar.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class FitnesCentar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	 private String naziv;
	@Column 
	private String adresa;
	@Column (name = "broj_telefona")
	private String broj;
	@Column
	private String email;
    @OneToMany(mappedBy = "fitnescentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trener> ListaTrenera= new HashSet<>();
    @OneToMany(mappedBy = "fitnescentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> ListaSala= new HashSet<>();
    
    public FitnesCentar() {}
	public FitnesCentar(long id, String naziv, String adresa, String broj, String email) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.broj = broj;
		this.email = email;
	}
	public FitnesCentar(String naziv, String adresa, String broj, String email) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.broj = broj;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<Trener> getListaTrenera() {
		return ListaTrenera;
	}
	public void setListaTrenera(Set<Trener> listaTrenera) {
		ListaTrenera = listaTrenera;
	}
	public Set<Sala> getListaSala() {
		return ListaSala;
	}
	public void setListaSala(Set<Sala> listaSala) {
		ListaSala = listaSala;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBrojTelefona() {
		return broj;
	}
	public void setBrojTelefona(String brojTelefona) {
		broj = brojTelefona;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
