package com.example.backend.controllers;

import com.example.backend.models.Almacenamiento;
import com.example.backend.models.json.AlmacenamientoJson;
import com.example.backend.services.AlmacenamientoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/almacenamiento/")
public class AlmacenamientoRestController {

    static List<Almacenamiento> listaCompleta = new ArrayList<>();
    static List<Almacenamiento> listaPuertoCompatible = new ArrayList<>();
    static AlmacenamientoJson almacenamientoJson = null;

    @Autowired
    private AlmacenamientoServiceAPI almacenamientoServiceAPI;

    @GetMapping(value = "/all")
    public AlmacenamientoJson getAll() {
        if (listaCompleta.isEmpty()) {
            listaCompleta = almacenamientoServiceAPI.getAll();
            almacenamientoJson = almacenamientoServiceAPI.listaCompleta(listaCompleta);
        }
        return almacenamientoJson;
    }

    @GetMapping(value = "/puerto/{puerto}")
    public List<Almacenamiento> getAPuerto(@PathVariable String puerto) { //@PathVariable es como un casteo de una variable que recibo de la url
        listaPuertoCompatible = almacenamientoServiceAPI.getMismoPuerto(listaCompleta,puerto);
        return listaPuertoCompatible;
    }

    @GetMapping(value = "/marca/{marca}")
    public List<Almacenamiento> getAMarca(@PathVariable String marca) {
        List<Almacenamiento> almacenamientoMarca = almacenamientoServiceAPI.getMismaMarca(listaPuertoCompatible, marca);
        return almacenamientoMarca;
    }

    @GetMapping(value = "/capacidad/{capacidad}")
    public List<Almacenamiento> getACapacidad(@PathVariable String capacidad) { //@PathVariable es como un casteo de una variable que recibo de la url
        List<Almacenamiento> listaMismaCapacidad = almacenamientoServiceAPI.getMismaCapacidad(listaPuertoCompatible,capacidad);
        return listaMismaCapacidad;
    }

    @GetMapping(value = "/tecnologia/{tecnologia}")
    public List<Almacenamiento> getATecnologia(@PathVariable String tecnologia) {
        List<Almacenamiento> listaMismaTecnologia = almacenamientoServiceAPI.getMismaTecnologia(listaPuertoCompatible,tecnologia);
        return listaMismaTecnologia;
    }

    @GetMapping(value = "/find/{id}")
    public Almacenamiento getAny(@PathVariable Long id) {
        return almacenamientoServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Almacenamiento> save(@RequestBody Almacenamiento almacenamiento) {
        Almacenamiento obj = almacenamientoServiceAPI.save(almacenamiento);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<Almacenamiento>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<Almacenamiento> saveAll(@RequestBody Iterable<Almacenamiento> almacenamiento) {
        Iterable<Almacenamiento> obj = almacenamientoServiceAPI.saveAll(almacenamiento);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<Almacenamiento>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Almacenamiento> delete(@PathVariable Long id) {
        Almacenamiento almacenamiento = almacenamientoServiceAPI.get(id);
        if (almacenamiento != null) {
            almacenamientoServiceAPI.delete(id);
            listaCompleta.clear();
            this.getAll(); //volver a calcular los filtros y la lista completa
        } else {
            return new ResponseEntity<Almacenamiento>(almacenamiento, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Almacenamiento>(almacenamiento, HttpStatus.OK);
    }
}
