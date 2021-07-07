package Projekat.FitnesCentar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projekat.FitnesCentar.entity.FitnesCentar;
import Projekat.FitnesCentar.entity.Sala;
import Projekat.FitnesCentar.entity.dto.FitnesCentarDTO;
import Projekat.FitnesCentar.entity.dto.SalaDTO;
import Projekat.FitnesCentar.service.FitnesCentarService;


@RestController
@RequestMapping(value = "/api/fitnes")
public class FitnesCentarController {
    private final FitnesCentarService fitnesCentarService;

    // constructor-based dependency injection
    @Autowired
    public FitnesCentarController(FitnesCentarService fitnesCentarService) {
        this.fitnesCentarService = fitnesCentarService;
    }
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDTO> create(@RequestBody FitnesCentarDTO fitnesDTO) throws Exception {

        FitnesCentar fitnesCentar = new FitnesCentar(
        		fitnesDTO.getNaziv(),
        		fitnesDTO.getAdresa(),
        		fitnesDTO.getBroj(), 
        		fitnesDTO.getEmail()
        		);


        FitnesCentar noviFitnesCentar =fitnesCentarService.create(fitnesCentar);


        FitnesCentarDTO fitnesCentarDTO = new FitnesCentarDTO(
        		noviFitnesCentar.getNaziv(), 
        		noviFitnesCentar .getAdresa(),
        		noviFitnesCentar.getBrojTelefona(), 
        		noviFitnesCentar .getEmail()
        		);


        return new ResponseEntity<>(fitnesCentarDTO, HttpStatus.CREATED);
    }
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE,value="/pretraga")
	public ResponseEntity<List<SalaDTO>> getSaleFitnesa(
			  @Validated @RequestBody int id) throws Exception {
					FitnesCentar fc= this.fitnesCentarService.findById(id);
					Set<Sala> listaSala = fc.getListaSala();
					List<SalaDTO> listaSalaDTO=  new ArrayList<>();
			    	
			    	for (Sala sale: listaSala) {
			    		
			    		listaSalaDTO.add(new SalaDTO(
			    				sale.getId(),
			    				sale.getKapacitet(),
			    				sale.getOznakaSale(),
			    				sale.getFitnesCentar().getId()
			        			));
			    	}
					
				return new ResponseEntity<>(listaSalaDTO, HttpStatus.CREATED);
				}
}
