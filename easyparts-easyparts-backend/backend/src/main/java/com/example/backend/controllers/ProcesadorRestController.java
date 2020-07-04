package com.example.backend.controllers;

import com.example.backend.models.Procesador;
import com.example.backend.models.Torre;
import com.example.backend.models.json.ProcesadorJson;
import com.example.backend.services.ProcesadorServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/procesador/")

public class ProcesadorRestController {

    static List<Procesador> listaCompleta = new ArrayList<>();
    static ProcesadorJson procesadorJson = null;

    @Autowired
    private ProcesadorServiceAPI procesadorServiceAPI;

    @GetMapping(value = "/all")
    public ProcesadorJson getAll() {
        if (listaCompleta.isEmpty()) {
            listaCompleta = procesadorServiceAPI.getAll();
            procesadorJson = procesadorServiceAPI.listaCompleta(listaCompleta);
        }

        return procesadorJson;
    }


    @GetMapping(value = "/socket/{socket}")
    public List<Procesador> getSocket(@PathVariable String socket) {
        List<Procesador> procesadorsocket = procesadorServiceAPI.getPsocket(listaCompleta, socket);
        return procesadorsocket;
    }

    @GetMapping(value = "/marca/{marca}")
    public List<Procesador> getAMarca(@PathVariable String marca) {
        List<Procesador> procesadormarca = procesadorServiceAPI.getMarca(listaCompleta, marca);
        return procesadormarca;
    }


    @GetMapping(value = "/nucleos/{nucleos}")
    public List<Procesador> getNucleos(@PathVariable String nucleos) {
        List<Procesador> procesadornucleos = procesadorServiceAPI.getNucleos(listaCompleta, nucleos);
        return procesadornucleos;
    }

    @GetMapping(value = "/freciencia/{frecuencia}")
    public List<Procesador> getPotencia(@PathVariable String frecuencia) {
        List<Procesador> procesadorfrecuencia = procesadorServiceAPI.getPotencia(listaCompleta, frecuencia);
        return procesadorfrecuencia;
    }

    @GetMapping(value = "/grafica/{grafica}")
    public List<Procesador> getGrafica(@PathVariable String grafica) {
        List<Procesador> procesadorgrafica = procesadorServiceAPI.getgrafica(listaCompleta, grafica);
        return procesadorgrafica;
    }

    @GetMapping(value = "/find/{id}")
    public Procesador getAny(@PathVariable Long id) {
        return procesadorServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Procesador> save(@RequestBody Procesador procesador) {
        Procesador obj = procesadorServiceAPI.save(procesador);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<Procesador>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<Procesador> saveAll(@RequestBody Iterable<Procesador> procesador) {
        Iterable<Procesador> obj = procesadorServiceAPI.saveAll(procesador);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<Procesador>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Procesador> delete(@PathVariable Long id) {
        Procesador procesador = procesadorServiceAPI.get(id);
        if (procesador != null) {
            procesadorServiceAPI.delete(id);
            listaCompleta.clear();
            this.getAll(); //volver a calcular los filtros y la lista completa
        } else {
            return new ResponseEntity<Procesador>(procesador, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Procesador>(procesador, HttpStatus.OK);
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity<Torre> clear() throws SQLException {
        procesadorServiceAPI.deleteAll("procesador");
        listaCompleta.clear();
        this.getAll();
        return new ResponseEntity<Torre>(HttpStatus.OK);
    }
}
