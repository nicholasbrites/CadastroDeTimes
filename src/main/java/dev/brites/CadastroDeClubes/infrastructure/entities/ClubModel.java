package dev.brites.CadastroDeClubes.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_clubs")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClubModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer titles;
    private String stadium;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueModel league;

}