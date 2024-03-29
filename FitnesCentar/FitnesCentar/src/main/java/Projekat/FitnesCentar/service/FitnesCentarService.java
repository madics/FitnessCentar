package Projekat.FitnesCentar.service;

import java.util.List;

import Projekat.FitnesCentar.entity.FitnesCentar;
public interface FitnesCentarService {

    List<FitnesCentar> findAll() ;

	FitnesCentar findById(long id);

	FitnesCentar create(FitnesCentar fitnesCentar)throws Exception;

	void delete(Long id);


	FitnesCentar update(FitnesCentar fitnesCentar);
}