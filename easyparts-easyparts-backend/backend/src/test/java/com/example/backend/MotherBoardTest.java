package com.example.backend;

import com.example.backend.models.MotherBoard;
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
public class MotherBoardTest {

    private static final Logger logger = LoggerFactory.getLogger(MotherBoardTest.class);

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
    public void deberiaAgregarUnaMotherBoard() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n" +
                "        \"id\": 1,\n" +
                "        \"nombre\": \"nombreX\",\n" +
                "        \"modelo\": \"modeloX\",\n" +
                "        \"marca\": \"marcaX\",\n" +
                "        \"categoria\": \"categoriaX\",\n" +
                "        \"msocket\": \"msocketX\",\n" +
                "        \"slot_ram\": \"slot_ramX\",\n" +
                "        \"ram_cantidad\": \"-4\",\n" +
                "        \"slot_gpu\": \"-3.0\",\n" +
                "        \"gpu_cantidad\": \"-4\",\n" +
                "        \"tipo_sata\": \"tipo_sataX\",\n" +
                "        \"cantidad_sata\": \"-4\",\n" +
                "        \"mdos_cantidad\": \"-4\",\n" +
                "        \"link\": \"linkX\",\n" +
                "        \"imagen\": \"imagenX\",\n" +
                "        \"precio\": \"-1000000\"\n" +
                "    }";
        MotherBoard motherBoard = mapper.readValue(json, MotherBoard.class);

        String response = mockMvc.perform(post("/api/v1/motherboard/save/")
                .content(objectmapper.writeValueAsString(motherBoard))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //logger.info(response);
    }

    @Test
    @Order(2)
    public void deberiaMostrarTodosMotherBoards() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/motherboard/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andExpect(jsonPath("$.[*].marca").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(3)
    public void deberiaMostrarMotherBoardPorSocket() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/motherboard/socket/{socket}/", "msocketX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(4)
    public void deberiaMostrarMotherBoardPorMarca() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/motherboard/marca/{marca}/", "marcaX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);

        //Guardo respuesta para obtener el Id para luego borrarlo
        String json=response.substring(1,response.length()-1);
        ObjectMapper mapper = new ObjectMapper();
        MotherBoard motherBoard = mapper.readValue(json, MotherBoard.class);
        newId=motherBoard.getId();
    }

    @Test
    @Order(5)
    public void deberiaMostrarMotherBoardPorId() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/motherboard/find/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }



    @Test
    @Order(6)
    public void deberiaMostrarMotherBoardPorCategoria() throws Exception {
        String response = this.mockMvc.perform(get("/api/v1/motherboard/categoria/{categoria}/", "categoriaX"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();
        //logger.info("response: " + response);
    }

    @Test
    @Order(7)
    public void deberiaBorrarMotherBoardCreada() throws Exception{
        String response = this.mockMvc.perform(delete("/api/v1/motherboard/delete/{id}/", newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("nombreX")))
                .andReturn().getResponse().getContentAsString();

        //logger.info("response: " + response);
    }
}