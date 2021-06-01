package Projekat.FitnesCentar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Projekat.FitnesCentar.entity.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>  {
    Korisnik findByUsernameAndPassword(String Username,String Password);

}
