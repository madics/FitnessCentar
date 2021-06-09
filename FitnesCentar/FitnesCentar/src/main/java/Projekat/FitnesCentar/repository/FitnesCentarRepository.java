package Projekat.FitnesCentar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Projekat.FitnesCentar.entity.FitnesCentar;

public interface FitnesCentarRepository extends JpaRepository<FitnesCentar, Long> {
	FitnesCentar findById(long id);	

}
