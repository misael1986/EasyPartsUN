package com.example.backend.models;

import javax.persistence.*;

@Entity
public class MotherBoard {
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
    private String categoria;
    @Column
    private String msocket;
    @Column
    private String slot_ram;
    @Column
    private Integer ram_cantidad;
    @Column
    private Float slot_gpu;
    @Column
    private Integer gpu_cantidad;
    @Column
    private String tipo_sata;
    @Column
    private Integer cantidad_sata;
    @Column
    private Integer mdos_cantidad;
    @Column
    private String link;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMsocket() {
        return msocket;
    }

    public void setMsocket(String msocket) {
        this.msocket = msocket;
    }

    public String getSlot_ram() {
        return slot_ram;
    }

    public void setSlot_ram(String slot_ram) {
        this.slot_ram = slot_ram;
    }

    public Integer getRam_cantidad() {
        return ram_cantidad;
    }

    public void setRam_cantidad(Integer ram_cantidad) {
        this.ram_cantidad = ram_cantidad;
    }

    public Float getSlot_gpu() {
        return slot_gpu;
    }

    public void setSlot_gpu(Float slot_gpu) {
        this.slot_gpu = slot_gpu;
    }

    public Integer getGpu_cantidad() {
        return gpu_cantidad;
    }

    public void setGpu_cantidad(Integer gpu_cantidad) {
        this.gpu_cantidad = gpu_cantidad;
    }

    public String getTipo_sata() {
        return tipo_sata;
    }

    public void setTipo_sata(String tipo_sata) {
        this.tipo_sata = tipo_sata;
    }

    public Integer getCantidad_sata() {
        return cantidad_sata;
    }

    public void setCantidad_sata(Integer cantidad_sata) {
        this.cantidad_sata = cantidad_sata;
    }

    public Integer getMdos_cantidad() {
        return mdos_cantidad;
    }

    public void setMdos_cantidad(Integer mdos_cantidad) {
        this.mdos_cantidad = mdos_cantidad;
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

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
