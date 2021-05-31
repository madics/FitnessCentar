package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projekat.FitnesCentar.entity.Korisnik;
import Projekat.FitnesCentar.entity.dto.KorisnikDTO;
import Projekat.FitnesCentar.service.KorisnikService;

@RestController
@RequestMapping(value = "/api/RegistracijaKorisnika")
public class KorisnikController {
    private final KorisnikService korisnikService;

    // constructor-based dependency injection
    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<KorisnikDTO> createKorisnik(@RequestBody KorisnikDTO korisnikDTO) throws Exception {
    Korisnik Korisnik = new Korisnik(
    		
            korisnikDTO.getUsername(),
            korisnikDTO.getPassword (),
            korisnikDTO.getIme(),
            korisnikDTO.getPrezime(),
            korisnikDTO.getKontaktTelefon (),
            korisnikDTO.getEmail (),
            korisnikDTO.getDatumRodjenja ()
    		);

    Korisnik noviKorisnik = korisnikService.create(Korisnik);

    KorisnikDTO noviKorisnikDTO = new KorisnikDTO(
    		noviKorisnik.getId(), 
            noviKorisnik.getUsername(),
            noviKorisnik.getPassword (),
            noviKorisnik.getIme(),
            noviKorisnik.getPrezime(),
    		noviKorisnik.getKontaktTelefon (),
    		noviKorisnik.getEmail (),
    		noviKorisnik.getDatumRodjenja ()
    		);

    return new ResponseEntity<>(noviKorisnikDTO, HttpStatus.CREATED);
}
}
