package Projekat.FitnesCentar.entity.dto;

public class FitnesCentarDTO {

	private long id;
	private String naziv;
	private String adresa;
	private String broj;
	private String email;
	public FitnesCentarDTO(long id, String naziv, String adresa, String broj, String email) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.broj = broj;
		this.email = email;
	}
	public FitnesCentarDTO(String naziv2, String adresa2, String brojTelefona, String email2) {
		this.naziv = naziv2;
		this.adresa = adresa2;
		this.broj = brojTelefona;
		this.email = email2;
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
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
