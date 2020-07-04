package com.example.backend.services.impl;

import com.example.backend.commons.GenericServiceImp;
import com.example.backend.dao.TorreDaoAPI;
import com.example.backend.services.TorreServiceAPI;
import com.example.backend.models.Almacenamiento;
import com.example.backend.models.Torre;
import com.example.backend.models.json.TorreJson;
import com.example.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TorreServiceImp extends GenericServiceImp<Torre, Long> implements TorreServiceAPI {

    @Autowired
    private TorreDaoAPI torreDaoAPI;

    @Autowired
    private TorreServiceAPI torreServiceAPI;

    @Autowired
    private ProcesadorServiceAPI procesadorServiceAPI;

    @Autowired
    private MotherBoardServiceAPI motherBoardServiceAPI;

    @Autowired
    private TarjetaVideoServiceAPI tarjetaVideoServiceAPI;

    @Autowired
    private RamServiceAPI ramServiceAPI;

    @Autowired
    private AlmacenamientoServiceAPI almacenamientoServiceAPI;

    @Autowired
    private GabineteServiceAPI gabineteServiceAPI;

    @Autowired
    private PowerSourceServiceAPI powerSourceServiceAPI;

    @Override
    public JpaRepository<Torre, Long> getDao() {
        return torreDaoAPI;
    }

    @Override
    public List<Torre> getMismoProposito(List<Torre> completa, String proposito) {
        List<Torre> listaMismoProposito = new ArrayList<>();
        int j = 0;
        int size = completa.size();
        while (j < size) {
            if (completa.get(j).getProposito().equals(proposito)) {
                listaMismoProposito.add(completa.get(j));
            }
            j++;
        }
        return listaMismoProposito;
    }

    @Override
    public TorreJson torreAJson(Torre torre) {
        String ArrayDiscos[] = torre.getIds_discos().split(",");
        String ArrayCantdiscos[] = torre.getCant_discos().split(",");

        List<Almacenamiento> listaDiscos = new ArrayList<>();
        List<Integer> cantDiscos = new ArrayList<>();

        /*
        for (String id : ArrayDiscos) {
            listaDiscos.add(almacenamientoServiceAPI.get(Long.parseLong(id)));
        }

        for (String cant : ArrayCantdiscos) {
            cantDiscos.add(Integer.parseInt(cant));
        }
        */

        for (int i = 0; i < ArrayDiscos.length; i++) {
            listaDiscos.add(almacenamientoServiceAPI.get(Long.parseLong(ArrayDiscos[i])));
            cantDiscos.add(Integer.parseInt(ArrayCantdiscos[i]));
        }

        TorreJson torreJson = new TorreJson();
        torreJson.setId(torre.getId());
        torreJson.setProcesador(procesadorServiceAPI.get(torre.getProcesador_id()));
        torreJson.setBoard(motherBoardServiceAPI.get(torre.getBoard_id()));
        torreJson.setTarjetaVideo(tarjetaVideoServiceAPI.get(torre.getGrafica_id()));
        torreJson.setCant_grafica(torre.getCant_grafica());
        torreJson.setRam(ramServiceAPI.get(torre.getRam_id()));
        torreJson.setCant_ram(torre.getCant_ram());
        torreJson.setDiscos(listaDiscos);
        torreJson.setCant_discos(cantDiscos);
        torreJson.setGabinete(gabineteServiceAPI.get(torre.getGabinete_id()));
        torreJson.setPowerSource(powerSourceServiceAPI.get(torre.getPowersource_id()));
        torreJson.setProposito(torre.getProposito());
        torreJson.setPreciototal(torre.getPreciototal());

        return torreJson;
    }

    @Override
    public List<TorreJson> listaTotal(List<Torre> completa) {

        List<TorreJson> todostorres = new ArrayList<>();

        for (Torre torre : completa) {
            TorreJson torreJson = torreAJson(torre);
            todostorres.add(torreJson);
        }

        return todostorres;
    }

    @Override
    public TorreJson TorreCompletaPorID(Long id) {
        if(torreServiceAPI.get(id)==null){
            return null;
        }
        Torre torre = torreServiceAPI.get(id);
        TorreJson torreJson = torreAJson(torre);
        return torreJson;
    }

    @Override
    public List<Torre> TorreCompletaPorCorreo(List<Torre> completa,String correo) {
        List<Torre> listaMismoCorreo = completa.stream().filter(c -> c.getEmail().equals(correo)).collect(Collectors.toList());
        return listaMismoCorreo;
    }


}
