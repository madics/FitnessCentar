package Projekat.FitnesCentar.service.imp;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projekat.FitnesCentar.entity.Sala;
import Projekat.FitnesCentar.repository.SalaRepository;
import Projekat.FitnesCentar.service.SalaService;


	@Service
	public class SalaServiceImpl implements SalaService{

	    private final SalaRepository salaRepository;
	    // constructor-based dependency injection
	    @Autowired
	    public SalaServiceImpl(SalaRepository salaRepository) {
	        this.salaRepository = salaRepository;
	    }

	  
	@Override
	public Sala create(Sala sala) throws Exception {
	    if (sala.getId() != 0) {
	        throw new Exception("ID must be null!");
	    }
	    Sala noviSala= this.salaRepository.save(sala);
	    return noviSala;
	}


	@Override
	public List<Sala> findAll() {
        List<Sala> Salai = this.salaRepository.findAll();
        return Salai;
	}


	@Override
	public Sala findOne(Long salaId) throws Exception  {
        Sala salai = this.salaRepository.getOne(salaId);
        return salai;
	}

	@Override
	public Sala update(Sala sala) {
        Sala noviSala =this.salaRepository.save(sala);
        return noviSala;
	}
	/*
	*/



	}
	
	
	
	
	