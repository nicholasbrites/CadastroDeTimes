package dev.brites.CadastroDeClubes.infrastructure.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "O nome do clube deve ser obrigatório.")
    private String name;
    @NotNull(message = "A quantidade de títulos é obrigatória.")
    private Integer titles;
    @NotBlank(message = "O nome do estádio deve ser obrigatório.")
    private String stadium;
    @NotNull(message = "É obrigatório o clube ser associado a uma liga.")
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_league")
    private LeagueModel league;

}