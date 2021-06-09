package Projekat.FitnesCentar.service;

import java.util.List;

import Projekat.FitnesCentar.entity.FitnesCentar;
public interface FitnesCentarService {

    List<FitnesCentar> findAll() ;

	FitnesCentar findById(long id);

}
