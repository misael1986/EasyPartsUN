package com.example.backend.controllers;

import com.example.backend.models.Torre;
import com.example.backend.models.json.TorreJson;
import com.example.backend.services.TorreServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/torre/")

public class TorreRestController {

    static List<Torre> listaCompleta = new ArrayList<>();
    static List<TorreJson> torreJson = new ArrayList<>();

    @Autowired
    private TorreServiceAPI torreServiceAPI;

    @GetMapping(value = "/all")
    public List<TorreJson> getAll() {
        if (listaCompleta.isEmpty()) {
            listaCompleta = torreServiceAPI.getAll();
        }
        if (torreJson.isEmpty()) {
            torreJson = torreServiceAPI.listaTotal(listaCompleta);
        }
        return torreJson;
    }

    @GetMapping(value = "/allOnlyIDs")
    public List<Torre> getAllSoloIDS() {
        if (listaCompleta.isEmpty()) {
            listaCompleta = torreServiceAPI.getAll();
        }
        return listaCompleta;
    }

    @GetMapping(value = "/proposito/{proposito}")
    public List<Torre> getMismoProposito(@PathVariable String proposito) {
        if (listaCompleta.isEmpty()) {
            listaCompleta = torreServiceAPI.getAll();
        }
        List<Torre> listaMismoProposito = torreServiceAPI.getMismoProposito(listaCompleta, proposito);
        return listaMismoProposito;
    }

    @GetMapping(value = "/correo/{correo}")
    public List<Torre> getMismoCorreo(@PathVariable String correo) {
        if (listaCompleta.isEmpty()) {
            listaCompleta = torreServiceAPI.getAll();
        }
        List<Torre> listaMismoCorreo = torreServiceAPI.TorreCompletaPorCorreo(listaCompleta, correo);
        return listaMismoCorreo;
    }


    @GetMapping(value = "/findjson/{id}")
    public TorreJson getAny(@PathVariable Long id) {
        return torreServiceAPI.TorreCompletaPorID(id);
    }

    @GetMapping(value = "/find/{id}")
    public Torre getId(@PathVariable Long id) {
        return torreServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Torre> save(@RequestBody Torre torre) {
        Torre obj = torreServiceAPI.save(torre);
        listaCompleta.clear();
        torreJson.clear();
        this.getAll();
        return new ResponseEntity<Torre>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<Torre> saveAll(@RequestBody Iterable<Torre> torres) {
        Iterable<Torre> obj = torreServiceAPI.saveAll(torres);
        listaCompleta.clear();
        torreJson.clear();
        this.getAll();
        return new ResponseEntity<Torre>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Torre> delete(@PathVariable Long id) {
        Torre torre = torreServiceAPI.get(id);
        if (torre != null) {
            torreServiceAPI.delete(id);
            listaCompleta.clear();
            torreJson.clear();
            this.getAll();
        } else {
            return new ResponseEntity<Torre>(torre, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Torre>(torre, HttpStatus.OK);
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity<Torre> clear() throws SQLException {
        torreServiceAPI.deleteAll("torre");
        listaCompleta.clear();
        torreJson.clear();
        this.getAll();
        return new ResponseEntity<Torre>(HttpStatus.OK);
    }

}
