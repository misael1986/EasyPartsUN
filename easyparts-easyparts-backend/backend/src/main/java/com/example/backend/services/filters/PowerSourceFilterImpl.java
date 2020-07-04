package com.example.backend.services.filters;

import com.example.backend.models.PowerSource;
import com.example.backend.models.filtros.FiltrosPowerSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSourceFilterImpl {

    public FiltrosPowerSource crearListaFiltros(List<PowerSource> completos) {

        List<String> marca = new ArrayList<>();
        List<Long> potencia = new ArrayList<>();
        List<String> certificacion = new ArrayList<>();

        for (PowerSource p : completos) {
            if (!marca.contains(p.getMarca())) {
                marca.add(p.getMarca());
            }
            if (!potencia.contains(p.getPotencia())) {
                potencia.add(p.getPotencia());
            }
            if (!certificacion.contains(p.getCertificacion())) {
                certificacion.add(p.getCertificacion());
            }
        }
        Collections.sort(marca);
        Collections.sort(potencia);
        Collections.sort(certificacion);

        FiltrosPowerSource criterios = new FiltrosPowerSource(marca, potencia, certificacion);

        return criterios;
    }
}
