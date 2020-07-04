package com.example.backend.models.filtros;

import java.util.List;

public class FiltrosGabinete {

    private List<String> marca;
    private List<String> motherboards;

    public FiltrosGabinete(List<String> marca, List<String> motherboards) {
        this.marca = marca;
        this.motherboards = motherboards;
    }

    public List<String> getMarca() {
        return marca;
    }

    public void setMarca(List<String> marca) {
        this.marca = marca;
    }

    public List<String> getMotherboards() {
        return motherboards;
    }

    public void setMotherboards(List<String> motherboards) {
        this.motherboards = motherboards;
    }
}
