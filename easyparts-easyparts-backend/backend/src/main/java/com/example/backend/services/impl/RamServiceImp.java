package com.example.backend.services.impl;

import com.example.backend.commons.GenericServiceImp;
import com.example.backend.dao.RamDaoAPI;
import com.example.backend.models.Ram;
import com.example.backend.models.filtros.FiltrosRam;
import com.example.backend.models.json.RamJson;
import com.example.backend.services.RamServiceAPI;
import com.example.backend.services.filters.RamFilterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RamServiceImp extends GenericServiceImp<Ram,Long> implements RamServiceAPI {

    @Autowired
    private RamDaoAPI ramDaoApi;

    @Override
    public JpaRepository<Ram, Long> getDao() {
        return ramDaoApi;
    }

    @Override
    public List<Ram> getMismaCapacidad(List<Ram> completa, String capacidad) {
        List<Ram> listaMismaCapacidad = new ArrayList<>();
        int j = 0;
        int size = completa.size();
        while (j < size) {
            if (completa.get(j).getCapacidad().equals(capacidad)) {
                listaMismaCapacidad.add(completa.get(j));
            }
            j++;
        }
        return listaMismaCapacidad;
    }

    @Override
    public List<Ram> getMismaTecnologia(List<Ram> completa, String tecnologia) {
        List<Ram> listaMismaTecnologia = new ArrayList<>();
        int j = 0;
        int size = completa.size();
        while (j < size) {
            if (completa.get(j).getTecnologia().equals(tecnologia)) {
                listaMismaTecnologia.add(completa.get(j));
            }
            j++;
        }
        return listaMismaTecnologia;
    }

    @Override
    public List<Ram> getMismaMarca(List<Ram> completa, String marca) {
        List<Ram> ramMarca = completa.stream().filter(r -> r.getMarca().equals(marca)).collect(Collectors.toList());
        return ramMarca;
    }

    @Override
    public RamJson listaCompleta(List<Ram> completa) {
        RamFilterImpl ramFilter = new RamFilterImpl();
        FiltrosRam filtro = ramFilter.crearListaFiltros(completa);
        RamJson ramJson = new RamJson(filtro, completa);
        return ramJson;
    }


}
