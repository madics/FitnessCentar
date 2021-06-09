package Projekat.FitnesCentar.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projekat.FitnesCentar.entity.FitnesCentar;
import Projekat.FitnesCentar.repository.FitnesCentarRepository;
import Projekat.FitnesCentar.service.FitnesCentarService;


@Service
public class FitnesCentarServiceImpl implements FitnesCentarService {

    private final FitnesCentarRepository fitnesCentarRepository;

    @Autowired
    public FitnesCentarServiceImpl(FitnesCentarRepository fitnesCentarRepository) {
        this.fitnesCentarRepository = fitnesCentarRepository;
    }

   public List<FitnesCentar> findAll() {
        List<FitnesCentar> FitnesCentari = this.fitnesCentarRepository.findAll();
        return FitnesCentari;

	}

   @Override
   public FitnesCentar findById(long id) {
        FitnesCentar fitnesCentar = this.fitnesCentarRepository.findById(id);
        return fitnesCentar;

	}
	
	public FitnesCentar create(FitnesCentar fitnesCentar) throws Exception {
	    if (fitnesCentar.getId()!=0) {
	        throw new Exception("ID must be null!");
	    }
	    FitnesCentar noviFitnesCentar= this.fitnesCentarRepository.save(fitnesCentar);
	    return noviFitnesCentar;
		}

}
