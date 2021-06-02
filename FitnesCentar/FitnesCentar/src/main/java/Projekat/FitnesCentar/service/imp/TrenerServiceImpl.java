package Projekat.FitnesCentar.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projekat.FitnesCentar.entity.Trener;
import Projekat.FitnesCentar.repository.TrenerRepository;
import Projekat.FitnesCentar.service.TrenerService;


	@Service
	public class TrenerServiceImpl implements TrenerService{

	    private final TrenerRepository trenerRepository;
	    // constructor-based dependency injection
	    @Autowired
	    public TrenerServiceImpl(TrenerRepository trenerRepository) {
	        this.trenerRepository = trenerRepository;
	    }

	  
	@Override
	public Trener create(Trener trener) throws Exception {
	    if (trener.getId() != null) {
	        throw new Exception("ID must be null!");
	    }
	    Trener noviTrener= this.trenerRepository.save(trener);
	    return noviTrener;
	}

	}