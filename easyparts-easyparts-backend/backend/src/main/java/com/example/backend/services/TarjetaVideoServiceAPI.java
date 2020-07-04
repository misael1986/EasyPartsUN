package com.example.backend.services;


import com.example.backend.commons.GenericServiveAPI;
import com.example.backend.models.TarjetaVideo;
import com.example.backend.models.json.TarjetaVideoJson;

import java.util.List;

public interface TarjetaVideoServiceAPI extends GenericServiveAPI<TarjetaVideo, Long> {

    TarjetaVideoJson listaCompleta(List<TarjetaVideo> completa);

    List<TarjetaVideo> getPCIport(List<TarjetaVideo> completa, Float puerto);

    List<TarjetaVideo> getMarcaVideo(List<TarjetaVideo> completa, String fabricante);

    List<TarjetaVideo> getTipoMemoria(List<TarjetaVideo> completa, String memoria);

    List<TarjetaVideo> getCapacidadMemoria(List<TarjetaVideo> completa, Integer memoria);

    List<TarjetaVideo> getProposito(List<TarjetaVideo> completa, String proposito);


}
