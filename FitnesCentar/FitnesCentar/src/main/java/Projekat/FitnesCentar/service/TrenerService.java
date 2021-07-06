package Projekat.FitnesCentar.service;

import java.util.List;

import Projekat.FitnesCentar.entity.Trener;

public interface TrenerService {

    Trener create(Trener trener) throws Exception;

	List<Trener> findAll();

	Trener findOne(Long trenerId)throws Exception ;

	Trener update(Trener trener);
	/*
*/

	void delete(Long id);



}
