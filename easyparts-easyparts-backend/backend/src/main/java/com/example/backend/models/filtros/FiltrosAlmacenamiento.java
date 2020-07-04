package com.example.backend.models.filtros;

import java.util.List;

public class FiltrosAlmacenamiento {

    private List<String> marca;
    private List<String> capacidad;
    private List<String> tecnologia;
    private List<String> puerto;

    public FiltrosAlmacenamiento(List<String> marca, List<String> capacidad, List<String> tecnologia, List<String> puerto) {
        this.marca = marca;
        this.capacidad = capacidad;
        this.tecnologia = tecnologia;
        this.puerto = puerto;
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

    public List<String> getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(List<String> tecnologia) {
        this.tecnologia = tecnologia;
    }

    public List<String> getPuerto() {
        return puerto;
    }

    public void setPuerto(List<String> puerto) {
        this.puerto = puerto;
    }
}
