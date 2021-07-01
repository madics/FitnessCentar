package Projekat.FitnesCentar.service;

import java.util.List;

import Projekat.FitnesCentar.entity.Trening;

public interface TreningService {

	Trening findById(long id);
    List<Trening> findAll() ;

}
