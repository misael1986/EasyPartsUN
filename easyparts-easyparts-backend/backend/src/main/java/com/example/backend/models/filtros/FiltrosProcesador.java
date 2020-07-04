package com.example.backend.models.filtros;

import java.util.List;

public class FiltrosProcesador {

    private List<String> marca;
    private List<String> socket;
    private List<String> nucleos;
    private List<String> frecuencia_nucleo;
    private List<String> grafica;

    public FiltrosProcesador(List<String> marca, List<String> socket, List<String> nucleos, List<String> frecuencia_nucleo, List<String> grafica) {
        this.marca = marca;
        this.socket = socket;
        this.nucleos = nucleos;
        this.frecuencia_nucleo = frecuencia_nucleo;
        this.grafica = grafica;
    }

    public List<String> getMarca() {
        return marca;
    }

    public void setMarca(List<String> marca) {
        this.marca = marca;
    }

    public List<String> getSocket() {
        return socket;
    }

    public void setSocket(List<String> socket) {
        this.socket = socket;
    }

    public List<String> getNucleos() {
        return nucleos;
    }

    public void setNucleos(List<String> nucleos) {
        this.nucleos = nucleos;
    }

    public List<String> getFrecuencia_nucleo() {
        return frecuencia_nucleo;
    }

    public void setFrecuencia_nucleo(List<String> frecuencia_nucleo) {
        this.frecuencia_nucleo = frecuencia_nucleo;
    }

    public List<String> getGrafica() {
        return grafica;
    }

    public void setGrafica(List<String> grafica) {
        this.grafica = grafica;
    }
}
