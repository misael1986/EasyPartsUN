package com.example.backend;

import com.example.backend.models.TarjetaVideo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TarjetaVideoTest {

    private static final Logger logger = LoggerFactory.getLogger(TarjetaVideoTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectmapper;

    @Autowired
    private static Long newId;

    /*@Test
    void contextLoads() {
    }*/

    @Test
    @Order(1)
    public void deberiaAgregarUnaTarjetaVideo() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n" +
                "        \"id\": 1,\n" +
                "        \"nombre\": \"nombreX\",\n" +
                "        \"modelo\": \"modeloX\",\n" +
                "        \"marca\": \"marcaX\",\n" +
                "        \"pci_express\": 0,\n" +
                "        \"tipo_memoria\": \"tipo_memoriaX\",\n" +
                "        \"capacidad_memoria\": 0,\n" +
                "        \"proposito\": \"propositoX\",\n" +
                "        \"link\": \"linkX\",\n" +
                "        \"imagen\": \"imagenX\",\n" +
                "        \"potencia_max\": 0,\n" +
                "        \"precio\": 0\n" +
                "    }";
        TarjetaVideo tarjetaVideo = mapper.readValue(json, TarjetaVideo.class);

        String response = mockMvc.perform(post("/api/v1/tarjetavideo/save/")
                .content(objectmapper.writeValueAsString(tarjetaVideo))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //logger.info(response);
    }

    @Test
    @Order(2)
    public void deberiaMostrarTodasGraficas() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/tarjetavideo/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andExpect(jsonPath("$.[*].marca").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(3)
    public void deberiaMostrarGraficaPorPuerto() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/tarjetavideo/puerto/{pci_express}/", 0))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(4)
    public void deberiaMostrarGraficasPorMarca() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/tarjetavideo/marca/{marca}/", "marcaX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);

        //Guardo respuesta para obtener el Id para luego borrarlo
        String json=response.substring(1,response.length()-1);
        ObjectMapper mapper = new ObjectMapper();
        TarjetaVideo tarjetaVideo = mapper.readValue(json, TarjetaVideo.class);
        newId=tarjetaVideo.getId();
    }

    @Test
    @Order(5)
    public void deberiaMostrarGraficaPorId() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/tarjetavideo/find/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(6)
    public void deberiaMostrarGraficaPorMemoria() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/tarjetavideo/tipomemoria/{tipo_memoria}/", "tipo_memoriaX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(7)
    public void deberiaBorrarGraficaCreada() throws Exception{
        String response = this.mockMvc.perform(delete("/api/v1/tarjetavideo/delete/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();

        //logger.info("response: " + response);
    }

}
