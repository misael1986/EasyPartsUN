package com.example.backend.controllers;

import com.example.backend.models.Gabinete;
import com.example.backend.models.Torre;
import com.example.backend.models.json.GabineteJson;
import com.example.backend.services.GabineteServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/gabinete/")
public class GabineteRestController {

    static List<Gabinete> listaCompleta = new ArrayList<>();
    static List<Gabinete> listaBoardCompatible = new ArrayList<>();
    static GabineteJson gabineteJson = null;

    @Autowired
    private GabineteServiceAPI gabineteServiceAPI;

    @GetMapping(value = "/all")
    public GabineteJson getAll() {
        if (listaCompleta.isEmpty()) {
            listaCompleta = gabineteServiceAPI.getAll();
            gabineteJson = gabineteServiceAPI.listaCompleta(listaCompleta);
        }
        return gabineteJson;
    }

    @GetMapping(value = "/board/{board}")
    public List<Gabinete> getABoard(@PathVariable String board) {
        listaBoardCompatible = gabineteServiceAPI.getMismaBoard(listaCompleta,board);
        return listaBoardCompatible;
    }

    @GetMapping(value = "/marca/{marca}")
    public List<Gabinete> getAMarca(@PathVariable String marca) {
        List<Gabinete> listaMismaMarca = gabineteServiceAPI.getMismaMarca(listaBoardCompatible,marca);
        return listaMismaMarca;
    }

    @GetMapping(value = "/find/{id}")
    public Gabinete getAny(@PathVariable Long id) {
        return gabineteServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Gabinete> save(@RequestBody Gabinete gabinete) {
        Gabinete obj = gabineteServiceAPI.save(gabinete);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<Gabinete>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<Gabinete> saveAll(@RequestBody Iterable<Gabinete> gabinete) {
        Iterable<Gabinete> obj = gabineteServiceAPI.saveAll(gabinete);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<Gabinete>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Gabinete> delete(@PathVariable Long id) {
        Gabinete gabinete = gabineteServiceAPI.get(id);
        if (gabinete != null) {
            gabineteServiceAPI.delete(id);
            listaCompleta.clear();
            this.getAll(); //volver a calcular los filtros y la lista completa
        } else {
            return new ResponseEntity<Gabinete>(gabinete, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Gabinete>(gabinete, HttpStatus.OK);
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity<Torre> clear() throws SQLException {
        gabineteServiceAPI.deleteAll("gabinete");
        listaCompleta.clear();
        this.getAll();
        return new ResponseEntity<Torre>(HttpStatus.OK);
    }
}
