package com.example.backend;

import com.example.backend.models.Torre;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TorreTest {

    private static final Logger logger = LoggerFactory.getLogger(TorreTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectmapper;

    @Autowired
    private static Long newId;

    @Test
    @Order(1)
    public void guardarTorre() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n" +
                "        \"id\": 1,\n" +
                "        \"procesador_id\": 1,\n" +
                "        \"board_id\": 1,\n" +
                "        \"grafica_id\": 1,\n" +
                "        \"cant_grafica\": 0,\n" +
                "        \"ram_id\": 1,\n" +
                "        \"cant_ram\": 0,\n" +
                "        \"ids_discos\": \"1\",\n" +
                "        \"cant_discos\": \"1\",\n" +
                "        \"gabinete_id\": 1,\n" +
                "        \"powersource_id\": 1,\n" +
                "        \"email\": \"nuevo@gmail.com\",\n" +
                "        \"proposito\": \"testeo\",\n" +
                "        \"preciototal\": 0\n" +
                "    }";
        Torre torre = mapper.readValue(json, Torre.class);

        String response = mockMvc.perform(post("/api/v1/torre/save/")
                .content(objectmapper.writeValueAsString(torre))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //logger.info(response);
    }

    @Test
    @Order(2)
    public void deberiaMostrarTodosTorresIDs() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/torre/allOnlyIDs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andExpect(jsonPath("$.[*].id").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(3)
    public void deberiaMostrarTodosTorres() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/torre/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andExpect(jsonPath("$.[*].procesador").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(4)
    public void deberiaMostrarTorrePorCorreo() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/torre/correo/{correo}/", "nuevo@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].proposito", is("testeo")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);

        //Guardo respuesta para obtener el Id para luego borrarlo
        String json=response.substring(1,response.length()-1);
        ObjectMapper mapper = new ObjectMapper();
        Torre torre = mapper.readValue(json, Torre.class);
        newId=torre.getId();
    }


    @Test
    @Order(5)
    public void deberiaMostrarTorrePorId() throws Exception {
        //System.out.println("Hola undo "+newId);
        String response = this.mockMvc.perform(get("/api/v1/torre/find/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.proposito", is("testeo")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(6)
    public void deberiaMostrarTorrePorIdJson() throws Exception {
        //System.out.println("Hola undo "+newId);
        String response = this.mockMvc.perform(get("/api/v1/torre/findjson/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.proposito", is("testeo")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(7)
    public void deberiaMostrarTorrePorProposito() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/torre/proposito/{proposito}", "testeo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].proposito", is("testeo")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(8)
    public void deberiaBorrarTorreCreada() throws Exception{
        String response = this.mockMvc.perform(delete("/api/v1/torre/delete/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.proposito", is("testeo")))
                .andReturn().getResponse().getContentAsString();

        //logger.info("response: " + response);
    }


}
