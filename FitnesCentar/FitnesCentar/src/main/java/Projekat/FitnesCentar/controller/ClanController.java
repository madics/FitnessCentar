package Projekat.FitnesCentar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projekat.FitnesCentar.entity.Clan;
import Projekat.FitnesCentar.entity.Korisnik;
import Projekat.FitnesCentar.entity.Termin;
import Projekat.FitnesCentar.entity.Trening;
import Projekat.FitnesCentar.entity.dto.ClanDTO;
import Projekat.FitnesCentar.entity.dto.TerminDTO;
import Projekat.FitnesCentar.service.ClanService;
import Projekat.FitnesCentar.service.TerminService;




@RestController
@RequestMapping(value = "/api/RegistracijaClana")
public class ClanController {
    private final ClanService clanService;
    private final TerminService terminService;

    // constructor-based dependency injection
    @Autowired
    public ClanController(ClanService clanService,TerminService terminService) {
        this.clanService = clanService;
        this.terminService = terminService;
    }
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ClanDTO> createClan(@RequestBody ClanDTO clanDTO) throws Exception {
    Clan clan = new Clan(
    		
            clanDTO.getUsername(),
            clanDTO.getPassword (),
            clanDTO.getIme(),
            clanDTO.getPrezime(),
            clanDTO.getTelefon (),
            clanDTO.getEmail (),
            clanDTO.getDatum(),
            Korisnik.Uloga.CLAN,
            true
    		);

    Clan noviClan = clanService.create(clan);

    ClanDTO noviClanDTO = new ClanDTO(
    		noviClan.getId(), 
            noviClan.getUsername(),
            noviClan.getPassword (),
            noviClan.getIme(),
            noviClan.getPrezime(),
    		noviClan.getKontaktTelefon (),
    		noviClan.getEmail (),
    		noviClan.getDatumRodjenja (),
    		noviClan.getUlogaKorisnika(),
    		noviClan.isAktivan()
    		);

    return new ResponseEntity<>(noviClanDTO, HttpStatus.CREATED);
}
		@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE,value="/{id}/prijava")
		public ResponseEntity<String> prijavaTermina(@PathVariable("id") Long clanId,
		  @Validated @RequestBody Long terminId) throws Exception {
			
			 Clan clan = this.clanService.findOne(clanId);
		     Termin termin = this.terminService.findOne(terminId);
		     clan.prijaviTermin(termin);
		     clanService.update(clan);
		     return new ResponseEntity<>(new String(clanId+" je prijavio "+terminId),HttpStatus.OK); 
		}
		
		@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE,value="/{id}/odjava")
		public ResponseEntity<String> odjavaTermina(@PathVariable("id") Long clanId,
		  @Validated @RequestBody Long terminId) throws Exception {
			
			 Clan clan = this.clanService.findOne(clanId);
		     Termin termin = this.terminService.findOne(terminId);
		     clan.odjaviTermin(termin);
		     clanService.update(clan);
		     return new ResponseEntity<>(new String(clanId+" je prijavio "+terminId),HttpStatus.OK); 
		}

	    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/{id}")
	    public ResponseEntity<List<TerminDTO>> getPrijavljeni(@PathVariable("id") Long clanId)throws Exception {

			 Clan clan = this.clanService.findOne(clanId);
	    	Set<Termin> listaTermina = clan.getPrijavljeniTreninzi();
	        List<TerminDTO> terminDTOS = new ArrayList<>() ;


	        for (Termin termin: listaTermina) {


	        	TerminDTO terminDTO = new TerminDTO(
	        			termin.getId(),
	        			termin.getDan(), 
	        			termin.getCena(),
	        			termin.getTrening().getNaziv(),
	        			termin.getTrening().getOpis(),
	        			termin.getTrening().getTipTreninga(),
	        			termin.getTrening().getTrajanje());
	        		terminDTOS.add(terminDTO);
	        }
	        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
	    }
		
		
		
		
		
		
		
		
		
}