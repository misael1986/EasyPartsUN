package com.example.backend.services.filters;

import com.example.backend.models.Almacenamiento;
import com.example.backend.models.filtros.FiltrosAlmacenamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlmacenamientoFilterImpl {

    public FiltrosAlmacenamiento crearListaFiltros(List<Almacenamiento> completos) {

        List<String> marca = new ArrayList<>();
        List<String> capacidad = new ArrayList<>();
        List<String> tecnologia = new ArrayList<>();
        List<String> puerto = new ArrayList<>();

        for (Almacenamiento a : completos) {
            if (!marca.contains(a.getMarca())) {
                marca.add(a.getMarca());
            }
            if (!capacidad.contains(a.getCapacidad())) {
                capacidad.add(a.getCapacidad());
            }
            if (!tecnologia.contains(a.getTecnologia())) {
                tecnologia.add(a.getTecnologia());
            }
            if (!puerto.contains(a.getPuerto())) {
                puerto.add(a.getPuerto());
            }
        }
        Collections.sort(marca);
        Collections.sort(capacidad);
        Collections.sort(tecnologia);
        Collections.sort(puerto);

        FiltrosAlmacenamiento criterios = new FiltrosAlmacenamiento(marca, capacidad, tecnologia, puerto);

        return criterios;
    }
}
