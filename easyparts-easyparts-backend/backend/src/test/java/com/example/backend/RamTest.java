package com.example.backend;

import com.example.backend.models.Ram;
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
class RamTest {

    private static final Logger logger = LoggerFactory.getLogger(RamTest.class);

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
    public void deberiaAgregarUnaRam() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n" +
                "    \"id\": null,\n" +
                "    \"nombre\": \"nombreX\",\n" +
                "    \"modelo\": \"modeloX\",\n" +
                "    \"marca\": \"marcaX\",\n" +
                "    \"capacidad\": \"-8GB\",\n" +
                "    \"velocidad\": 0 ,\n" +
                "    \"tecnologia\": \"tecnologiaX\",\n" +
                "    \"linkinfo\": \"linkX\",\n" +
                "    \"potencia_max\": \"5\",\n" +
                "    \"imagen\": \"imagenX\",\n" +
                "    \"precio\": \"180028\"\n" +
                "}";
        Ram ram = mapper.readValue(json, Ram.class);

        String response = mockMvc.perform(post("/api/v1/ram/save/")
                .content(objectmapper.writeValueAsString(ram))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //logger.info(response);
    }

    @Test
    @Order(2)
    public void deberiaMostrarTodosRam() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/ram/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andExpect(jsonPath("$.[*].marca").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(3)
    public void deberiaMostrarRamPorTecnologia() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/ram/tecnologia/{tecnologia}/", "tecnologiaX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);

        //Guardo respuesta para obtener el Id para luego borrarlo
        String json=response.substring(1,response.length()-1);
        ObjectMapper mapper = new ObjectMapper();
        Ram ram = mapper.readValue(json, Ram.class);
        newId=ram.getId();
    }

    @Test
    @Order(4)
    public void deberiaMostrarRamPorId() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/ram/find/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(5)
    public void deberiaMostrarRamPorPotencia() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/ram/capacidad/{capacidad}/", "-8GB"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(6)
    public void deberiaBorrarRamCreada() throws Exception{
        String response = this.mockMvc.perform(delete("/api/v1/ram/delete/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();

        //logger.info("response: " + response);
    }
}
