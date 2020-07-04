package com.example.backend.services.filters;

import com.example.backend.models.MotherBoard;
import com.example.backend.models.filtros.FiltrosMotherBoard;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MotherBoardFilterImpl {

    public FiltrosMotherBoard crearListaFiltros(List<MotherBoard> completos) {

        List<String> marca = new ArrayList<>();
        List<String> categoria = new ArrayList<>();
        List<String> slot_ram = new ArrayList<>();
        List<Float> slot_gpu = new ArrayList<>();

        for (MotherBoard m: completos) {
            if (!marca.contains(m.getMarca())) {
                marca.add(m.getMarca());
            }
            if (!categoria.contains(m.getCategoria())) {
                categoria.add(m.getCategoria());
            }
            if (!slot_ram.contains(m.getSlot_ram())) {
                slot_ram.add(m.getSlot_ram());
            }
            if (!slot_gpu.contains(m.getSlot_gpu())) {
                slot_gpu.add(m.getSlot_gpu());
            }
        }

        Collections.sort(marca);
        Collections.sort(categoria);
        Collections.sort(slot_ram);
        Collections.sort(slot_gpu);

        FiltrosMotherBoard criterios = new FiltrosMotherBoard(marca,categoria,slot_ram,slot_gpu);

        return  criterios;
    }
}
