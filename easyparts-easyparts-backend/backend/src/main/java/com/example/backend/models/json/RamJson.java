package com.example.backend.models.json;

import com.example.backend.models.Ram;
import com.example.backend.models.filtros.FiltrosRam;

import java.util.List;

public class RamJson {

    private FiltrosRam filtros;
    private List<Ram> rams;

    public RamJson(FiltrosRam filtros, List<Ram> rams) {
        this.filtros = filtros;
        this.rams = rams;
    }

    public FiltrosRam getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosRam filtros) {
        this.filtros = filtros;
    }

    public List<Ram> getRams() {
        return rams;
    }

    public void setRams(List<Ram> rams) {
        this.rams = rams;
    }
}
