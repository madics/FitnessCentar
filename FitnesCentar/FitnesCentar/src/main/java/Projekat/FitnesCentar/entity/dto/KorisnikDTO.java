package Projekat.FitnesCentar.entity.dto;

import Projekat.FitnesCentar.entity.Korisnik;

public class KorisnikDTO {
	private Long id;
	private String Username;
	private String Password;
	Korisnik.Uloga uloga;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Korisnik.Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Korisnik.Uloga uloga) {
		this.uloga = uloga;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public KorisnikDTO(String username, String password) {
		super();
		Username = username;
		Password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
