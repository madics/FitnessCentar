package Projekat.FitnesCentar.entity;

import java.sql.Date;
import java.util.ArrayList;

public class Trener extends Korisnik{
	
	private ArrayList<Trening> ListaTreninga;
	private double ProsecnaOcena;
	
	
	public Trener(String username, String password, String ime, String prezime, String kontaktTelefon, String email,
			Date datumRodjenja, Uloga ulogaKorisnika, boolean aktivan) {
		super(username, password, ime, prezime, kontaktTelefon, email, datumRodjenja, ulogaKorisnika, aktivan);
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Trening> getListaTreninga() {
		return ListaTreninga;
	}
	public void setListaTreninga(ArrayList<Trening> listaTreninga) {
		ListaTreninga = listaTreninga;
	}
	public double getProsecnaOcena() {
		return ProsecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		ProsecnaOcena = prosecnaOcena;
	}
	

}
