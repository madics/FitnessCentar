package Projekat.FitnesCentar.entity.dto;

import java.sql.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



public class KorisnikDTO {
	public enum Uloga{ADMINISTRATOR,TRENER,CLAN}
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String Username;
private String Password;
private String Ime;
private String Prezime;
private String KontaktTelefon;
private String Email;
private Date DatumRodjenja;;
private Uloga UlogaKorisnika;
private boolean Aktivan;
public KorisnikDTO() {}
public KorisnikDTO(Long id, String username, String password, String ime, String prezime, String kontaktTelefon,
		String email, Date datumRodjenja, Uloga ulogaKorisnika, boolean aktivan) {
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
public KorisnikDTO(Long id2, String username2, String password2, String ime2, String prezime2, String kontaktTelefon2,
		String email2, Date datumRodjenja2) {
	// TODO Auto-generated constructor stub
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
