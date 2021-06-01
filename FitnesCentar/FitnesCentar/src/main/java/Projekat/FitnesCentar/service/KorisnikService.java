package Projekat.FitnesCentar.service;

import Projekat.FitnesCentar.entity.Korisnik;

public interface KorisnikService {

	Korisnik findByUsernameAndPassword(String username,String password);

}
