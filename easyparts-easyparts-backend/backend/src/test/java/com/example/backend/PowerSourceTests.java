package com.example.backend;

import com.example.backend.models.PowerSource;
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
class PowerSourceTests {

    private static final Logger logger = LoggerFactory.getLogger(PowerSourceTests.class);

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
    public void deberiaAgregarUnaPowerSource() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n" +
                "        \"id\": null,\n" +
                "        \"nombre\": \"nombreX\",\n" +
                "        \"modelo\": \"modeloX\",\n" +
                "        \"marca\": \"marcaX\",\n" +
                "        \"potencia\": -600,\n" +
                "        \"certificacion\": \"certificacionX\",\n" +
                "        \"linkinfo\": \"linkX\",\n" +
                "        \"imagen\": \"imagenX\",\n" +
                "        \"precio\": \"500\"\n" +
                "    }";
        PowerSource powerSource = mapper.readValue(json, PowerSource.class);

        String response = mockMvc.perform(post("/api/v1/powerSource/save/")
                .content(objectmapper.writeValueAsString(powerSource))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //logger.info(response);
    }

    @Test
    @Order(2)
    public void deberiaMostrarTodosPowerSource() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/powerSource/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andExpect(jsonPath("$.[*].marca").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(3)
    public void deberiaMostrarPowerSourcePorPotencia() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/powerSource/potencia/{potencia}/", -600))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(4)
    public void deberiaMostrarPowerSourcePorCertificacion() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/powerSource/certificacion/{certificacion}/", "certificacionX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);

        //Guardo respuesta para obtener el Id para luego borrarlo
        String json=response.substring(1,response.length()-1);
        ObjectMapper mapper = new ObjectMapper();
        PowerSource powerSource = mapper.readValue(json, PowerSource.class);
        newId=powerSource.getId();
    }

    @Test
    @Order(5)
    public void deberiaMostrarPowerSourcePorId() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/powerSource/find/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(6)
    public void deberiaBorrarPowerSourceCreada() throws Exception{
        String response = this.mockMvc.perform(delete("/api/v1/powerSource/delete/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();

        //logger.info("response: " + response);
    }
}
