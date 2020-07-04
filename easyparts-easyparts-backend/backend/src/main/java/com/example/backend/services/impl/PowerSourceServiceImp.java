package com.example.backend.services.impl;

import com.example.backend.commons.GenericServiceImp;
import com.example.backend.dao.PowerSourceDaoAPI;
import com.example.backend.models.PowerSource;
import com.example.backend.models.filtros.FiltrosPowerSource;
import com.example.backend.models.json.PowerSourceJson;
import com.example.backend.services.PowerSourceServiceAPI;
import com.example.backend.services.filters.PowerSourceFilterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PowerSourceServiceImp extends GenericServiceImp<PowerSource,Long> implements PowerSourceServiceAPI {

    @Autowired
    private PowerSourceDaoAPI powerSourceDaoApi;

    @Override
    public JpaRepository<PowerSource, Long> getDao() {
        return powerSourceDaoApi;
    }

    @Override
    public List<PowerSource> getMismaPotencia(List<PowerSource> completa, Long potencia) {
        List<PowerSource> listaMismaPotencia = new ArrayList<>();
        int j = 0;
        int size = completa.size();
        while (j < size) {
            Double porcentaje = 0.8;
            String certificacion = completa.get(j).getCertificacion();

            switch (certificacion)
            {
                case "White":
                    porcentaje = 0.8;
                    break;
                case "Bronze":
                    porcentaje = 0.82;
                    break;
                case "Silver":
                    porcentaje = 0.85;
                    break;
                case "Gold":
                    porcentaje = 0.87;
                    break;
                case "Platinum":
                    porcentaje = 0.9;
                    break;
                case "Titanium":
                    porcentaje = 0.92;
                    break;
                default:
                    porcentaje = 0.8;
                    break;
            }

            Long potenciaTeorica = completa.get(j).getPotencia();
            double potenciaReal = ((double)potenciaTeorica)*porcentaje;

            if (potenciaReal >= potencia) {
                listaMismaPotencia.add(completa.get(j));
            }
            j++;
        }
        return listaMismaPotencia;
    }

    @Override
    public List<PowerSource> getMismaCertificacion(List<PowerSource> completa, String certificacion) {
        List<PowerSource> listaMismaCertificacion = new ArrayList<>();
        int j = 0;
        int size = completa.size();
        while (j < size) {
            if (completa.get(j).getCertificacion().equals(certificacion)) {
                listaMismaCertificacion.add(completa.get(j));
            }
            j++;
        }
        return listaMismaCertificacion;
    }

    @Override
    public List<PowerSource> getMismaMarca(List<PowerSource> completa, String marca) {
        List<PowerSource> powerSourceMarca = completa.stream().filter(p -> p.getMarca().equals(marca)).collect(Collectors.toList());
        return powerSourceMarca;
    }

    @Override
    public PowerSourceJson listaCompleta(List<PowerSource> completa) {
        PowerSourceFilterImpl powerSourceFilter = new PowerSourceFilterImpl();
        FiltrosPowerSource filtro = powerSourceFilter.crearListaFiltros(completa);
        PowerSourceJson powerSourceJson = new PowerSourceJson(filtro, completa);
        return powerSourceJson;
    }
}
