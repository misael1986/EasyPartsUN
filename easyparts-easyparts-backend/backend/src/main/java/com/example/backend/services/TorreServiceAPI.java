package com.example.backend.services;

import com.example.backend.commons.GenericServiveAPI;
import com.example.backend.models.Torre;
import com.example.backend.models.json.TorreJson;

import java.util.List;

public interface TorreServiceAPI extends GenericServiveAPI<Torre,Long> {

    TorreJson torreAJson(Torre torre);
    List<Torre> getMismoProposito(List<Torre> completa, String proposito);
    List<TorreJson> listaTotal(List<Torre> completa);
    TorreJson TorreCompletaPorID(Long id);
    List<Torre> TorreCompletaPorCorreo(List<Torre> completa,String correo);

}
