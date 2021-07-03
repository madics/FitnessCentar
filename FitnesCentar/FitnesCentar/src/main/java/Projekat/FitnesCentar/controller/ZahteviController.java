package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;

import Projekat.FitnesCentar.entity.FitnesCentar;
import Projekat.FitnesCentar.entity.Trener;
import Projekat.FitnesCentar.entity.dto.FitnesCentarDTO;
import Projekat.FitnesCentar.entity.dto.TrenerDTO;
import Projekat.FitnesCentar.service.FitnesCentarService;
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
    private final FitnesCentarService fitnesService;
    // constructor-based dependency injection
    @Autowired
    public ZahteviController(TrenerService trenerService,FitnesCentarService fitnesService) {
        this.trenerService= trenerService;
        this.fitnesService= fitnesService;
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
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/fitnes")//svi fitnesi
    public ResponseEntity<List<FitnesCentarDTO>> getFitnesi()throws Exception  {
    	List<FitnesCentar> listaCentara= this.fitnesService.findAll();
    	List<FitnesCentarDTO> centarDTOS = new ArrayList<>();
    	
    	for (FitnesCentar centar: listaCentara) {
    		
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
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFitnesCentar(@PathVariable Long id) {
        this.fitnesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE,value="/izmena/{id}")
	public ResponseEntity<FitnesCentarDTO> izmenaFitnesa(@PathVariable("id") Long fcid,
			  @Validated @RequestBody FitnesCentarDTO fitnesCentarDTO) throws Exception {
						FitnesCentar fitnesCentar = this.fitnesService.findById(fcid);

						fitnesCentar.setNaziv(fitnesCentarDTO.getNaziv());
						fitnesCentar.setAdresa(fitnesCentarDTO.getAdresa());
						fitnesCentar.setEmail(fitnesCentarDTO.getEmail());
						fitnesCentar.setBrojTelefona(fitnesCentarDTO.getBroj());
						FitnesCentar noviFitnesCentar = this.fitnesService.update(fitnesCentar);
						FitnesCentarDTO noviFitnesCentarDTO = new FitnesCentarDTO(
								noviFitnesCentar.getId(),
								noviFitnesCentar.getNaziv(),
								noviFitnesCentar.getAdresa(),
								noviFitnesCentar.getBrojTelefona(),
								noviFitnesCentar.getEmail()
								);
						
						return new ResponseEntity<>(noviFitnesCentarDTO, HttpStatus.CREATED);
				}

}