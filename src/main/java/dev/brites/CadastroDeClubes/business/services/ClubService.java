package dev.brites.CadastroDeClubes.business.services;

import dev.brites.CadastroDeClubes.infrastructure.entities.ClubModel;
import dev.brites.CadastroDeClubes.infrastructure.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ClubModel findClubById(Long id){
        return clubRepository.findById(id).orElseThrow(() -> new RuntimeException("Clube não encontrado no banco de dados."));
    }

    public ClubModel findClubByName(String name){
        return clubRepository.findClubByName(name).orElseThrow(() -> new RuntimeException("Clube não encontrado no banco de dados."));
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
        clubRepository.deleteClubByName(name);
    }
}
