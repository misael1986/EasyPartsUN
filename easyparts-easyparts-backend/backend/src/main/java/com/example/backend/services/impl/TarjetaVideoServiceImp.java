package com.example.backend.services.impl;

import com.example.backend.commons.GenericServiceImp;
import com.example.backend.dao.TarjetaVideoDaoAPI;
import com.example.backend.models.TarjetaVideo;
import com.example.backend.models.filtros.FiltrosTarjetaVideo;
import com.example.backend.models.json.TarjetaVideoJson;
import com.example.backend.services.TarjetaVideoServiceAPI;
import com.example.backend.services.filters.TarjetaVideoFilterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarjetaVideoServiceImp extends GenericServiceImp<TarjetaVideo, Long> implements TarjetaVideoServiceAPI {

    @Override
    public JpaRepository<TarjetaVideo, Long> getDao() {
        return tarjetaVideoDaoAPI;
    }

    @Autowired
    public TarjetaVideoDaoAPI tarjetaVideoDaoAPI;

    @Override
    public TarjetaVideoJson listaCompleta(List<TarjetaVideo> completa) {

        TarjetaVideoFilterImpl graficaFilter = new TarjetaVideoFilterImpl();
        FiltrosTarjetaVideo filtro = graficaFilter.crearListaFiltros(completa);
        TarjetaVideoJson tarjetaVideoJson = new TarjetaVideoJson(filtro, completa);
        return tarjetaVideoJson;

    }

    @Override
    public List<TarjetaVideo> getMarcaVideo(List<TarjetaVideo> completa, String fabricante) {

        List<TarjetaVideo> marca = completa.stream().filter(g -> g.getMarca().equals(fabricante)).collect(Collectors.toList());
        return marca;
    }

    @Override
    public List<TarjetaVideo> getPCIport(List<TarjetaVideo> completa, Float puerto) {

        List<TarjetaVideo> pci = completa.stream().filter(g -> g.getPci_express() <= puerto).collect(Collectors.toList());
        return pci;
    }

    @Override
    public List<TarjetaVideo> getTipoMemoria(List<TarjetaVideo> completa, String memoria) {

        List<TarjetaVideo> memoriatipo = completa.stream().filter(g -> g.getTipo_memoria().equals(memoria)).collect(Collectors.toList());
        return memoriatipo;

    }

    @Override
    public List<TarjetaVideo> getCapacidadMemoria(List<TarjetaVideo> completa, Integer memoria) {

        List<TarjetaVideo> capacidad = completa.stream().filter(g -> g.getCapacidad_memoria().equals(memoria)).collect(Collectors.toList());
        return capacidad;

    }

    @Override
    public List<TarjetaVideo> getProposito(List<TarjetaVideo> completa, String proposito) {

        List<TarjetaVideo> gpuproposito = completa.stream().filter(g -> g.getProposito().equals(proposito)).collect(Collectors.toList());
        return gpuproposito;

    }

}
