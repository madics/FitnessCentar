package Projekat.FitnesCentar.entity.dto;


public class TreningDTO {

	private long id;
	private String naziv;
	private String opis;
	private String tip;
	private String trajanje;
	public TreningDTO(long id, String naziv, String opis, String tip, String trajanje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.tip = tip;
		this.trajanje = trajanje;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}
	
}
