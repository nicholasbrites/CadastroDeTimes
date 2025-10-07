package dev.brites.CadastroDeClubes.infrastructure.repositories;

import dev.brites.CadastroDeClubes.infrastructure.entities.ClubModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<ClubModel, Long> {

    Optional<ClubModel> findClubByName(String name);

    @Transactional
    void deleteClubByName(String name);
}
