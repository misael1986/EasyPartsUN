package com.example.backend.models;

import javax.persistence.*;

@Entity
public class Torre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Long procesador_id;
    @Column
    private Long board_id;
    @Column
    private Long grafica_id;
    @Column
    private Integer cant_grafica;
    @Column
    private Long ram_id;
    @Column
    private Integer cant_ram;
    @Column
    private String ids_discos;
    @Column
    private String cant_discos;
    @Column
    private Long gabinete_id;
    @Column
    private Long powersource_id;
    @Column()
    private String email;
    @Column
    private String proposito;
    @Column
    private Long preciototal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getProcesador_id() {
        return procesador_id;
    }

    public void setProcesador_id(Long procesador_id) {
        this.procesador_id = procesador_id;
    }

    public Long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Long board_id) {
        this.board_id = board_id;
    }

    public Long getGrafica_id() {
        return grafica_id;
    }

    public void setGrafica_id(Long grafica_id) {
        this.grafica_id = grafica_id;
    }

    public Integer getCant_grafica() {
        return cant_grafica;
    }

    public void setCant_grafica(Integer cant_grafica) {
        this.cant_grafica = cant_grafica;
    }

    public Long getRam_id() {
        return ram_id;
    }

    public void setRam_id(Long ram_id) {
        this.ram_id = ram_id;
    }

    public Integer getCant_ram() {
        return cant_ram;
    }

    public void setCant_ram(Integer cant_ram) {
        this.cant_ram = cant_ram;
    }

    public String getIds_discos() {
        return ids_discos;
    }

    public void setIds_discos(String ids_discos) {
        this.ids_discos = ids_discos;
    }

    public String getCant_discos() {
        return cant_discos;
    }

    public void setCant_discos(String cant_discos) {
        this.cant_discos = cant_discos;
    }

    public Long getGabinete_id() {
        return gabinete_id;
    }

    public void setGabinete_id(Long gabinete_id) {
        this.gabinete_id = gabinete_id;
    }

    public Long getPowersource_id() {
        return powersource_id;
    }

    public void setPowersource_id(Long powersource_id) {
        this.powersource_id = powersource_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setPreciototal(Long preciototal_id) {
        this.preciototal = preciototal_id;
    }
}
