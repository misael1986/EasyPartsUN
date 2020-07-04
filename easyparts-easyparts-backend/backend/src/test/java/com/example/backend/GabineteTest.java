package com.example.backend;

import com.example.backend.models.Gabinete;
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
public class GabineteTest {

    private static final Logger logger = LoggerFactory.getLogger(GabineteTest.class);

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
    public void deberiaAgregarUnGabinete() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n" +
                "    \"id\": null,\n" +
                "    \"nombre\": \"nombreX\",\n" +
                "    \"modelo\": \"modeloX\",\n" +
                "    \"marca\": \"marcaX\",\n" +
                "    \"alto\": \"410\",\n" +
                "    \"largo\": \"180\",\n" +
                "    \"ancho\": \"340\",\n" +
                "    \"motherboards\": \"motherboardX\",\n" +
                "    \"linkinfo\": \"linkX\",\n" +
                "    \"imagen\": \"imagenX\",\n" +
                "    \"precio\": \"146461\"\n" +
                "}";
        Gabinete gabinete = mapper.readValue(json, Gabinete.class);

        String response = mockMvc.perform(post("/api/v1/gabinete/save/")
                .content(objectmapper.writeValueAsString(gabinete))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //logger.info(response);
    }

    @Test
    @Order(2)
    public void deberiaMostrarTodosGabinetes() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/gabinete/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andExpect(jsonPath("$.[*].marca").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(3)
    public void deberiaMostrarGabinetePorBoard() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/gabinete/board/{board}/", "motherboardX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(4)
    public void deberiaMostrarGabinetePorMarca() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/gabinete/marca/{marca}/", "marcaX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);

        //Guardo respuesta para obtener el Id para luego borrarlo
        String json=response.substring(1,response.length()-1);
        ObjectMapper mapper = new ObjectMapper();
        Gabinete gabinete = mapper.readValue(json, Gabinete.class);
        newId=gabinete.getId();
    }

    @Test
    @Order(5)
    public void deberiaMostrarGabinetePorId() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/gabinete/find/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(6)
    public void deberiaBorrarGabineteCreada() throws Exception{
        String response = this.mockMvc.perform(delete("/api/v1/gabinete/delete/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();

        //logger.info("response: " + response);
    }
}
