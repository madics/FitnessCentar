package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;

import Projekat.FitnesCentar.entity.FitnesCentar;
import Projekat.FitnesCentar.entity.Korisnik;
import Projekat.FitnesCentar.entity.Sala;
import Projekat.FitnesCentar.entity.Trener;
import Projekat.FitnesCentar.entity.dto.FitnesCentarDTO;
import Projekat.FitnesCentar.entity.dto.SalaDTO;
import Projekat.FitnesCentar.entity.dto.TrenerDTO;
import Projekat.FitnesCentar.service.FitnesCentarService;
import Projekat.FitnesCentar.service.SalaService;
import Projekat.FitnesCentar.service.TrenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/sala")
public class SalaController {

    private final SalaService salaService ;
    private final FitnesCentarService fitnesService;
    // constructor-based dependency injection
    @Autowired
    public SalaController(SalaService salaService,FitnesCentarService fitnesService) {
        this.salaService= salaService;
        this.fitnesService= fitnesService;
    }

    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        this.salaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSale() {//prikaz svih sala

    	List<Sala> listaSala = this.salaService.findAll();
        List<SalaDTO> salaDTOS = new ArrayList<>();

        for (Sala sala: listaSala) {
        	
            SalaDTO salaDTO = new SalaDTO(
            		sala.getId(),
            		sala.getKapacitet(),
            		sala.getOznakaSale(),
            		sala.getFitnesCentar().getId()
            		);
            	salaDTOS.add(salaDTO);
        }
        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> createSala(@RequestBody SalaDTO salaDTO) throws Exception {//pravljenje sale
        Sala sala = new Sala(
                salaDTO.getKapacitet(),
                salaDTO.getOznakaSale(),
                fitnesService.findById(salaDTO.getFcid())
        		);
        Sala noviSala = salaService.create(sala);

        SalaDTO noviSalaDTO = new SalaDTO(
        		noviSala.getId(),
        		noviSala.getKapacitet(),
        		noviSala.getOznakaSale(),
                noviSala.getFitnesCentar().getId()
        		);

        return new ResponseEntity<>(noviSalaDTO, HttpStatus.CREATED);
    }
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE,value="/{id}")
	public ResponseEntity<SalaDTO> updateSala(@PathVariable("id") Long salaId,
	  @Validated @RequestBody SalaDTO salaDTO) throws Exception {
		
	     Sala sala = this.salaService.findOne(salaId);
	     sala.setKapacitet(salaDTO.getKapacitet());
	     sala.setOznakaSale(salaDTO.getOznakaSale());
	     Sala updatedSala = salaService.update(sala);
	     SalaDTO noviSalaDTO = new SalaDTO(
	    		 updatedSala.getId(),
	    		 updatedSala.getKapacitet(),
	    		 updatedSala.getOznakaSale(),
	    		 updatedSala.getFitnesCentar().getId()
	     		);
	     return new ResponseEntity<>(noviSalaDTO,HttpStatus.OK); 
	}
    /*
     * 
     * 

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/svi")//svi fitnesi
    public ResponseEntity<List<TrenerDTO>> getSviTreneri()throws Exception  {
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
        			trenerDTOS.add(trenerDTO);
        }
        return new ResponseEntity<>(trenerDTOS, HttpStatus.OK);
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
    */

}