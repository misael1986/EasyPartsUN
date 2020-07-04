package com.example.backend.controllers;

import com.example.backend.models.TarjetaVideo;
import com.example.backend.models.Torre;
import com.example.backend.models.json.TarjetaVideoJson;
import com.example.backend.services.TarjetaVideoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tarjetavideo/")
public class TarjetaVideoRestController {

    static List<TarjetaVideo> listaCompleta = new ArrayList<>();
    static List<TarjetaVideo> listaPuertos = null;
    static TarjetaVideoJson graficaJson = null;

    @Autowired
    private TarjetaVideoServiceAPI tarjetaVideoServiceAPI;

    @GetMapping(value = "/all")
    public TarjetaVideoJson getAll() {
        if (listaCompleta.isEmpty()) {
            listaCompleta = tarjetaVideoServiceAPI.getAll();
            graficaJson = tarjetaVideoServiceAPI.listaCompleta(listaCompleta);
        }
        return graficaJson;
    }

    @GetMapping(value = "/puerto/{ranura}")
    public List<TarjetaVideo> getPuerto(@PathVariable Float ranura) {
        listaPuertos = tarjetaVideoServiceAPI.getPCIport(listaCompleta, ranura);
        return listaPuertos;
    }

    @GetMapping(value = "/marca/{marca}")
    public List<TarjetaVideo> getAMarca(@PathVariable String marca) {
        List<TarjetaVideo> graficamarca = tarjetaVideoServiceAPI.getMarcaVideo(listaPuertos, marca);
        return graficamarca;
    }

    @GetMapping(value = "/tipomemoria/{memoria}")
    public List<TarjetaVideo> getMemoria(@PathVariable String memoria) {
        List<TarjetaVideo> memoriatipo = tarjetaVideoServiceAPI.getTipoMemoria(listaPuertos, memoria);
        return memoriatipo;
    }

    @GetMapping(value = "/capacidad/{capacidad}")
    public List<TarjetaVideo> getCapacidad(@PathVariable Integer capacidad) {

        List<TarjetaVideo> memoriatipo = tarjetaVideoServiceAPI.getCapacidadMemoria(listaPuertos, capacidad);
        return memoriatipo;
    }

    @GetMapping(value = "/proposito/{proposito}")
    public List<TarjetaVideo> getProposito(@PathVariable String proposito) {
        List<TarjetaVideo> memoriatipo = tarjetaVideoServiceAPI.getProposito(listaPuertos, proposito);
        return memoriatipo;
    }

    @GetMapping(value = "/find/{id}")
    public TarjetaVideo getAny(@PathVariable Long id) {
        return tarjetaVideoServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<TarjetaVideo> save(@RequestBody TarjetaVideo tarjetaVideo) {
        TarjetaVideo obj = tarjetaVideoServiceAPI.save(tarjetaVideo);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<TarjetaVideo>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<TarjetaVideo> saveAll(@RequestBody Iterable<TarjetaVideo> tarjetaVideo) {
        Iterable<TarjetaVideo> obj = tarjetaVideoServiceAPI.saveAll(tarjetaVideo);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<TarjetaVideo>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<TarjetaVideo> delete(@PathVariable Long id) {
        TarjetaVideo tarjetaVideo = tarjetaVideoServiceAPI.get(id);
        if (tarjetaVideo != null) {
            tarjetaVideoServiceAPI.delete(id);
            listaCompleta.clear();
            this.getAll(); //volver a calcular los filtros y la lista completa
        } else {
            return new ResponseEntity<TarjetaVideo>(tarjetaVideo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<TarjetaVideo>(tarjetaVideo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity<Torre> clear() throws SQLException {
        tarjetaVideoServiceAPI.deleteAll("tarjeta_video");
        listaCompleta.clear();
        this.getAll();
        return new ResponseEntity<Torre>(HttpStatus.OK);
    }

}
