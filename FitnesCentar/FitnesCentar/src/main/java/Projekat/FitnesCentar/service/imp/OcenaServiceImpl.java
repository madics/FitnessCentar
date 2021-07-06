package Projekat.FitnesCentar.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projekat.FitnesCentar.entity.Ocena;
import Projekat.FitnesCentar.repository.OcenaRepository;
import Projekat.FitnesCentar.service.OcenaService;
@Service
public class OcenaServiceImpl implements OcenaService{

    private final OcenaRepository ocenaRepository;
    // constructor-based dependency injection
    @Autowired
    public OcenaServiceImpl(OcenaRepository ocenaRepository) {
        this.ocenaRepository = ocenaRepository;
    }

	@Override
	public Ocena create(Ocena ocena) throws Exception{
	    if (ocena.getId() != 0) {
	        throw new Exception("ID must be null!");
	    }
	    Ocena noviOcena= this.ocenaRepository.save(ocena);
	    return noviOcena;
	}

}
