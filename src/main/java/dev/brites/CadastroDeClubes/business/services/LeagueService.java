package dev.brites.CadastroDeClubes.business.services;

import dev.brites.CadastroDeClubes.infrastructure.entities.LeagueModel;
import dev.brites.CadastroDeClubes.infrastructure.repositories.LeagueRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public void saveLeague(LeagueModel leagueModel){
        leagueRepository.saveAndFlush(leagueModel);
    }

    public void saveAllLeagues(List<LeagueModel> leagueModelList){
        leagueRepository.saveAllAndFlush(leagueModelList);
    }

    public LeagueModel findLeagueById(Long id){
        return leagueRepository.findById(id).orElseThrow(() -> new RuntimeException("Liga não encontrada no banco de dados."));
    }

    public LeagueModel findLeagueByName(String name){
        return leagueRepository.findLeagueByName(name).orElseThrow(() -> new RuntimeException("Liga não encontrada no banco de dados."));
    }

    public void updateLeagueById(LeagueModel leagueModel, Long id){
        LeagueModel leagueUpdated = findLeagueById(id);

        Optional.ofNullable(leagueModel.getName()).ifPresent(leagueUpdated::setName);
        Optional.ofNullable(leagueModel.getCountry()).ifPresent(leagueUpdated::setCountry);
        Optional.ofNullable(leagueModel.getClubs()).ifPresent(leagueUpdated::setClubs);

        leagueRepository.saveAndFlush(leagueUpdated);
    }

    public void deleteLeagueByName(String name){
        leagueRepository.deleteLeagueByName(name);
    }

}
