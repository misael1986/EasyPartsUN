package com.example.backend.models.filtros;

import java.util.List;

public class FiltrosTarjetaVideo {

    private List<String> marca;
    private List<String> tipo_memoria;
    private List<Integer> capacidad_memoria;
    private List<String> proposito;

    public FiltrosTarjetaVideo(List<String> marca, List<String> tipo_memoria, List<Integer> capacidad_memoria, List<String> proposito) {
        this.marca = marca;
        this.tipo_memoria = tipo_memoria;
        this.capacidad_memoria = capacidad_memoria;
        this.proposito = proposito;
    }

    public List<String> getMarca() {
        return marca;
    }

    public void setMarca(List<String> marca) {
        this.marca = marca;
    }

    public List<String> getTipo_memoria() {
        return tipo_memoria;
    }

    public void setTipo_memoria(List<String> tipo_memoria) {
        this.tipo_memoria = tipo_memoria;
    }

    public List<Integer> getCapacidad_memoria() {
        return capacidad_memoria;
    }

    public void setCapacidad_memoria(List<Integer> capacidad_memoria) {
        this.capacidad_memoria = capacidad_memoria;
    }

    public List<String> getProposito() {
        return proposito;
    }

    public void setProposito(List<String> proposito) {
        this.proposito = proposito;
    }
}
