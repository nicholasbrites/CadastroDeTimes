package dev.brites.CadastroDeClubes.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_clubs")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClubModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer titles;
    private String stadium;
    @ManyToOne
    @JoinColumn(name = "id_league")
    private LeagueModel league;

}