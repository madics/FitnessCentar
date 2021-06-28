package Projekat.FitnesCentar.service;

import Projekat.FitnesCentar.entity.Clan;

public interface ClanService {

    Clan create(Clan clan) throws Exception;

	Clan findOne(Long clanId) throws Exception;

	Clan update(Clan clan);
}
