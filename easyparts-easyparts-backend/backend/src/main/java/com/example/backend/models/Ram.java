package com.example.backend.models;

import javax.persistence.*;

@Entity
public class Ram {
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
    private String capacidad;
    @Column
    private Integer velocidad;
    @Column
    private String tecnologia;
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

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
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

    public void setPotencia_max(Long potencia_max) {
        this.potencia_max = potencia_max;
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
