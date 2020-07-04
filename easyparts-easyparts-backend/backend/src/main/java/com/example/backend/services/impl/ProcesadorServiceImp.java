package com.example.backend.services.impl;

import com.example.backend.commons.GenericServiceImp;
import com.example.backend.dao.ProcesadorDaoAPI;
import com.example.backend.models.Procesador;
import com.example.backend.models.filtros.FiltrosProcesador;
import com.example.backend.models.json.ProcesadorJson;
import com.example.backend.services.ProcesadorServiceAPI;
import com.example.backend.services.filters.ProcesadorFilterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcesadorServiceImp extends GenericServiceImp<Procesador, Long> implements ProcesadorServiceAPI {

    @Autowired
    private ProcesadorDaoAPI procesadorDaoApi;

    @Override
    public JpaRepository<Procesador, Long> getDao() {
        return procesadorDaoApi;
    }

    @Override
    public ProcesadorJson listaCompleta(List<Procesador> completa) {

        ProcesadorFilterImpl procesadorFilter = new ProcesadorFilterImpl();
        FiltrosProcesador filtro = procesadorFilter.crearListaFiltros(completa);
        ProcesadorJson procesadorJson = new ProcesadorJson(filtro, completa);
        return procesadorJson;

    }

    @Override
    public List<Procesador> getMarca(List<Procesador> completa, String marca) {
        List<Procesador> procesadormarca = completa.stream().filter(p -> p.getMarca().equals(marca)).collect(Collectors.toList());
        return procesadormarca;
    }

    @Override
    public List<Procesador> getPsocket(List<Procesador> completa, String socket) {

        List<Procesador> procesadorsocket = completa.stream().filter(p -> p.getPsocket().equals(socket)).collect(Collectors.toList());
        return procesadorsocket;
    }

    @Override
    public List<Procesador> getNucleos(List<Procesador> completa, String nucleos) {

        List<Procesador> procesadornucleos = completa.stream().filter(p -> p.getNum_nucleos().equals(nucleos)).collect(Collectors.toList());
        return procesadornucleos;

    }


    @Override
    public List<Procesador> getPotencia(List<Procesador> completa, String potencia) {

        List<Procesador> procesadorpotencia = completa.stream().filter(p -> p.getFrecuencia().equals(potencia)).collect(Collectors.toList());
        return procesadorpotencia;

    }


    @Override
    public List<Procesador> getgrafica(List<Procesador> completa, String grafica) {

        List<Procesador> procesadorgrafica = completa.stream().filter(p -> p.getGrafica_integrada().equals(grafica)).collect(Collectors.toList());
        return procesadorgrafica;

    }

}
