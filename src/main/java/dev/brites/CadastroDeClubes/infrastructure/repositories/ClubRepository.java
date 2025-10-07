package dev.brites.CadastroDeClubes.infrastructure.repositories;

import dev.brites.CadastroDeClubes.infrastructure.entities.ClubModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<ClubModel, Integer> {
}
