package dev.brites.CadastroDeClubes.Clubes.models;

import dev.brites.CadastroDeClubes.Ligas.models.LigaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_clubes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClubeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer titulos;
    private String estadio;
    @ManyToOne
    @JoinColumn(name = "liga_id")
    private LigaModel liga;

}