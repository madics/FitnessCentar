package Projekat.FitnesCentar.service;

import java.util.List;

import Projekat.FitnesCentar.entity.Ocena;

public interface OcenaService {

	Ocena create(Ocena ocena) throws Exception;

	List<Ocena> findAll();

}
