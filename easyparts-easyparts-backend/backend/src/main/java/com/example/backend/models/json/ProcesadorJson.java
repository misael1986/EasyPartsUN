package com.example.backend.models.json;

import com.example.backend.models.Procesador;
import com.example.backend.models.filtros.FiltrosProcesador;

import java.util.List;

public class ProcesadorJson {

    private FiltrosProcesador filtros;
    private List<Procesador> procesadores;

    public ProcesadorJson(FiltrosProcesador filtros, List<Procesador> procesadores) {
        this.filtros = filtros;
        this.procesadores = procesadores;
    }

    public FiltrosProcesador getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosProcesador filtros) {
        this.filtros = filtros;
    }

    public List<Procesador> getProcesadores() {
        return procesadores;
    }

    public void setProcesadores(List<Procesador> procesadores) {
        this.procesadores = procesadores;
    }
}
