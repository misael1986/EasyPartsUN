package com.example.backend.services.filters;

import com.example.backend.models.Gabinete;
import com.example.backend.models.filtros.FiltrosGabinete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GabineteFilterImpl {

    public FiltrosGabinete crearListaFiltros(List<Gabinete> completos) {

        List<String> marca = new ArrayList<>();
        List<String> motherboards = new ArrayList<>();

        for (Gabinete g : completos) {

            if (!marca.contains(g.getMarca())) {
                marca.add(g.getMarca());
            }

            String [] boards = g.getMotherboards().split(",");
            for (int i = 0; i < boards.length; i++){
                if (!motherboards.contains(boards[i])) {
                    motherboards.add(boards[i]);
                }
            }
        }
        Collections.sort(marca);
        Collections.sort(motherboards);

        FiltrosGabinete criterios = new FiltrosGabinete(marca, motherboards);

        return criterios;
    }
}
