package com.example.backend.models.json;

import com.example.backend.models.TarjetaVideo;
import com.example.backend.models.filtros.FiltrosTarjetaVideo;

import java.util.List;

public class TarjetaVideoJson {

    private FiltrosTarjetaVideo filtros;
    private List<TarjetaVideo> graficas;

    public TarjetaVideoJson(FiltrosTarjetaVideo filtros, List<TarjetaVideo> graficas) {
        this.filtros = filtros;
        this.graficas = graficas;
    }

    public FiltrosTarjetaVideo getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosTarjetaVideo filtros) {
        this.filtros = filtros;
    }

    public List<TarjetaVideo> getGraficas() {
        return graficas;
    }

    public void setGraficas(List<TarjetaVideo> graficas) {
        this.graficas = graficas;
    }
}
