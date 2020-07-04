package com.example.backend.models.json;

import com.example.backend.models.Gabinete;
import com.example.backend.models.filtros.FiltrosGabinete;

import java.util.List;

public class GabineteJson {

    private FiltrosGabinete filtros;
    private List<Gabinete> gabinetes;

    public GabineteJson(FiltrosGabinete filtros, List<Gabinete> gabinetes) {
        this.filtros = filtros;
        this.gabinetes = gabinetes;
    }

    public FiltrosGabinete getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosGabinete filtros) {
        this.filtros = filtros;
    }

    public List<Gabinete> getGabinetes() {
        return gabinetes;
    }

    public void setGabinetes(List<Gabinete> gabinetes) {
        this.gabinetes = gabinetes;
    }
}
