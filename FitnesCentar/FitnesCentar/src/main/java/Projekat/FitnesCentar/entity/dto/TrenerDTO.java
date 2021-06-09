package Projekat.FitnesCentar.entity.dto;

import java.sql.Date;

import Projekat.FitnesCentar.entity.Korisnik;
import Projekat.FitnesCentar.entity.Korisnik.Uloga;

public class TrenerDTO {
	private Long id;
	private Long fcid;
	private String username;   
	private String password;   
	private String ime;        
	private String prezime;    
	private String telefon;    
	private String email;      
	private Date datum;     
	private Korisnik.Uloga uloga;
	private boolean aktivan;
	public TrenerDTO() {}
	public TrenerDTO(Long id, String username, String password, String ime, String prezime, String telefon,
			String email, Date datum, Korisnik.Uloga uloga, boolean aktivan) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon= telefon;
		this.email= email;
		this.datum= datum;
		this.uloga= uloga;
		this.aktivan= aktivan;
	}
	
	public TrenerDTO(Long id, Long fcid, String username, String password, String ime, String prezime, String telefon,
			String email, Date datum, Uloga uloga, boolean aktivan) {
		super();
		this.id = id;
		this.fcid = fcid;
		this.username = username;
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
		this.datum = datum;
		this.uloga = uloga;
		this.aktivan = aktivan;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Korisnik.Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Korisnik.Uloga uloga) {
		this.uloga = uloga;
	}
	public boolean isAktivan() {
		return aktivan;
	}
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	public Long getFcid() {
		return fcid;
	}
	public void setFcid(Long fcid) {
		this.fcid = fcid;
	}
}
