package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projekat.FitnesCentar.entity.FitnesCentar;
import Projekat.FitnesCentar.entity.dto.FitnesCentarDTO;
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
}
