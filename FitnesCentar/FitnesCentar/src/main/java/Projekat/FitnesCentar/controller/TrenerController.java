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

import Projekat.FitnesCentar.entity.Trener;
import Projekat.FitnesCentar.entity.Trening;
import Projekat.FitnesCentar.entity.FitnesCentar;
import Projekat.FitnesCentar.entity.Korisnik;
import Projekat.FitnesCentar.entity.Sala;
import Projekat.FitnesCentar.entity.Termin;
import Projekat.FitnesCentar.entity.dto.FitnesCentarDTO;
import Projekat.FitnesCentar.entity.dto.SalaDTO;
import Projekat.FitnesCentar.entity.dto.TerminDTO;
import Projekat.FitnesCentar.entity.dto.TrenerDTO;
import Projekat.FitnesCentar.entity.dto.TreningDTO;
import Projekat.FitnesCentar.service.FitnesCentarService;
import Projekat.FitnesCentar.service.TerminService;
import Projekat.FitnesCentar.service.TrenerService;
import Projekat.FitnesCentar.service.TreningService;




@RestController
@RequestMapping(value = "/api/RegistracijaTrenera")
public class TrenerController {
    private final TrenerService trenerService;
    private final FitnesCentarService fitnesCentarService ;
    final TreningService treningService ;
    private final TerminService terminService ;

    // constructor-based dependency injection
    @Autowired
    public TrenerController(TrenerService trenerService,
    						FitnesCentarService fitnesCentarService,
    						TreningService treningService ,
    						TerminService terminService
    						) {
        this.trenerService = trenerService;
        this.fitnesCentarService= fitnesCentarService;
        this.treningService =treningService;
        this.terminService=terminService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> createTrener(@RequestBody TrenerDTO trenerDTO) throws Exception {//pravljenje trenera
        Trener trener = new Trener(
        		
                trenerDTO.getUsername(),
                trenerDTO.getPassword (),
                trenerDTO.getIme(),
                trenerDTO.getPrezime(),
                trenerDTO.getTelefon (),
                trenerDTO.getEmail (),
                trenerDTO.getDatum(),
                Korisnik.Uloga.TRENER,
                false,
                fitnesCentarService.findById(trenerDTO.getFcid())
        		);

    	List<Trener> sviTreneri= this.trenerService.findAll();
        for (Korisnik k: sviTreneri)if(k.getUsername().equals(trener.getUsername()))return new ResponseEntity<>(new TrenerDTO(), HttpStatus.ALREADY_REPORTED);

        Trener noviTrener = trenerService.create(trener);

        TrenerDTO noviTrenerDTO = new TrenerDTO(
        		noviTrener.getId(),
        		noviTrener.getFitnesCentar().getId(),
                noviTrener.getUsername(),
                noviTrener.getPassword (),
                noviTrener.getIme(),
                noviTrener.getPrezime(),
        		noviTrener.getKontaktTelefon (),
        		noviTrener.getEmail (),
        		noviTrener.getDatumRodjenja (),
        		noviTrener.getUlogaKorisnika(),
        		noviTrener.isAktivan()
        		);

        return new ResponseEntity<>(noviTrenerDTO, HttpStatus.CREATED);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnesCentarDTO>> getFitnesCentari() {//punjenje liste selekt fitnes

    	List<FitnesCentar> listaFitnesCentara = this.fitnesCentarService.findAll();
        List<FitnesCentarDTO> centarDTOS = new ArrayList<>();

        for (FitnesCentar centar: listaFitnesCentara) {
        	
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
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/moji/{id}")
    public ResponseEntity<List<TerminDTO>> getTreninzi(@PathVariable("id") Long trenerId)throws Exception {//listaTermina trenera za update

    	Trener trener= trenerService.findOne(trenerId);
    	Set<Termin> listaTermina = trener.getListaTreninga();
    	List<TerminDTO> terminDTOS = new ArrayList<>();
        for (Termin termin: listaTermina) {
        	
        	TerminDTO terminDTO = new TerminDTO(
        				termin.getId(),
        				termin.getDan(),
        				termin.getCena(),
        				termin.getTrening().getNaziv(),
        				termin.getTrening().getOpis(),
        				termin.getTrening().getTipTreninga(),
        				termin.getTrening().getTrajanje()
        			);
        	terminDTOS.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE,value="/izmena")
	public ResponseEntity<TerminDTO> izmenaTermina(//update termina
	  @Validated @RequestBody TerminDTO terminDTO) throws Exception {
				Termin termin = terminService.findOne(terminDTO.getId());

				termin.setDan(terminDTO.getDan());
				termin.setCena(terminDTO.getCena());
				termin.getTrening().setNaziv(terminDTO.getNaziv());
				termin.getTrening().setOpis(terminDTO.getOpis());
				termin.getTrening().setTipTreninga(terminDTO.getTipTreninga());
				termin.getTrening().setTrajanje(terminDTO.getTrajanje());
				Termin noviTermin = this.terminService.update(termin);
				TerminDTO noviTerminDTO = new TerminDTO(
						noviTermin.getId(),
						noviTermin.getDan(),
						noviTermin.getCena(),
						noviTermin.getTrening().getNaziv(),
						noviTermin.getTrening().getOpis(),
						noviTermin.getTrening().getTipTreninga(),
						noviTermin.getTrening().getTrajanje()
						);
				
				return new ResponseEntity<>(noviTerminDTO, HttpStatus.CREATED);
		}
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/sale/{id}")//sala liste selekt
    public ResponseEntity<List<SalaDTO>> getSale(@PathVariable("id") Long trenerId)throws Exception  {
    	Trener trener= trenerService.findOne(trenerId);
    	Set<Sala> listaSala= trener.getFitnesCentar().getListaSala();
    	List<SalaDTO> salaDTOS = new ArrayList<>();
    	
    	for (Sala sala: listaSala) {
    		
    		SalaDTO salaDTO = new SalaDTO(
    				sala.getId(),
    				sala.getKapacitet(),
    				sala.getOznakaSale()
    				);
    		salaDTOS.add(salaDTO);
    	}
    	return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/treninzi/{id}")//sala liste selekt
    public ResponseEntity<List<TreningDTO>> getVrsteTreninga()throws Exception  {
    	List<Trening> treninzi = treningService.findAll(); 
    	List<TreningDTO> treningDTOS = new ArrayList<>();
    	
    	for (Trening trening: treninzi) {
    		
    		TreningDTO treningDTO = new TreningDTO(
        			trening.getId(),
        			trening.getNaziv(),
        			trening.getOpis(),
        			trening.getTipTreninga(),
        			trening.getTrajanje()
    				);
    		treningDTOS.add(treningDTO);
    	}
    	return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }
/*
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnesCentarDTO>> getFitnesCentari() {//punjenje liste selekt fitnes
    	
    	List<FitnesCentar> listaFitnesCentara = this.fitnesCentarService.findAll();
    	List<FitnesCentarDTO> centarDTOS = new ArrayList<>();
    	
    	for (FitnesCentar centar: listaFitnesCentara) {
    		
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
 * 
    
    --------
	@PosttMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE,value="/pravljenje")
	public ResponseEntity<String> odjavaTermina(
	  @Validated @RequestBody TerminDTO terminDTO) throws Exception {
			
			Trener trener=this.trenerService.findOne(terminDTO.getTrenerId());
			trener.getListaTreninga().add(
				new Termin(
				terminDTO.getDan(), 
				terminDTO.getCena(), 
				trener, 
				this.salaService.findOne(terminDTO.getSalaId()), 
				this.treningService.findById(terminDTO.getTreningId())
				)
					);
		
		return new ResponseEntity<>("", HttpStatus.CREATED);
		}
		*/
}