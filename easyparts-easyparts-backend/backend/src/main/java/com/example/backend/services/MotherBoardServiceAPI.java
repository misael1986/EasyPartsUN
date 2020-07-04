package com.example.backend.services;

import com.example.backend.commons.GenericServiveAPI;
import com.example.backend.models.MotherBoard;
import com.example.backend.models.json.MotherBoardJson;

import java.util.List;

public interface MotherBoardServiceAPI extends GenericServiveAPI<MotherBoard, Long> {

    MotherBoardJson listaCompleta(List<MotherBoard> completa);

    List<MotherBoard> getSocket(List<MotherBoard> completaboard, String ranura_socket);

    List<MotherBoard> getMarca(List<MotherBoard> completa, String marca);

    List<MotherBoard> getCategoria(List<MotherBoard> completa, String categoria);

    List<MotherBoard> getSlotRam(List<MotherBoard> completa, String slotram);

    List<MotherBoard> getSlotGPU(List<MotherBoard> completa, Float slotgpu);
}
