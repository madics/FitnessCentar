package Projekat.FitnesCentar.service;

import java.util.List;

import Projekat.FitnesCentar.entity.Termin;

public interface TerminService {
     List<Termin> findAll() ;
 	Termin findOne(Long terminId)throws Exception ;
	Termin update(Termin termin);

}
