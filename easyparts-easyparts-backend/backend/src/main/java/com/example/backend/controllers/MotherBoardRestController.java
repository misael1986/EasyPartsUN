package com.example.backend.controllers;


import com.example.backend.models.MotherBoard;
import com.example.backend.models.Torre;
import com.example.backend.models.json.MotherBoardJson;
import com.example.backend.services.MotherBoardServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/motherboard/")
public class MotherBoardRestController {

    static List<MotherBoard> listaCompleta = new ArrayList<>();
    static List<MotherBoard> listaSocket = null;
    static MotherBoardJson boardJson = null;

    @Autowired
    private MotherBoardServiceAPI motherBoardServiceAPI;

    @GetMapping(value = "/all")
    public MotherBoardJson getAll() {
        if (listaCompleta.isEmpty()) {
            listaCompleta = motherBoardServiceAPI.getAll();
            boardJson = motherBoardServiceAPI.listaCompleta(listaCompleta);
        }
        return boardJson;
    }

    @GetMapping(value = "/socket/{socket}")
    public List<MotherBoard> getSocket(@PathVariable String socket) {
        listaSocket = motherBoardServiceAPI.getSocket(listaCompleta,socket);
        return listaSocket;
    }

    @GetMapping(value = "/marca/{marca}")
    public List<MotherBoard> getMarca(@PathVariable String marca) {
        List<MotherBoard> marcalist = motherBoardServiceAPI.getMarca(listaSocket,marca);
        return marcalist;
    }

    @GetMapping(value = "/categoria/{categoria}")
    public List<MotherBoard> getCategoria(@PathVariable String categoria) {
        List<MotherBoard> categorialist = motherBoardServiceAPI.getCategoria(listaSocket,categoria);
        return categorialist;
    }

    @GetMapping(value = "/slotram/{slotram}")
    public List<MotherBoard> getSlotRam(@PathVariable String slotram) {
        List<MotherBoard> ramlist = motherBoardServiceAPI.getSlotRam(listaSocket,slotram);
        return ramlist;
    }

    @GetMapping(value = "/slotgpu/{slotgpu}")
    public List<MotherBoard> getSlotGpu(@PathVariable Float slotgpu) {
        List<MotherBoard> gpulist = motherBoardServiceAPI.getSlotGPU(listaSocket,slotgpu);
        return gpulist;
    }

    @GetMapping(value = "/find/{id}")
    public MotherBoard getAny(@PathVariable Long id) {
        return motherBoardServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<MotherBoard> save(@RequestBody MotherBoard motherBoard) {
        MotherBoard obj = motherBoardServiceAPI.save(motherBoard);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<MotherBoard>(obj, HttpStatus.OK);
    }
    @PostMapping(value = "/saveAll")
    public ResponseEntity<MotherBoard> saveAll(@RequestBody Iterable<MotherBoard> motherBoards) {
        Iterable<MotherBoard>obj = motherBoardServiceAPI.saveAll(motherBoards);
        listaCompleta.clear();
        this.getAll(); //volver a calcular los filtros y la lista completa
        return new ResponseEntity<MotherBoard>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<MotherBoard> delete(@PathVariable Long id) {
        MotherBoard motherBoard = motherBoardServiceAPI.get(id);
        if (motherBoard != null) {
            motherBoardServiceAPI.delete(id);
            listaCompleta.clear();
            this.getAll(); //volver a calcular los filtros y la lista completa
        } else {
            return new ResponseEntity<MotherBoard>(motherBoard, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<MotherBoard>(motherBoard, HttpStatus.OK);
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity<Torre> clear() throws SQLException {
        motherBoardServiceAPI.deleteAll("mother_board");
        listaCompleta.clear();
        this.getAll();
        return new ResponseEntity<Torre>(HttpStatus.OK);
    }

}
