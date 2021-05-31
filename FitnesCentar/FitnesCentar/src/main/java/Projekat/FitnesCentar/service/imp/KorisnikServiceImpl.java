package Projekat.FitnesCentar.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projekat.FitnesCentar.entity.Korisnik;
import Projekat.FitnesCentar.repository.KorisnikRepository;
import Projekat.FitnesCentar.service.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService{

    private final KorisnikRepository korisnikRepository;
    // constructor-based dependency injection
    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

  
@Override
public Korisnik create(Korisnik korisnik) throws Exception {
    if (korisnik.getId() != null) {
        throw new Exception("ID must be null!");
    }
    Korisnik noviKorisnik= this.korisnikRepository.save(korisnik);
    return noviKorisnik;
}

}
