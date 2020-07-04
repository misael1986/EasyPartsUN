package com.example.backend;

import com.example.backend.models.Procesador;
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
public class ProcesadorTest {


    private static final Logger logger = LoggerFactory.getLogger(ProcesadorTest.class);

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
    public void deberiaAgregarUnProcesador() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n" +
                "        \"id\": 1,\n" +
                "        \"nombre\": \"nombreX\",\n" +
                "        \"modelo\": \"modeloX\",\n" +
                "        \"marca\": \"marcaX\",\n" +
                "        \"num_nucleos\": \"num_nucleosX\",\n" +
                "        \"frecuencia\": \"frecuenciaX\",\n" +
                "        \"pcache\": \"pcacheX\",\n" +
                "        \"grafica_integrada\": \"grafica_integradaX\",\n" +
                "        \"psocket\": \"psocketX\",\n" +
                "        \"linkinfo\": \"linkinfoX\",\n" +
                "        \"potencia_max\": 0,\n" +
                "        \"imagen\": \"imagenX\",\n" +
                "        \"precio\": 0\n" +
                "    }";
        Procesador procesador = mapper.readValue(json, Procesador.class);

        String response = mockMvc.perform(post("/api/v1/procesador/save/")
                .content(objectmapper.writeValueAsString(procesador))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //logger.info(response);
    }

    @Test
    @Order(2)
    public void deberiaMostrarTodosProcesadores() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/procesador/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andExpect(jsonPath("$.[*].marca").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(3)
    public void deberiaMostrarProcesadorPorMarca() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/procesador/marca/{marca}/", "marcaX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);

        //Guardo respuesta para obtener el Id para luego borrarlo
        String json=response.substring(1,response.length()-1);
        ObjectMapper mapper = new ObjectMapper();
        Procesador procesador = mapper.readValue(json, Procesador.class);
        newId=procesador.getId();
    }

    @Test
    @Order(4)
    public void deberiaMostrarProcesadorPorId() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/procesador/find/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
        System.out.println(response);
    }

    @Test
    @Order(5)
    public void deberiaMostrarMotherBoardPorSocket() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/procesador/socket/{socket}/", "psocketX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(6)
    public void deberiaBorrarProcesadorCreado() throws Exception{
        String response = this.mockMvc.perform(delete("/api/v1/procesador/delete/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();

        //logger.info("response: " + response);
    }
}
