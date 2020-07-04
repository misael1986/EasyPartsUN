package com.example.backend.services;

import com.example.backend.commons.GenericServiveAPI;
import com.example.backend.models.Procesador;
import com.example.backend.models.json.ProcesadorJson;

import java.util.List;

public interface ProcesadorServiceAPI extends GenericServiveAPI<Procesador, Long> {

    ProcesadorJson listaCompleta(List<Procesador> completa);

    List<Procesador> getMarca(List<Procesador> completa, String fabricante);

    List<Procesador> getPsocket(List<Procesador> completa, String socket);

    List<Procesador> getNucleos(List<Procesador> completa, String nucleos);

    List<Procesador> getPotencia(List<Procesador> completa, String potencia);

    List<Procesador> getgrafica(List<Procesador> completa, String grafica);

}
