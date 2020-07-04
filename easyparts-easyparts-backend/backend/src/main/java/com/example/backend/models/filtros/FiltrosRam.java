package com.example.backend.models.filtros;

import java.util.List;

public class FiltrosRam {

    private List<String> marca;
    private List<String> capacidad;

    public FiltrosRam(List<String> marca, List<String> capacidad) {
        this.marca = marca;
        this.capacidad = capacidad;
    }

    public List<String> getMarca() {
        return marca;
    }

    public void setMarca(List<String> marca) {
        this.marca = marca;
    }

    public List<String> getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(List<String> capacidad) {
        this.capacidad = capacidad;
    }

}
