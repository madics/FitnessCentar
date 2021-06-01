package Projekat.FitnesCentar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Projekat.FitnesCentar.entity.Trening;

public interface TreningRepository extends JpaRepository<Trening, Long> {

	Trening findById(long id);	
}
	