package Projekat.FitnesCentar.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projekat.FitnesCentar.entity.Termin;
import Projekat.FitnesCentar.repository.TerminRepository;
import Projekat.FitnesCentar.service.TerminService;


@Service
public class TerminServiceImpl implements TerminService {

    private final TerminRepository terminRepository;

    @Autowired
    public TerminServiceImpl(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }
    @Override
   public List<Termin> findAll() {
        List<Termin> Termini = this.terminRepository.findAll();
        return Termini;

	}
	@Override
	public Termin findOne(Long terminId) throws Exception {
		Termin termin = this.terminRepository.getOne(terminId);
		return termin;
	}

	@Override
	public Termin update(Termin termin) {
        //termin.setAktivan(true);
        Termin noviTermin =this.terminRepository.save(termin);
        return noviTermin;
	}
	@Override
	public Termin create(Termin termin) throws Exception {
	    if (termin.getId() != 0) {
	        throw new Exception("ID must be null!");
	    }
	    Termin noviTermin= this.terminRepository.save(termin);
	    return noviTermin;
	}




}
