package Projekat.FitnesCentar.entity;

import java.util.ArrayList;

public class Sala {
	private int Kapacitet;
	private String OznakaSale;
	private ArrayList<Termin> listaTermina;
	public int getKapacitet() {
		return Kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		Kapacitet = kapacitet;
	}
	public String getOznakaSale() {
		return OznakaSale;
	}
	public void setOznakaSale(String oznakaSale) {
		OznakaSale = oznakaSale;
	}
	public ArrayList<Termin> getListaTermina() {
		return listaTermina;
	}
	public void setListaTermina(ArrayList<Termin> listaTermina) {
		this.listaTermina = listaTermina;
	}
	
}
