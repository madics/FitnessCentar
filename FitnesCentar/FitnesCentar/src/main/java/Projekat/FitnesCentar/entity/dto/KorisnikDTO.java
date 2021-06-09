package Projekat.FitnesCentar.entity.dto;

import Projekat.FitnesCentar.entity.Korisnik;

public class KorisnikDTO {
	private Long id;
	private String username;
	private String password;
	Korisnik.Uloga uloga;
	
	public KorisnikDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	public Korisnik.Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Korisnik.Uloga uloga) {
		this.uloga = uloga;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
