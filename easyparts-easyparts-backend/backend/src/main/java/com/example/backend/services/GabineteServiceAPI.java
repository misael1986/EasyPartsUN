package com.example.backend.services;

import com.example.backend.commons.GenericServiveAPI;
import com.example.backend.models.Gabinete;
import com.example.backend.models.json.GabineteJson;

import java.util.List;

public interface GabineteServiceAPI extends GenericServiveAPI<Gabinete,Long> {
    List<Gabinete> getMismaBoard(List<Gabinete> completa, String Board);
    List<Gabinete> getMismaMarca(List<Gabinete> completa, String marca);

    GabineteJson listaCompleta(List<Gabinete> completa);
}
