package com.example.backend.models.filtros;

import java.util.List;

public class FiltrosPowerSource {

    private List<String> marca;
    private List<Long> potencia;
    private List<String> certificacion;

    public FiltrosPowerSource(List<String> marca, List<Long> potencia, List<String> certificacion) {
        this.marca = marca;
        this.potencia = potencia;
        this.certificacion = certificacion;
    }

    public List<String> getMarca() {
        return marca;
    }

    public void setMarca(List<String> marca) {
        this.marca = marca;
    }

    public List<Long> getPotencia() {
        return potencia;
    }

    public void setPotencia(List<Long> potencia) {
        this.potencia = potencia;
    }

    public List<String> getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(List<String> certificacion) {
        this.certificacion = certificacion;
    }
}
