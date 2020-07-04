package com.example.backend.models;

import javax.persistence.*;

@Entity
public class TarjetaVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nombre;
    @Column
    private String modelo;
    @Column
    private String marca;
    @Column
    private Float pci_express;
    @Column
    private String tipo_memoria;
    @Column
    private Integer capacidad_memoria;
    @Column
    private String proposito;
    @Column
    private String link;
    @Column(columnDefinition = "TEXT")
    private String imagen;
    @Column
    private Long potencia_max;
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

    public Float getPci_express() {
        return pci_express;
    }

    public void setPci_express(Float pci_express) {
        this.pci_express = pci_express;
    }

    public String getTipo_memoria() {
        return tipo_memoria;
    }

    public void setTipo_memoria(String tipo_memoria) {
        this.tipo_memoria = tipo_memoria;
    }

    public Integer getCapacidad_memoria() {
        return capacidad_memoria;
    }

    public void setCapacidad_memoria(Integer capacidad_memoria) {
        this.capacidad_memoria = capacidad_memoria;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getPotencia_max() {
        return potencia_max;
    }

    public void setPotencia_max(Long potencia_max) {
        this.potencia_max = potencia_max;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
