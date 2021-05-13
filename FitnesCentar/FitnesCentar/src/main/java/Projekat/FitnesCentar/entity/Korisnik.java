package Projekat.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

enum Uloga{ADMINISTRATOR,TRENER,CLAN}
@Entity
public class Korisnik implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String Username;
	@Column
	private String Password;
	@Column
	private String Ime;
	@Column
	private String Prezime;
	@Column
	private String KontaktTelefon;
	@Column
	private String Email;
	@Column
	private Date DatumRodjenja;
	@Column
	private Uloga UlogaKorisnika;
	@Column
	private boolean Aktivan;
	
	public Korisnik(String username, String password, String ime, String prezime, String kontaktTelefon, String email,
			Date datumRodjenja, Uloga ulogaKorisnika, boolean aktivan) {
		super();
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
	public Date getDatumRodjenja() {
		return DatumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		DatumRodjenja = datumRodjenja;
	}
	/*
	public void registracijaKorisnika() {
	if(UlogaKorisnika==Uloga.TRENER) {
		//potvrda admina
	}else {
	
	}

	}
	public void prijavaKorisnika() {
	if(Aktivan) {
		//prijava radi
	}else {
		//ne radi
	}
	}
	*/
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
	public Uloga getUlogaKorisnika() {
		return UlogaKorisnika;
	}
	public void setUlogaKorisnika(Uloga ulogaKorisnika) {
		UlogaKorisnika = ulogaKorisnika;
	}
	public boolean isAktivan() {
		return Aktivan;
	}
	public void setAktivan(boolean aktivan) {
		Aktivan = aktivan;
	}
}
