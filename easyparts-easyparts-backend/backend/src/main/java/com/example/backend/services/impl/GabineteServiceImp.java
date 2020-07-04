package com.example.backend.services.impl;

import com.example.backend.commons.GenericServiceImp;
import com.example.backend.dao.GabineteDaoAPI;
import com.example.backend.models.Gabinete;
import com.example.backend.models.filtros.FiltrosGabinete;
import com.example.backend.models.json.GabineteJson;
import com.example.backend.services.GabineteServiceAPI;
import com.example.backend.services.filters.GabineteFilterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GabineteServiceImp extends GenericServiceImp<Gabinete,Long> implements GabineteServiceAPI {

    @Autowired
    private GabineteDaoAPI gabineteDaoApi;


    @Override
    public JpaRepository<Gabinete, Long> getDao() {
        return gabineteDaoApi;
    }

    @Override
    public List<Gabinete> getMismaBoard(List<Gabinete> completa, String Board) {
        List<Gabinete> listaMismaBoard = new ArrayList<>();
        int j = 0;
        int size = completa.size();
        while (j < size) {
            String [] boards = completa.get(j).getMotherboards().split(",");
            for (int i = 0; i < boards.length; i++){
                if (boards[i].equals(Board)) {
                    listaMismaBoard.add(completa.get(j));
                }
            }
            j++;
        }
        return listaMismaBoard;
    }

    @Override
    public List<Gabinete> getMismaMarca(List<Gabinete> completa, String marca) {
        List<Gabinete> listaMismaMarca = new ArrayList<>();
        int j = 0;
        int size = completa.size();
        while (j < size) {
            if (completa.get(j).getMarca().equals(marca)) {
                listaMismaMarca.add(completa.get(j));
            }
            j++;
        }
        return listaMismaMarca;
    }

    @Override
    public GabineteJson listaCompleta(List<Gabinete> completa) {
        GabineteFilterImpl gabineteFilter = new GabineteFilterImpl();
        FiltrosGabinete filtro = gabineteFilter.crearListaFiltros(completa);
        GabineteJson gabineteJson = new GabineteJson(filtro, completa);
        return gabineteJson;
    }
}
