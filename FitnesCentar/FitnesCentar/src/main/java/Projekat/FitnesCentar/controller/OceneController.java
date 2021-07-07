package Projekat.FitnesCentar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projekat.FitnesCentar.entity.Clan;
import Projekat.FitnesCentar.entity.Ocena;
import Projekat.FitnesCentar.entity.Termin;
import Projekat.FitnesCentar.entity.dto.TerminDTO;
import Projekat.FitnesCentar.service.ClanService;
import Projekat.FitnesCentar.service.OcenaService;

@RestController
@RequestMapping(value = "/api/ocena")
public class OceneController {
    private final OcenaService ocenaService;
    private final ClanService clanService;

    // constructor-based dependency injection
    @Autowired
    public OceneController(OcenaService ocenaService, ClanService clanService) {
        this.ocenaService = ocenaService;
		this.clanService = clanService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/ocenjeni/{id}")//treninzi liste selekt
    public ResponseEntity<List<TerminDTO>> getOcenjeni(@PathVariable("id") Long clanId)throws Exception  {
    	List<Ocena> ocene= ocenaService.findAll(); 
    	List<TerminDTO> terminDTOS = new ArrayList<>();
    	
    	for (Ocena ocena: ocene) {
    		if(clanId==ocena.getClan().getId())
    		terminDTOS.add( new TerminDTO(
    				ocena.getTermin().getTrening(),
    				ocena.getTermin()
    				));
    	}
    	return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/neocenjeni/{id}")//treninzi liste selekt
    public ResponseEntity<List<TerminDTO>> getNeocenjeni(@PathVariable("id") Long clanId)throws Exception  {
    	Clan clan = this.clanService.findOne(clanId);
    	List<Ocena> ocene= ocenaService.findAll(); 
    	Set<Termin> odradjeni= clan.getOdradjeniTreninzi();
    	List<Termin> ocenjeni= new ArrayList<>();
    	List<TerminDTO> terminDTOS = new ArrayList<>();

		for (Ocena ocena: ocene)if(clanId==ocena.getClan().getId()&&!ocenjeni.contains(ocena.getTermin()))ocenjeni.add(ocena.getTermin());
    	for (Termin termin: odradjeni) {
    				if(!ocenjeni.contains(termin))
    				terminDTOS.add( new TerminDTO(
    				termin.getTrening(),
    				termin
    				));
    				
        		
    		}
     
    	return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
}
