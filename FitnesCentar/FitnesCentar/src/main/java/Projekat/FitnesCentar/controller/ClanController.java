package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projekat.FitnesCentar.entity.Clan;
import Projekat.FitnesCentar.entity.Korisnik;
import Projekat.FitnesCentar.entity.dto.ClanDTO;
import Projekat.FitnesCentar.service.ClanService;
import Projekat.FitnesCentar.service.imp.ClanServiceImpl;




@RestController
@RequestMapping(value = "/api/RegistracijaClana")
public class ClanController {
    private final ClanService clanService;

    // constructor-based dependency injection
    @Autowired
    public ClanController(ClanService clanService) {
        this.clanService = clanService;
    }
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ClanDTO> createClan(@RequestBody ClanDTO clanDTO) throws Exception {
    Clan clan = new Clan(
    		
            clanDTO.getUsername(),
            clanDTO.getPassword (),
            clanDTO.getIme(),
            clanDTO.getPrezime(),
            clanDTO.getKontaktTelefon (),
            clanDTO.getEmail (),
            clanDTO.getDatumRodjenja (),
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
}