package dev.brites.CadastroDeClubes.business.services;

import dev.brites.CadastroDeClubes.business.exceptions.LeagueNotFoundExeception;
import dev.brites.CadastroDeClubes.infrastructure.models.LeagueModel;
import dev.brites.CadastroDeClubes.infrastructure.repositories.LeagueRepository;
import org.springframework.stereotype.Service;

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

    public List<LeagueModel> findAllLeagues(){
        return leagueRepository.findAll();
    }

    public LeagueModel findLeagueById(Long id){
        return leagueRepository.findById(id)
                .orElseThrow(() -> new LeagueNotFoundExeception("Liga com id " + id + " não encontrada."));
    }

    public LeagueModel findLeagueByName(String name){
        return leagueRepository.findLeagueByName(name)
                .orElseThrow(() -> new LeagueNotFoundExeception("Não foi encontrada a liga com o nome " + name + "."));
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
