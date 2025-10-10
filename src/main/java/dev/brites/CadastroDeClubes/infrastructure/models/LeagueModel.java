package dev.brites.CadastroDeClubes.infrastructure.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_leagues")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LeagueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome da liga é obrigatório.")
    private String name;
    @NotBlank(message = "O país da liga é obrigatório")
    private String country;
    @OneToMany(mappedBy = "league")
    @JsonManagedReference
    private List<ClubModel> clubs;

}
