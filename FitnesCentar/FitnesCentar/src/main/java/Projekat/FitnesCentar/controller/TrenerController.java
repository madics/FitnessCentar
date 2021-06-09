package Projekat.FitnesCentar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projekat.FitnesCentar.entity.Trener;
import Projekat.FitnesCentar.entity.FitnesCentar;
import Projekat.FitnesCentar.entity.Korisnik;
import Projekat.FitnesCentar.entity.dto.FitnesCentarDTO;
import Projekat.FitnesCentar.entity.dto.TrenerDTO;
import Projekat.FitnesCentar.service.FitnesCentarService;
import Projekat.FitnesCentar.service.TrenerService;




@RestController
@RequestMapping(value = "/api/RegistracijaTrenera")
public class TrenerController {
    private final TrenerService trenerService;

    private final FitnesCentarService fitnesCentarService ;

    // constructor-based dependency injection
    @Autowired
    public TrenerController(TrenerService trenerService,FitnesCentarService fitnesCentarService) {
        this.trenerService = trenerService;
        this.fitnesCentarService= fitnesCentarService;
    }
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<TrenerDTO> createTrener(@RequestBody TrenerDTO trenerDTO) throws Exception {
    Trener trener = new Trener(
    		
            trenerDTO.getUsername(),
            trenerDTO.getPassword (),
            trenerDTO.getIme(),
            trenerDTO.getPrezime(),
            trenerDTO.getTelefon (),
            trenerDTO.getEmail (),
            trenerDTO.getDatum(),
            Korisnik.Uloga.TRENER,
            false,
            fitnesCentarService.findById(trenerDTO.getFcid())
    		);

    Trener noviTrener = trenerService.create(trener);

    TrenerDTO noviTrenerDTO = new TrenerDTO(
    		noviTrener.getId(),
    		noviTrener.getFitnesCentar().getId(),
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
@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<FitnesCentarDTO>> getFitnesCentari() {

	List<FitnesCentar> listaFitnesCentara = this.fitnesCentarService.findAll();
    List<FitnesCentarDTO> centarDTOS = new ArrayList<>();

    for (FitnesCentar centar: listaFitnesCentara) {
    	
    	FitnesCentarDTO centarDTO = new FitnesCentarDTO(
    			centar.getId(),
    			centar.getNaziv(),
    			centar.getAdresa(),
    			centar.getBrojTelefona(),
    			centar.getEmail()
    			);
    	centarDTOS.add(centarDTO);
    }
    return new ResponseEntity<>(centarDTOS, HttpStatus.OK);
}


}