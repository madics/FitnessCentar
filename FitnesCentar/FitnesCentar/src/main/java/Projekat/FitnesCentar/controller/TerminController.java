package Projekat.FitnesCentar.controller;

import org.springframework.beans.factory.annotation.Autowired;

import Projekat.FitnesCentar.entity.Termin;
import Projekat.FitnesCentar.entity.Trening;
import Projekat.FitnesCentar.entity.dto.TerminDTO;
import Projekat.FitnesCentar.service.TerminService;
import Projekat.FitnesCentar.service.TreningService;
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
    private final TreningService treningService;
    // constructor-based dependency injection
    @Autowired
    public TerminController(TerminService terminService,TreningService treningService) {
        this.terminService= terminService;
        this.treningService= treningService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermini() {

    	List<Termin> listaTermina = this.terminService.findAll();
        List<TerminDTO> terminDTOS = new ArrayList<>();

        Trening trening;
        for (Termin termin: listaTermina) {
        	
        	trening=this.treningService.findById((termin.getTrening()).getId());
        	
        	TerminDTO terminDTO = new TerminDTO(
        			termin.getId(),
        			termin.getDan(), 
        			termin.getCena(),
        			trening.getNaziv(),
        			trening.getOpis(),
        			trening.getTipTreninga(),
        			trening.getTrajanje());
        	terminDTOS.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    
/*
 */
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<TerminDTO>> filterTermin(@RequestBody TerminDTO terminPretraga) throws Exception {
	
   	List<Termin> listaTermina = this.terminService.findAll();
    List<TerminDTO> terminDTOS = new ArrayList<>();
    /*
*/
    TerminDTO terminDTO;
    for (Termin termin: listaTermina) {
    	terminDTO=new TerminDTO(this.treningService.findById((termin.getTrening()).getId()),termin);
    	terminDTOS.add(terminDTO);
    	
    	
    	if(terminPretraga.getCena()!=-1//da li pretrazuje
    			&&terminPretraga.getCena()!=terminDTO.getCena()//po cemu pretrazuje
    			)terminDTOS.remove(terminDTO);
    	
    	if(terminPretraga.getDan()!=null//da li pretrazuje
    			&&!terminPretraga.getDan().equals(terminDTO.getDan())//po cemu pretrazuje
    			)terminDTOS.remove(terminDTO);
    	
    	
    	if(!terminPretraga.getOpis().equals("")//da li pretrazuje
    			&&!terminPretraga.getOpis().equals(terminDTO.getOpis())//po cemu pretrazuje
    			)terminDTOS.remove(terminDTO);
    	
    	if(!terminPretraga.getNaziv().equals("")//da li pretrazuje
				&&!terminPretraga.getNaziv().equals(terminDTO.getNaziv())//po cemu pretrazuje
				)terminDTOS.remove(terminDTO);
		
    	if(!terminPretraga.getTipTreninga().equals("")//da li pretrazuje
    			&&!terminPretraga.getTipTreninga().equals(terminDTO.getTipTreninga())//po cemu pretrazuje
    			)terminDTOS.remove(terminDTO);
    	
    	if(!terminPretraga.getTrajanje().equals("")//da li pretrazuje
				&&!terminPretraga.getTrajanje().equals(terminDTO.getTrajanje())//po cemu pretrazuje
				)terminDTOS.remove(terminDTO);
    		 
    }
  
    return new ResponseEntity<>(terminDTOS, HttpStatus.OK);

}

  
}
