package dev.brites.CadastroDeClubes.business.services;

import dev.brites.CadastroDeClubes.infrastructure.entities.ClubModel;
import dev.brites.CadastroDeClubes.infrastructure.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public void saveClub(ClubModel clubModel){
        clubRepository.saveAndFlush(clubModel);
    }

}
