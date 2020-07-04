package com.example.backend.models.json;

import com.example.backend.models.*;

import java.util.List;

public class TorreJson {

    private Long id;
    private Procesador procesador;
    private MotherBoard board;
    private TarjetaVideo tarjetaVideo;
    private Integer cant_grafica;
    private Ram ram;
    private Integer cant_ram;
    private List<Almacenamiento> discos;
    private List<Integer> cant_discos;
    private Gabinete gabinete;
    private PowerSource powerSource;
    private String proposito;
    private Long preciototal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    public MotherBoard getBoard() {
        return board;
    }

    public void setBoard(MotherBoard board) {
        this.board = board;
    }

    public TarjetaVideo getTarjetaVideo() {
        return tarjetaVideo;
    }

    public void setTarjetaVideo(TarjetaVideo tarjetaVideo) {
        this.tarjetaVideo = tarjetaVideo;
    }

    public Integer getCant_grafica() {
        return cant_grafica;
    }

    public void setCant_grafica(Integer cant_grafica) {
        this.cant_grafica = cant_grafica;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Integer getCant_ram() {
        return cant_ram;
    }

    public void setCant_ram(Integer cant_ram) {
        this.cant_ram = cant_ram;
    }

    public List<Almacenamiento> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Almacenamiento> discos) {
        this.discos = discos;
    }

    public List<Integer> getCant_discos() {
        return cant_discos;
    }

    public void setCant_discos(List<Integer> cant_discos) {
        this.cant_discos = cant_discos;
    }

    public Gabinete getGabinete() {
        return gabinete;
    }

    public void setGabinete(Gabinete gabinete) {
        this.gabinete = gabinete;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public Long getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(Long preciototal) {
        this.preciototal = preciototal;
    }
}
