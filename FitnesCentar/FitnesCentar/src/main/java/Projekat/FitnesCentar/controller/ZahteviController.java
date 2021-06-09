package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;

import Projekat.FitnesCentar.entity.Trener;
import Projekat.FitnesCentar.entity.dto.TrenerDTO;
import Projekat.FitnesCentar.service.TrenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/zahtevi")
public class ZahteviController {

    private final TrenerService trenerService;
    // constructor-based dependency injection
    @Autowired
    public ZahteviController(TrenerService trenerService) {
        this.trenerService= trenerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO>> getTreneri() {//prikaz trenera za odobravanje

    	List<Trener> listaTrenera = this.trenerService.findAll();
        List<TrenerDTO> trenerDTOS = new ArrayList<>();

        for (Trener trener: listaTrenera) {
        	
            TrenerDTO trenerDTO = new TrenerDTO(
            		trener.getId(),
            		trener.getUsername(),
                    trener.getPassword (),
                    trener.getIme(),
                    trener.getPrezime(),
            		trener.getKontaktTelefon (),
            		trener.getEmail (),
            		trener.getDatumRodjenja (),
            		trener.getUlogaKorisnika(),
            		trener.isAktivan()
            		);
        			if(!trener.isAktivan())trenerDTOS.add(trenerDTO);
        }
        return new ResponseEntity<>(trenerDTOS, HttpStatus.OK);
    }

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE,value="/{id}")
	public ResponseEntity<TrenerDTO> updateTrener(@PathVariable("id") Long trenerId,
	  @Validated @RequestBody Long id) throws Exception {
		
	     Trener trener = this.trenerService.findOne(id);
	     Trener updatedTrener = trenerService.update(trener);
	     TrenerDTO noviTrenerDTO = new TrenerDTO(
				updatedTrener.getId(),
				updatedTrener.getFitnesCentar().getId(),
				 updatedTrener.getUsername(),
				 updatedTrener.getPassword (),
				 updatedTrener.getIme(),
				 updatedTrener.getPrezime(),
				updatedTrener.getKontaktTelefon (),
				updatedTrener.getEmail (),
				updatedTrener.getDatumRodjenja (),
				updatedTrener.getUlogaKorisnika(),
				updatedTrener.isAktivan()
	     		);
	     return new ResponseEntity<>(noviTrenerDTO,HttpStatus.OK); 
	}

}