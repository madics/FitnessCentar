package Projekat.FitnesCentar.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projekat.FitnesCentar.entity.Trening;
import Projekat.FitnesCentar.repository.TreningRepository;
import Projekat.FitnesCentar.service.TreningService;
@Service
public class TreningServiceImpl implements TreningService{


    private final TreningRepository treningRepository;

    @Autowired
    public TreningServiceImpl(TreningRepository treningRepository) {
        this.treningRepository = treningRepository;
    }

   public Trening findById(long id) {
        Trening trening = this.treningRepository.findById(id);
        return trening;

	}

}
