package Projekat.FitnesCentar.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Trening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
	private String Naziv;
    @Column
	private String Opis;
    @Column
	private String TipTreninga;
    @Column
	private String Trajanje;
    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;
    
    
    
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public String getOpis() {
		return Opis;
	}
	public void setOpis(String opis) {
		Opis = opis;
	}
	public String getTipTreninga() {
		return TipTreninga;
	}
	public void setTipTreninga(String tipTreninga) {
		TipTreninga = tipTreninga;
	}
	public String getTrajanje() {
		return Trajanje;
	}
	public void setTrajanje(String trajanje) {
		Trajanje = trajanje;
	}
}
