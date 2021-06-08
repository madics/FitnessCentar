package Projekat.FitnesCentar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Projekat.FitnesCentar.entity.Termin;

public interface TerminRepository extends JpaRepository<Termin, Long>, CrudRepository<Termin, Long> {

}
