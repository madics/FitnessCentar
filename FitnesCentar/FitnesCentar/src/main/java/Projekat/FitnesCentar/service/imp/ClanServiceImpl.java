package Projekat.FitnesCentar.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projekat.FitnesCentar.entity.Clan;
import Projekat.FitnesCentar.repository.ClanRepository;
import Projekat.FitnesCentar.service.ClanService;


	@Service
	public class ClanServiceImpl implements ClanService{

	    private final ClanRepository clanRepository;
	    // constructor-based dependency injection
	    @Autowired
	    public ClanServiceImpl(ClanRepository clanRepository) {
	        this.clanRepository = clanRepository;
	    }

	  
	@Override
	public Clan create(Clan clan) throws Exception {
	    if (clan.getId() != null) {
	        throw new Exception("ID must be null!");
	    }
	    Clan noviClan= this.clanRepository.save(clan);
	    return noviClan;
	}

	}
