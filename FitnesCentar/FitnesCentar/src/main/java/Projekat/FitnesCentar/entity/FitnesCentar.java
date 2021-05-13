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
	 private String Naziv;
	@Column 
	private String Adresa;
	@Column (name = "broj_telefona")
	private String BrojTelefona;
	@Column
	private String Email;
    @OneToMany(mappedBy = "fitnescentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trener> ListaTrenera= new HashSet<>();
    @OneToMany(mappedBy = "fitnescentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> ListaSala= new HashSet<>();
    
    
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
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public String getAdresa() {
		return Adresa;
	}
	public void setAdresa(String adresa) {
		Adresa = adresa;
	}
	public String getBrojTelefona() {
		return BrojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		BrojTelefona = brojTelefona;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

}
