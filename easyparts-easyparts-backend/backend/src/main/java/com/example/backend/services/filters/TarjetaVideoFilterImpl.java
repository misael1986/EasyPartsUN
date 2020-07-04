package com.example.backend.services.filters;

import com.example.backend.models.TarjetaVideo;
import com.example.backend.models.filtros.FiltrosTarjetaVideo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TarjetaVideoFilterImpl {

    public FiltrosTarjetaVideo crearListaFiltros(List<TarjetaVideo> completos) {

        List<String> marca = new ArrayList<>();
        List<String> tipomemoria = new ArrayList<>();
        List<Integer> capacidadmemoria = new ArrayList<>();
        List<String> proposito = new ArrayList<>();


        for (TarjetaVideo g : completos) {
            if (!marca.contains(g.getMarca())) {
                marca.add(g.getMarca());
            }
            if (!tipomemoria.contains(g.getTipo_memoria())) {
                tipomemoria.add(g.getTipo_memoria());
            }
            if (!capacidadmemoria.contains(g.getCapacidad_memoria())) {
                capacidadmemoria.add(g.getCapacidad_memoria());
            }
            if (!proposito.contains(g.getProposito())) {
                proposito.add(g.getProposito());
            }


        }
        Collections.sort(marca);
        Collections.sort(tipomemoria);
        Collections.sort(capacidadmemoria);
        Collections.sort(proposito);


        FiltrosTarjetaVideo criterios = new FiltrosTarjetaVideo(marca, tipomemoria, capacidadmemoria, proposito);

        return criterios;
    }
}
