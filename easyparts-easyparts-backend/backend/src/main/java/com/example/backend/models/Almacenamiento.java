package com.example.backend.models;

import javax.persistence.*;

@Entity
public class Almacenamiento {
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
    private String tecnologia;
    @Column
    private String puerto;
    @Column
    private String velocidad_lectura;
    @Column
    private String velocidad_escritura;
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

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getVelocidad_lectura() {
        return velocidad_lectura;
    }

    public void setVelocidad_lectura(String velocidad_lectura) {
        this.velocidad_lectura = velocidad_lectura;
    }

    public String getVelocidad_escritura() {
        return velocidad_escritura;
    }

    public void setVelocidad_escritura(String velocidad_escritura) {
        this.velocidad_escritura = velocidad_escritura;
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
