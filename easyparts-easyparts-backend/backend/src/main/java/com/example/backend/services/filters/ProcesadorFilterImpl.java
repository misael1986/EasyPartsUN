package com.example.backend.services.filters;


import com.example.backend.models.Procesador;
import com.example.backend.models.filtros.FiltrosProcesador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcesadorFilterImpl {

    public FiltrosProcesador crearListaFiltros(List<Procesador> completos) {

        List<String> marca = new ArrayList<>();
        List<String> socket = new ArrayList<>();
        List<String> nucleos = new ArrayList<>();
        List<String> frecuencia = new ArrayList<>();
        List<String> grafica = new ArrayList<>();

        for (Procesador p : completos) {
            if (!marca.contains(p.getMarca())) {
                marca.add(p.getMarca());
            }
            if (!socket.contains(p.getPsocket())) {
                socket.add(p.getPsocket());
            }
            if (!nucleos.contains(p.getNum_nucleos())) {
                nucleos.add(p.getNum_nucleos());
            }
            if (!frecuencia.contains(p.getFrecuencia())) {
                frecuencia.add(p.getFrecuencia());
            }
            if (!grafica.contains(p.getGrafica_integrada())) {
                grafica.add(p.getGrafica_integrada());
            }

        }
        Collections.sort(marca);
        Collections.sort(socket);
        Collections.sort(nucleos);
        Collections.sort(frecuencia);
        Collections.sort(grafica);

        FiltrosProcesador criterios = new FiltrosProcesador(marca, socket, nucleos, frecuencia, grafica);

        return criterios;
    }
}
