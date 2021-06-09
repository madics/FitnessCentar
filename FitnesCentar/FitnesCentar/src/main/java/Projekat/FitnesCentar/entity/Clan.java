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
    @OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ocena> ListaOcena= new HashSet<>();
	
   
}
