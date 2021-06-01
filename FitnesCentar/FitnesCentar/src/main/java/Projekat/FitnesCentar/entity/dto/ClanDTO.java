package Projekat.FitnesCentar.entity.dto;

import java.sql.Date;

import Projekat.FitnesCentar.entity.Korisnik;

public class ClanDTO {
	private Long id;
	private String Username;
	private String Password;
	private String Ime;
	private String Prezime;
	private String KontaktTelefon;
	private String Email;
	private Date DatumRodjenja;
	private Korisnik.Uloga UlogaKorisnika;
	private boolean Aktivan;
	public ClanDTO() {}
	public ClanDTO(Long id, String username, String password, String ime, String prezime, String kontaktTelefon,
			String email, Date datumRodjenja, Korisnik.Uloga ulogaKorisnika, boolean aktivan) {
		super();
		this.id = id;
		Username = username;
		Password = password;
		Ime = ime;
		Prezime = prezime;
		KontaktTelefon = kontaktTelefon;
		Email = email;
		DatumRodjenja = datumRodjenja;
		UlogaKorisnika = ulogaKorisnika;
		Aktivan = aktivan;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getIme() {
		return Ime;
	}
	public void setIme(String ime) {
		Ime = ime;
	}
	public String getPrezime() {
		return Prezime;
	}
	public void setPrezime(String prezime) {
		Prezime = prezime;
	}
	public String getKontaktTelefon() {
		return KontaktTelefon;
	}
	public void setKontaktTelefon(String kontaktTelefon) {
		KontaktTelefon = kontaktTelefon;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getDatumRodjenja() {
		return DatumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		DatumRodjenja = datumRodjenja;
	}
	public Korisnik.Uloga getUlogaKorisnika() {
		return UlogaKorisnika;
	}
	public void setUlogaKorisnika(Korisnik.Uloga ulogaKorisnika) {
		UlogaKorisnika = ulogaKorisnika;
	}
	public boolean isAktivan() {
		return Aktivan;
	}
	public void setAktivan(boolean aktivan) {
		Aktivan = aktivan;
	}
}
