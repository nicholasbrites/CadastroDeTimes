package dev.brites.CadastroDeClubes.Ligas.models;

import dev.brites.CadastroDeClubes.Clubes.models.ClubeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_ligas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LigaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nacionalidade;
    @OneToMany(mappedBy = "ligas")
    private List<ClubeModel> clubes;

}
