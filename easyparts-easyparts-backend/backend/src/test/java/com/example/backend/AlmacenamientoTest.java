package com.example.backend;

import com.example.backend.models.Almacenamiento;
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
public class AlmacenamientoTest {

    private static final Logger logger = LoggerFactory.getLogger(Almacenamiento.class);

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
    public void deberiaAgregarUnAlmacenamiento() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n" +
                "    \"id\": null,\n" +
                "    \"nombre\": \"nombreX\",\n" +
                "    \"modelo\": \"modeloX\",\n" +
                "    \"marca\": \"marcaX\",\n" +
                "    \"capacidad\": \"-240GB\",\n" +
                "    \"tecnologia\": \"tecnologiaX\",\n" +
                "    \"puerto\": \"puertoX\",\n" +
                "    \"velocidad_lectura\": \"555 MB/s\",\n" +
                "    \"velocidad_escritura\": \"540 MB/s\",\n" +
                "    \"linkinfo\": \"linkX\",\n" +
                "    \"potencia_max\": 1.7,\n" +
                "    \"imagen\": \"imagenX\",\n" +
                "    \"precio\": \"188350\"\n" +
                "}";
        Almacenamiento almacenamiento = mapper.readValue(json, Almacenamiento.class);

        String response = mockMvc.perform(post("/api/v1/almacenamiento/save/")
                .content(objectmapper.writeValueAsString(almacenamiento))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //logger.info(response);
    }

    @Test
    @Order(2)
    public void deberiaMostrarTodosAlmacenamiento() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/almacenamiento/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andExpect(jsonPath("$.[*].marca").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(3)
    public void deberiaMostrarAlmacenamientoPorPuerto() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/almacenamiento/puerto/{puerto}/", "puertoX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(4)
    public void deberiaMostrarAlmacenamientoPorTecnologia() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/almacenamiento/tecnologia/{tecnologia}/", "tecnologiaX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);

        //Guardo respuesta para obtener el Id para luego borrarlo
        String json=response.substring(1,response.length()-1);
        ObjectMapper mapper = new ObjectMapper();
        Almacenamiento almacenamiento = mapper.readValue(json, Almacenamiento.class);
        newId=almacenamiento.getId();
    }

    @Test
    @Order(5)
    public void deberiaMostrarAlmacenamientoPorId() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/almacenamiento/find/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(6)
    public void deberiaMostrarAlmacenamientoPorCapacidad() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/almacenamiento/capacidad/{capacidad}/", "-240GB"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(7)
    public void deberiaBorrarAlmacenamientoCreada() throws Exception{
        String response = this.mockMvc.perform(delete("/api/v1/almacenamiento/delete/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();

        //logger.info("response: " + response);
    }
}
