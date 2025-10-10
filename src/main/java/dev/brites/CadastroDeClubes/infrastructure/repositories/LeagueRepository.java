package dev.brites.CadastroDeClubes.infrastructure.repositories;

import dev.brites.CadastroDeClubes.infrastructure.models.LeagueModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<LeagueModel, Long> {

    Optional<LeagueModel> findLeagueByName(String name);

    @Transactional
    void deleteLeagueByName(String name);

}
