package com.example.backend.services;

import com.example.backend.commons.GenericServiveAPI;
import com.example.backend.models.Almacenamiento;
import com.example.backend.models.json.AlmacenamientoJson;

import java.util.List;

public interface AlmacenamientoServiceAPI extends GenericServiveAPI<Almacenamiento,Long> {
    List<Almacenamiento> getMismaCapacidad(List<Almacenamiento> completa, String capacidad);
    List<Almacenamiento> getMismaTecnologia(List<Almacenamiento> completa, String tecnologia);
    List<Almacenamiento> getMismoPuerto(List<Almacenamiento> completa, String puerto);
    List<Almacenamiento> getMismaMarca(List<Almacenamiento> completa, String marca);

    AlmacenamientoJson listaCompleta(List<Almacenamiento> completa);
}
