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
		public Korisnik findByUsernameAndPassword(String username,String Password) {
		    Korisnik noviKorisnik= this.korisnikRepository.findByUsernameAndPassword(username,Password);
		    return noviKorisnik;
		}

	}
