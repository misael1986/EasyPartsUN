package com.example.backend.services;

import com.example.backend.commons.GenericServiveAPI;
import com.example.backend.models.PowerSource;
import com.example.backend.models.json.PowerSourceJson;

import java.util.List;

public interface PowerSourceServiceAPI extends GenericServiveAPI<PowerSource,Long> {
    List<PowerSource> getMismaMarca(List<PowerSource> completa, String marca);
    List<PowerSource> getMismaPotencia(List<PowerSource> completa, Long potencia);
    List<PowerSource> getMismaCertificacion(List<PowerSource> completa, String certificacion);

    PowerSourceJson listaCompleta(List<PowerSource> completa);
}
