package Projekat.FitnesCentar.entity;

import java.util.ArrayList;

public class FitnesCentar {
	 private String Naziv;
	 private String Adresa;
	 private String BrojTelefona;
	 private String Email;
	 private ArrayList<Trener> ListaTrenera;
	 private ArrayList<Sala> ListaSala;
	 //poslednja tacka
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public String getAdresa() {
		return Adresa;
	}
	public void setAdresa(String adresa) {
		Adresa = adresa;
	}
	public String getBrojTelefona() {
		return BrojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		BrojTelefona = brojTelefona;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public ArrayList<Trener> getListaTrenera() {
		return ListaTrenera;
	}
	public void setListaTrenera(ArrayList<Trener> listaTrenera) {
		ListaTrenera = listaTrenera;
	}
	public ArrayList<Sala> getListaSala() {
		return ListaSala;
	}
	public void setListaSala(ArrayList<Sala> listaSala) {
		ListaSala = listaSala;
	}
}
