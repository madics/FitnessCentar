package Projekat.FitnesCentar.entity;

import java.sql.Date;
import java.util.ArrayList;

public class Clan extends Korisnik {

	private ArrayList<Trening> OdradjeniTreninzi;
	private ArrayList<Trening> NeodradjeniTreninzi;
	private ArrayList<Ocena> ListaOcena;
	
	public Clan(String username, String password, String ime, String prezime, String kontaktTelefon, String email,
			Date datumRodjenja, Uloga ulogaKorisnika, boolean aktivan) {
		super(username, password, ime, prezime, kontaktTelefon, email, datumRodjenja, ulogaKorisnika, aktivan);
		// TODO Auto-generated constructor stub
	}
	

	public ArrayList<Trening> getOdradjeniTreninzi() {
		return OdradjeniTreninzi;
	}
	public void setOdradjeniTreninzi(ArrayList<Trening> odradjeniTreninzi) {
		OdradjeniTreninzi = odradjeniTreninzi;
	}
	public ArrayList<Trening> getNeodradjeniTreninzi() {
		return NeodradjeniTreninzi;
	}
	public void setNeodradjeniTreninzi(ArrayList<Trening> neodradjeniTreninzi) {
		NeodradjeniTreninzi = neodradjeniTreninzi;
	}
	public ArrayList<Ocena> getListaOcena() {
		return ListaOcena;
	}
	public void setListaOcena(ArrayList<Ocena> listaOcena) {
		ListaOcena = listaOcena;
	}
}
