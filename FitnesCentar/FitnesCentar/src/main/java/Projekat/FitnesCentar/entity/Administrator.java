package Projekat.FitnesCentar.entity;

import java.sql.Date;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Administrator extends Korisnik {

	public Administrator(String username, String password, String ime, String prezime, String kontaktTelefon,
			String email, Date datumRodjenja, Korisnik.Uloga ulogaKorisnika, boolean aktivan) {
		super(username, password, ime, prezime, kontaktTelefon, email, datumRodjenja, ulogaKorisnika, aktivan);
		// TODO Auto-generated constructor stub
	}

}
