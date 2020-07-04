package com.example.backend.services.impl;

import com.example.backend.commons.GenericServiceImp;
import com.example.backend.dao.MotherBoardDaoAPI;
import com.example.backend.models.MotherBoard;
import com.example.backend.models.filtros.FiltrosMotherBoard;
import com.example.backend.models.json.MotherBoardJson;
import com.example.backend.services.MotherBoardServiceAPI;
import com.example.backend.services.filters.MotherBoardFilterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotherBoardServiceImp extends GenericServiceImp<MotherBoard, Long> implements MotherBoardServiceAPI {

    @Autowired
    private MotherBoardDaoAPI motherBoardDaoAPI;

    @Override
    public JpaRepository<MotherBoard, Long> getDao() {
        return motherBoardDaoAPI;
    }

    @Override
    public MotherBoardJson listaCompleta(List<MotherBoard> completa) {

        MotherBoardFilterImpl boardFilter = new MotherBoardFilterImpl();
        FiltrosMotherBoard filtro = boardFilter.crearListaFiltros(completa);
        MotherBoardJson boardJson = new MotherBoardJson(filtro, completa);
        return boardJson;

    }

    @Override
    public List<MotherBoard> getSocket(List<MotherBoard> completa, String ranura_socket) {

        List<MotherBoard> socket = completa.stream().filter(m -> m.getMsocket().equals(ranura_socket)).collect(Collectors.toList());
        return socket;
    }

    @Override
    public List<MotherBoard> getMarca(List<MotherBoard> completa, String marca) {

        List<MotherBoard> boardmarca = completa.stream().filter(m -> m.getMarca().equals(marca)).collect(Collectors.toList());
        return boardmarca;
    }

    @Override
    public List<MotherBoard> getCategoria(List<MotherBoard> completa, String categoria) {

        List<MotherBoard> boardcategoria = completa.stream().filter(m -> m.getCategoria().equals(categoria)).collect(Collectors.toList());
        return boardcategoria;
    }

    @Override
    public List<MotherBoard> getSlotRam(List<MotherBoard> completa, String slotram) {

        List<MotherBoard> boardslotram = completa.stream().filter(m -> m.getSlot_ram().equals(slotram)).collect(Collectors.toList());
        return boardslotram;
    }

    @Override
    public List<MotherBoard> getSlotGPU(List<MotherBoard> completa, Float slotgpu) {

        List<MotherBoard> boardslotgpu = completa.stream().filter(m -> m.getSlot_gpu() <= slotgpu).collect(Collectors.toList());
        return boardslotgpu;
    }

}
