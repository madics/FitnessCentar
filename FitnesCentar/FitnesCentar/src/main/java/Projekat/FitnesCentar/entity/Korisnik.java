package Projekat.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Korisnik implements Serializable{
	public enum Uloga{ADMINISTRATOR,TRENER,CLAN}
	
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
	@Column (name = "kontakt_telefon")
	private String KontaktTelefon;
	@Column
	private String Email;;
	@Column (name = "datum_rodjenja")
	private Date DatumRodjenja;;
	@Column (name = "uloga_korisnika")
	private Uloga UlogaKorisnika;
	@Column
	private boolean Aktivan;
	public Korisnik() {}
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
	public Korisnik(String username2, String password2, String ime2, String prezime2, String kontaktTelefon2,
			String email2, Date datumRodjenja2) {
		Username = username2;
		Password = password2;
		Ime = ime2;
		Prezime = prezime2;
		KontaktTelefon = kontaktTelefon2;
		Email = email2;
		DatumRodjenja = datumRodjenja2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatumRodjenja() {
		return DatumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		DatumRodjenja = datumRodjenja;
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
