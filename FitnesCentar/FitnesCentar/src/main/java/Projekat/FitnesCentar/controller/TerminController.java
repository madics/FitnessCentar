package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;

import Projekat.FitnesCentar.entity.Termin;
import Projekat.FitnesCentar.entity.Korisnik;
import Projekat.FitnesCentar.entity.Termin;
import Projekat.FitnesCentar.entity.Trening;
import Projekat.FitnesCentar.entity.dto.TerminDTO;
import Projekat.FitnesCentar.entity.dto.TerminDTO;
import Projekat.FitnesCentar.service.TerminService;
import Projekat.FitnesCentar.service.TreningService;
import Projekat.FitnesCentar.service.imp.TreningServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/termini")
public class TerminController {

    private final TerminService terminService;
    private final TreningService treningService;
    // constructor-based dependency injection
    @Autowired
    public TerminController(TerminService terminService,TreningService treningService) {
        this.terminService= terminService;
        this.treningService= treningService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermini() {

    	List<Termin> listaTermina = this.terminService.findAll();
        List<TerminDTO> terminDTOS = new ArrayList<>();

        Trening trening;
        for (Termin termin: listaTermina) {
        	
        	trening=this.treningService.findById((termin.getTrening()).getId());
        	
        	TerminDTO terminDTO = new TerminDTO(
        			termin.getId(),
        			termin.getDan(), 
        			termin.getCena(),
        			trening.getNaziv(),
        			trening.getOpis(),
        			trening.getTipTreninga(),
        			trening.getTrajanje());
        	terminDTOS.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    

@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<TerminDTO>> createTermin(@RequestBody TerminDTO terminDTO) throws Exception {
	
	/*TerminDTO terminPretraga = new TerminDTO(
			terminPretraga.getDan(), 
			terminPretraga.getCena(),
			terminPretraga.getNaziv(),
			terminPretraga.getOpis(),
			terminPretraga.getTipTreninga(),
			terminPretraga.getTrajanje());
	*/
   	List<Termin> listaTermina = this.terminService.findAll();
    List<TerminDTO> terminDTOS = new ArrayList<>();

    Trening trening;
    for (Termin termin: listaTermina) {
    	
    	trening=this.treningService.findById((termin.getTrening()).getId());
    	

    }
    return new ResponseEntity<>(terminDTOS, HttpStatus.OK);

}

  
}
