package com.example.backend.services;

import com.example.backend.commons.GenericServiveAPI;
import com.example.backend.models.Ram;
import com.example.backend.models.json.RamJson;

import java.util.List;

public interface RamServiceAPI extends GenericServiveAPI<Ram,Long> {
    List<Ram> getMismaCapacidad(List<Ram> completa, String capacidad);
    List<Ram> getMismaTecnologia(List<Ram> completa, String tecnologia);
    List<Ram> getMismaMarca(List<Ram> completa, String marca);

    RamJson listaCompleta(List<Ram> completa);
}
