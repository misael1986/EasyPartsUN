package com.example.backend.controllers;

import com.example.backend.models.PowerSource;
import com.example.backend.models.Torre;
import com.example.backend.models.json.PowerSourceJson;
import com.example.backend.services.PowerSourceServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/powerSource/")
public class PowerSourceRestController {

    static List<PowerSource> listaCompleta = new ArrayList<>();
    static List<PowerSource> listaPotenciaValida = new ArrayList<>();
    static PowerSourceJson powerSourceJson = null;

    @Autowired
    private PowerSourceServiceAPI powerSourceServiceAPI;

    @GetMapping(value = "/all")
    public PowerSourceJson getAll() {
        if (listaCompleta.isEmpty()) {
            listaCompleta = powerSourceServiceAPI.getAll();
            powerSourceJson = powerSourceServiceAPI.listaCompleta(listaCompleta);
        }
        return powerSourceJson;
    }

    @GetMapping(value = "/potencia/{potencia}")
    public List<PowerSource> getAPotencia(@PathVariable Long potencia) {
        listaPotenciaValida = powerSourceServiceAPI.getMismaPotencia(listaCompleta,potencia);
        return listaPotenciaValida;
    }

    @GetMapping(value = "/marca/{marca}")
    public List<PowerSource> getAMarca(@PathVariable String marca) {
        List<PowerSource> listaMismaMarca = powerSourceServiceAPI.getMismaMarca(listaPotenciaValida,marca);
        return listaMismaMarca;
    }

    @GetMapping(value = "/certificacion/{certificacion}")
    public List<PowerSource> getACertificacion(@PathVariable String certificacion) {
        List<PowerSource> listaMismaCertificacion = powerSourceServiceAPI.getMismaCertificacion(listaPotenciaValida,certificacion);
        return listaMismaCertificacion;
    }

    @GetMapping(value = "/find/{id}")
    public PowerSource getAny(@PathVariable Long id) {
        return powerSourceServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<PowerSource> save(@RequestBody PowerSource powerSource) {
        PowerSource obj = powerSourceServiceAPI.save(powerSource);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<PowerSource>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<PowerSource> saveAll(@RequestBody Iterable<PowerSource> powerSources) {
        Iterable<PowerSource> obj = powerSourceServiceAPI.saveAll(powerSources);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<PowerSource>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<PowerSource> delete(@PathVariable Long id) {
        PowerSource powerSource = powerSourceServiceAPI.get(id);
        if (powerSource != null) {
            powerSourceServiceAPI.delete(id);
            listaCompleta.clear();
            this.getAll(); //volver a calcular los filtros y la lista completa
        } else {
            return new ResponseEntity<PowerSource>(powerSource, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<PowerSource>(powerSource, HttpStatus.OK);
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity<Torre> clear() throws SQLException {
        powerSourceServiceAPI.deleteAll("power_source");
        listaCompleta.clear();
        this.getAll();
        return new ResponseEntity<Torre>(HttpStatus.OK);
    }
}
