package Projekat.FitnesCentar.entity;

enum Uloga{ADMINISTRATOR,TRENER,CLAN}

public class Korisnik {

	private String Username;
	private String Password;
	private String Ime;
	private String Prezime;
	private String KontaktTelefon;
	private String Email;
	private String DatumRodjenja;
	private Uloga UlogaKorisnika;
	private boolean Aktivan;
	
	public Korisnik(String username, String password, String ime, String prezime, String kontaktTelefon, String email,
			String datumRodjenja, Uloga ulogaKorisnika, boolean aktivan) {
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
	public String getDatumRodjenja() {
		return DatumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
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
