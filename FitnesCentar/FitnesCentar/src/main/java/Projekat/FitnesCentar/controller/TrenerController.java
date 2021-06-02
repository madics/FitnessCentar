package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projekat.FitnesCentar.entity.Trener;
import Projekat.FitnesCentar.entity.Korisnik;
import Projekat.FitnesCentar.entity.dto.TrenerDTO;
import Projekat.FitnesCentar.service.TrenerService;




@RestController
@RequestMapping(value = "/api/RegistracijaTrenera")
public class TrenerController {
    private final TrenerService trenerService;

    // constructor-based dependency injection
    @Autowired
    public TrenerController(TrenerService trenerService) {
        this.trenerService = trenerService;
    }
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<TrenerDTO> createTrener(@RequestBody TrenerDTO trenerDTO) throws Exception {
    Trener trener = new Trener(
    		
            trenerDTO.getUsername(),
            trenerDTO.getPassword (),
            trenerDTO.getIme(),
            trenerDTO.getPrezime(),
            trenerDTO.getKontaktTelefon (),
            trenerDTO.getEmail (),
            trenerDTO.getDatumRodjenja (),
            Korisnik.Uloga.TRENER,
            false
    		);

    Trener noviTrener = trenerService.create(trener);

    TrenerDTO noviTrenerDTO = new TrenerDTO(
    		noviTrener.getId(), 
            noviTrener.getUsername(),
            noviTrener.getPassword (),
            noviTrener.getIme(),
            noviTrener.getPrezime(),
    		noviTrener.getKontaktTelefon (),
    		noviTrener.getEmail (),
    		noviTrener.getDatumRodjenja (),
    		noviTrener.getUlogaKorisnika(),
    		noviTrener.isAktivan()
    		);

    return new ResponseEntity<>(noviTrenerDTO, HttpStatus.CREATED);
}
}