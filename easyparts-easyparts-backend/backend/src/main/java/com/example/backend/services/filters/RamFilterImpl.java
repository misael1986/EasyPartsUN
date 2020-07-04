package com.example.backend.services.filters;

import com.example.backend.models.Ram;
import com.example.backend.models.filtros.FiltrosRam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RamFilterImpl {
    public FiltrosRam crearListaFiltros(List<Ram> completos) {

        List<String> marca = new ArrayList<>();
        List<String> capacidad = new ArrayList<>();

        for (Ram r : completos) {
            if (!marca.contains(r.getMarca())) {
                marca.add(r.getMarca());
            }
            if (!capacidad.contains(r.getCapacidad())) {
                capacidad.add(r.getCapacidad());
            }

        }
        Collections.sort(marca);
        Collections.sort(capacidad);

        FiltrosRam criterios = new FiltrosRam(marca, capacidad);

        return criterios;
    }
}
