package dev.brites.CadastroDeClubes.Clubes.models;

import dev.brites.CadastroDeClubes.Ligas.models.LigaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_clubes")
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

    public ClubeModel() {
    }

    public ClubeModel(String name, Integer titulos, String estadio) {
        this.name = name;
        this.titulos = titulos;
        this.estadio = estadio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTitulos() {
        return titulos;
    }

    public void setTitulos(Integer titulos) {
        this.titulos = titulos;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
}
