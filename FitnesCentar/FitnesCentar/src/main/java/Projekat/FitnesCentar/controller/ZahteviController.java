package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;

import Projekat.FitnesCentar.entity.Trener;
import Projekat.FitnesCentar.entity.dto.TrenerDTO;
import Projekat.FitnesCentar.service.TrenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TrenerDTO>> getTreneri() {

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
    }