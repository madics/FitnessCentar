package Projekat.FitnesCentar.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

public class Clan extends Korisnik {

    @ManyToMany
    @JoinTable(name = "odradjeni_treninzi",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> OdradjeniTreninzi = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "prijavljeni_treninzi",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> PrijavljeniTreninzi = new HashSet<>();
    @OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ocena> ListaOcena= new HashSet<>();
	
   
}
