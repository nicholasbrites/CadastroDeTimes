package dev.brites.CadastroDeClubes.Ligas.models;

import dev.brites.CadastroDeClubes.Clubes.models.ClubeModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_ligas")
public class LigaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nacionalidade;
    @OneToMany(mappedBy = "ligas")
    private List<ClubeModel> clubes;

    public LigaModel() {
    }

    public LigaModel(String name, String nacionalidade) {
        this.name = name;
        this.nacionalidade = nacionalidade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
