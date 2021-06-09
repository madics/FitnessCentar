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
import Projekat.FitnesCentar.service.imp.KorisnikServiceImpl;



@RestController
@RequestMapping(value = "/api/Logovanje")
public class KorisnikController {
    private final KorisnikService korisnikService;

    // constructor-based dependency injection
    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }
   
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)

public ResponseEntity<KorisnikDTO> logovanje(@RequestBody KorisnikDTO korisnikDTO) throws Exception {



    	Korisnik noviKorisnik = korisnikService.findByUsernameAndPassword(korisnikDTO.getUsername(),korisnikDTO.getPassword());
    if(noviKorisnik!=null) {    
    korisnikDTO.setId(noviKorisnik.getId());
	korisnikDTO.setUloga(noviKorisnik.getUlogaKorisnika());
    }
	return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
	
}
}






