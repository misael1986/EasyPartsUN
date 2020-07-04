package com.example.backend.controllers;

import com.example.backend.models.Ram;
import com.example.backend.models.Torre;
import com.example.backend.models.json.RamJson;
import com.example.backend.services.RamServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/ram/")
public class RamRestController {

    static List<Ram> listaCompleta = new ArrayList<>();
    static List<Ram> listaTecnologiaCompatible = new ArrayList<>();
    static RamJson ramJson = null;

    @Autowired
    private RamServiceAPI ramServiceAPI;

    @GetMapping(value = "/all")
    public RamJson getAll() {
        if (listaCompleta.isEmpty()) {
            listaCompleta = ramServiceAPI.getAll();
            ramJson = ramServiceAPI.listaCompleta(listaCompleta);
        }

        return ramJson;
    }

    @GetMapping(value = "/tecnologia/{tecnologia}")
    public List<Ram> getATecnologia(@PathVariable String tecnologia) { //@PathVariable es como un casteo de una variable que recibo de la url
        listaTecnologiaCompatible = ramServiceAPI.getMismaTecnologia(listaCompleta, tecnologia);
        return listaTecnologiaCompatible;
    }

    @GetMapping(value = "/capacidad/{capacidad}")
    public List<Ram> getACapacidad(@PathVariable String capacidad) { //@PathVariable es como un casteo de una variable que recibo de la url
        List<Ram> listaMismaCapacidad = ramServiceAPI.getMismaCapacidad(listaTecnologiaCompatible, capacidad);
        return listaMismaCapacidad;
    }

    @GetMapping(value = "/marca/{marca}")
    public List<Ram> getAMarca(@PathVariable String marca) {
        List<Ram> ramMarca = ramServiceAPI.getMismaMarca(listaTecnologiaCompatible, marca);
        return ramMarca;
    }

    @GetMapping(value = "/find/{id}")
    public Ram getAny(@PathVariable Long id) {
        return ramServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Ram> save(@RequestBody Ram ram) {
        Ram obj = ramServiceAPI.save(ram);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<Ram>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<Ram> saveAll(@RequestBody Iterable<Ram> ram) {
        Iterable<Ram> obj = ramServiceAPI.saveAll(ram);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<Ram>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Ram> delete(@PathVariable Long id) {
        Ram ram = ramServiceAPI.get(id);
        if (ram != null) {
            ramServiceAPI.delete(id);
            listaCompleta.clear();
            this.getAll(); //volver a calcular los filtros y la lista completa
        } else {
            return new ResponseEntity<Ram>(ram, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Ram>(ram, HttpStatus.OK);
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity<Torre> clear() throws SQLException {
        ramServiceAPI.deleteAll("ram");
        listaCompleta.clear();
        this.getAll();
        return new ResponseEntity<Torre>(HttpStatus.OK);
    }
}
