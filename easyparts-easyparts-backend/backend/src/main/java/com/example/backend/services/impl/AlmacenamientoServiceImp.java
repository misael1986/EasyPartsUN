package com.example.backend.services.impl;

import com.example.backend.commons.GenericServiceImp;
import com.example.backend.dao.AlmacenamientoDaoAPI;
import com.example.backend.models.Almacenamiento;
import com.example.backend.models.filtros.FiltrosAlmacenamiento;
import com.example.backend.models.json.AlmacenamientoJson;
import com.example.backend.services.AlmacenamientoServiceAPI;
import com.example.backend.services.filters.AlmacenamientoFilterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlmacenamientoServiceImp extends GenericServiceImp<Almacenamiento,Long> implements AlmacenamientoServiceAPI {

    @Autowired
    private AlmacenamientoDaoAPI almacenamientoDaoApi;

    @Override
    public JpaRepository<Almacenamiento, Long> getDao() {
        return almacenamientoDaoApi;
    }

    @Override
    public List<Almacenamiento> getMismaMarca(List<Almacenamiento> completa, String marca) {
        List<Almacenamiento> almacenamientoMarca = completa.stream().filter(a -> a.getMarca().equals(marca)).collect(Collectors.toList());
        return almacenamientoMarca;
    }

    @Override
    public List<Almacenamiento> getMismaCapacidad(List<Almacenamiento> completa, String capacidad) {
        List<Almacenamiento> listaMismaCapacidad = new ArrayList<>();
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
    public List<Almacenamiento> getMismaTecnologia(List<Almacenamiento> completa, String tecnologia) {
        List<Almacenamiento> listaMismaTecnologia = new ArrayList<>();
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
    public List<Almacenamiento> getMismoPuerto(List<Almacenamiento> completa, String puerto) {
        List<Almacenamiento> listaMismoPuerto = new ArrayList<>();
        int j = 0;
        int size = completa.size();
        while (j < size) {
            if (completa.get(j).getPuerto().equals(puerto)) {
                listaMismoPuerto.add(completa.get(j));
            }
            j++;
        }
        return listaMismoPuerto;
    }

    @Override
    public AlmacenamientoJson listaCompleta(List<Almacenamiento> completa) {
        AlmacenamientoFilterImpl almacenamientoFilter = new AlmacenamientoFilterImpl();
        FiltrosAlmacenamiento filtro = almacenamientoFilter.crearListaFiltros(completa);
        AlmacenamientoJson almacenamientoJson = new AlmacenamientoJson(filtro, completa);
        return almacenamientoJson;
    }
}
