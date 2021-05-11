package Projekat.FitnesCentar.entity;

import java.util.ArrayList;

public class Sala {
	private int Kapacitet;
	private String OznakaSale;
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
	public ArrayList<Trening> getListaTreninga() {
		return ListaTreninga;
	}
	public void setListaTreninga(ArrayList<Trening> listaTreninga) {
		ListaTreninga = listaTreninga;
	}
	private ArrayList<Trening> ListaTreninga;
}
