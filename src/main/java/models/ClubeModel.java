package models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_clubes")
public class ClubeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer titulos;
    private String estado;

    public ClubeModel() {
    }

    public ClubeModel(String name, Integer titulos, String estado) {
        this.name = name;
        this.titulos = titulos;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
