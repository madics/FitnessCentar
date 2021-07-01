package Projekat.FitnesCentar.service;

import java.util.List;
import Projekat.FitnesCentar.entity.Sala;

public interface SalaService {

    Sala create(Sala sala) throws Exception;

	List<Sala> findAll();

	Sala findOne(Long salaId)throws Exception ;

	Sala update(Sala sala);
	/*
*/


}
