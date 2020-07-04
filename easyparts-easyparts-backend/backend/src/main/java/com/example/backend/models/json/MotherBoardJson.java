package com.example.backend.models.json;

import com.example.backend.models.MotherBoard;
import com.example.backend.models.filtros.FiltrosMotherBoard;

import java.util.List;

public class MotherBoardJson {

    private FiltrosMotherBoard filtros;
    private List<MotherBoard> motherBoards;

    public MotherBoardJson(FiltrosMotherBoard filtros, List<MotherBoard> motherBoards) {
        this.filtros = filtros;
        this.motherBoards = motherBoards;
    }

    public FiltrosMotherBoard getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosMotherBoard filtros) {
        this.filtros = filtros;
    }

    public List<MotherBoard> getMotherBoards() {
        return motherBoards;
    }

    public void setMotherBoards(List<MotherBoard> motherBoards) {
        this.motherBoards = motherBoards;
    }
}
