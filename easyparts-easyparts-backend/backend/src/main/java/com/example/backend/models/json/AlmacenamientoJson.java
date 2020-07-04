package com.example.backend.models.json;

import com.example.backend.models.Almacenamiento;
import com.example.backend.models.filtros.FiltrosAlmacenamiento;

import java.util.List;

public class AlmacenamientoJson {

    private FiltrosAlmacenamiento filtros;
    private List<Almacenamiento> almacenamientos;

    public AlmacenamientoJson(FiltrosAlmacenamiento filtros, List<Almacenamiento> almacenamientos) {
        this.filtros = filtros;
        this.almacenamientos = almacenamientos;
    }

    public FiltrosAlmacenamiento getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosAlmacenamiento filtros) {
        this.filtros = filtros;
    }

    public List<Almacenamiento> getAlmacenamientos() {
        return almacenamientos;
    }

    public void setAlmacenamientos(List<Almacenamiento> almacenamientos) {
        this.almacenamientos = almacenamientos;
    }
}
