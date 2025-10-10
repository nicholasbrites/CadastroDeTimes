package dev.brites.CadastroDeClubes.business.services;

import dev.brites.CadastroDeClubes.business.exceptions.ClubNotFoundException;
import dev.brites.CadastroDeClubes.infrastructure.models.ClubModel;
import dev.brites.CadastroDeClubes.infrastructure.repositories.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public void saveClub(ClubModel clubModel){
        clubRepository.saveAndFlush(clubModel);
    }

    public void saveAllClubs(List<ClubModel> clubModelList){
        clubRepository.saveAllAndFlush(clubModelList);
    }

    public List<ClubModel> findAllClubs(){
        return clubRepository.findAll();
    }

    public ClubModel findClubById(Long id){
        return clubRepository.findById(id)
                .orElseThrow(() -> new ClubNotFoundException("Clube com id " + id + " não encontrado."));
    }

    public ClubModel findClubByName(String name){
        return clubRepository.findClubByName(name)
                .orElseThrow(() -> new ClubNotFoundException("Não foi encontrado o clube com nome " + name + "."));
    }

    public void updateClubById(Long id, ClubModel clubModel){
        ClubModel clubUpdated = findClubById(id);

        Optional.ofNullable(clubModel.getName()).ifPresent(clubUpdated::setName);
        Optional.ofNullable(clubModel.getTitles()).ifPresent(clubUpdated::setTitles);
        Optional.ofNullable(clubModel.getStadium()).ifPresent(clubUpdated::setStadium);
        Optional.ofNullable(clubModel.getLeague()).ifPresent(clubUpdated::setLeague);

        clubRepository.saveAndFlush(clubUpdated);
    }

    public void deleteClubByName(String name){
        ClubModel clubDeleted = findClubByName(name);
        clubRepository.deleteClubByName(clubDeleted.getName());
    }
}
