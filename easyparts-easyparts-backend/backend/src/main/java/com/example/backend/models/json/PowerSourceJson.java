package com.example.backend.models.json;

import com.example.backend.models.PowerSource;
import com.example.backend.models.filtros.FiltrosPowerSource;

import java.util.List;

public class PowerSourceJson {

    private FiltrosPowerSource filtros;
    private List<PowerSource> powerSources;

    public PowerSourceJson(FiltrosPowerSource filtros, List<PowerSource> powerSources) {
        this.filtros = filtros;
        this.powerSources = powerSources;
    }

    public FiltrosPowerSource getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosPowerSource filtros) {
        this.filtros = filtros;
    }

    public List<PowerSource> getPowerSources() {
        return powerSources;
    }

    public void setPowerSources(List<PowerSource> powerSources) {
        this.powerSources = powerSources;
    }
}
