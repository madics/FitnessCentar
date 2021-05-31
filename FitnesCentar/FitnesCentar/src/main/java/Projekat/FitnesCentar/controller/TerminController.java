package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projekat.FitnesCentar.entity.Termin;
import Projekat.FitnesCentar.entity.dto.TerminDTO;
import Projekat.FitnesCentar.service.TerminService;

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

    // constructor-based dependency injection
    @Autowired
    public TerminController(TerminService terminService) {
        this.terminService= terminService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermini() {

        List<Termin> listaTermina = this.terminService.findAll();

        List<TerminDTO> terminDTOS = new ArrayList<>();

        for (Termin termin: listaTermina) {

        	TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getDan(), termin.getCena());
        	terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

  
}
