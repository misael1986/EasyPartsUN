package com.example.backend.models.filtros;

import java.util.List;

public class FiltrosMotherBoard {

    private List<String> marca;
    private List<String> categoria;
    private List<String> slot_ram;
    private List<Float> slot_gpu;

    public FiltrosMotherBoard(List<String> marca, List<String> categoria, List<String> slot_ram, List<Float> slot_gpu) {
        this.marca = marca;
        this.categoria = categoria;
        this.slot_ram = slot_ram;
        this.slot_gpu = slot_gpu;
    }

    public List<String> getMarca() {
        return marca;
    }

    public void setMarca(List<String> marca) {
        this.marca = marca;
    }

    public List<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<String> categoria) {
        this.categoria = categoria;
    }

    public List<String> getSlot_ram() {
        return slot_ram;
    }

    public void setSlot_ram(List<String> slot_ram) {
        this.slot_ram = slot_ram;
    }

    public List<Float> getSlot_gpu() {
        return slot_gpu;
    }

    public void setSlot_gpu(List<Float> slot_gpu) {
        this.slot_gpu = slot_gpu;
    }
}
