package com.example.springbootecom;

import com.example.springbootecom.controller.AlbumController;
import com.example.springbootecom.dto.AlbumDTO;
import com.example.springbootecom.service.AlbumService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(AlbumController.class)
class SpringBootEcomApplicationTests {

    @MockBean
    private AlbumService albumService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnListOfAlbums() throws Exception {

        when(albumService.findAllAlbums()).thenReturn(List.of(
                new AlbumDTO(1,"Dark Side of the Moon","Pink Floyd", LocalDate.parse("1966-11-07"),19.99),
                new AlbumDTO(2,"Abbey Road","The Beatles",LocalDate.parse("1969-12-08"),19.99),
                new AlbumDTO(2,"Hunky Dory","David Bowie",LocalDate.parse("1969-12-08"),19.99)));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/album"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)))
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].albumTitle").value("Dark Side of the Moon"));
    }

    @Test
    void shouldAddNewAlbum() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/album")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"albumID\":\"1\",\"albumTitle\":\"Abbey Road\",\"artist\":\"The Beatles\",\"releaseDate\":\"07-10-1966\",\"price\":\"19.99\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    void shouldFindSpecificAlbum() throws Exception {

        when(albumService.findAlbumById(2)).thenReturn(new AlbumDTO(2,"Abbey Road","The Beatles",LocalDate.parse("1969-12-08"),19.99));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/album/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("albumTitle").value("Abbey Road"));

    }

    @Test
    void shouldDeleteAlbumByID() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/album/2"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }

}
