package com.example.backend.models;

import javax.persistence.*;

@Entity
public class Procesador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nombre;
    @Column
    private String modelo;
    @Column
    private String marca;
    @Column
    private String num_nucleos;
    @Column
    private String frecuencia;
    @Column
    private String pcache;
    @Column
    private String grafica_integrada;
    @Column
    private String psocket;
    @Column
    private String linkinfo;
    @Column
    private Long potencia_max;
    @Column(columnDefinition = "TEXT")
    private String imagen;
    @Column
    private Long precio;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNum_nucleos() {
        return num_nucleos;
    }

    public void setNum_nucleos(String num_nucleos) {
        this.num_nucleos = num_nucleos;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getPcache() {
        return pcache;
    }

    public void setPcache(String pcache) {
        this.pcache = pcache;
    }

    public String getGrafica_integrada() {
        return grafica_integrada;
    }

    public void setGrafica_integrada(String grafica_integrada) {
        this.grafica_integrada = grafica_integrada;
    }

    public String getPsocket() {
        return psocket;
    }

    public void setPsocket(String psocket) {
        this.psocket = psocket;
    }

    public String getLinkinfo() {
        return linkinfo;
    }

    public void setLinkinfo(String linkinfo) {
        this.linkinfo = linkinfo;
    }

    public Long getPotencia_max() {
        return potencia_max;
    }

    public void setPotencia_max(Long gpotencia_max) {
        this.potencia_max = gpotencia_max;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
