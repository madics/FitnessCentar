package Projekat.FitnesCentar.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Clan extends Korisnik {
	public Clan() {}
    public Clan(String username, String password, String ime, String prezime, String kontaktTelefon, String email,
			Date datumRodjenja, Korisnik.Uloga ulogaKorisnika, boolean aktivan) {
		super(username, password, ime, prezime, kontaktTelefon, email, datumRodjenja, ulogaKorisnika, aktivan);
	}

	private static final long serialVersionUID = 1L;
	@ManyToMany
    @JoinTable(name = "listaPosetioca",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> OdradjeniTreninzi = new HashSet<>();

	@ManyToMany
    @JoinTable(name = "listaPrijavljenih",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> PrijavljeniTreninzi = new HashSet<>();
    public boolean prijaviTermin(Termin t) {
		return PrijavljeniTreninzi.add(t);
	}
    public boolean odjaviTermin(Termin t) {
		return PrijavljeniTreninzi.remove(t);
	}
	@OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ocena> ListaOcena= new HashSet<>();
	public Set<Termin> getPrijavljeniTreninzi() {
		return PrijavljeniTreninzi;
	}
	public void setPrijavljeniTreninzi(Set<Termin> prijavljeniTreninzi) {
		PrijavljeniTreninzi = prijavljeniTreninzi;
	}
	
   
	public Set<Termin> getOdradjeniTreninzi() {
		return OdradjeniTreninzi;
	}
	public void setOdradjeniTreninzi(Set<Termin> odradjeniTreninzi) {
		OdradjeniTreninzi = odradjeniTreninzi;
	}
}
