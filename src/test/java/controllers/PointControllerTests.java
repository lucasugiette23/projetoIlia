package controllers;

import com.ilia.projeto.controller.PointController;
import com.ilia.projeto.models.Ponto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Bater ponto - Controller")
@RunWith(SpringRunner.class)
public class PointControllerTests {

    @Autowired
    private MockMvc mockMvc;
    private PointController pointController;


    public static final String ERROR_TEST = "Ocorreu um erro ao efetuar o teste do ponto: ";
    public static final String URL = "/ponto/bater-ponto/";

    @Test()
    @DisplayName("Deve ser concluído com sucesso")
    public void test() throws Exception {
        mockMvc.perform(get(URL.concat("1/FIRSTINTYPE"))
                .header("Origin", "*")
                .contentType(String.valueOf(HttpStatus.UNAUTHORIZED))
                .content(String.valueOf(ResponseEntity.status(HttpStatus.UNAUTHORIZED))))
                .andExpect(content().string(String.valueOf(HttpStatus.UNAUTHORIZED)));
//        ResponseEntity<?> ponto = this.pointController.checkPoint(1L, "FIRSTOUTYPE");
//        assertEquals(HttpStatus.CREATED, ponto.getStatusCode());
    }

    private boolean mountResponseValidDayOfWeek(){
        DayOfWeek d = LocalDate.now().getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY ? false : true;
    }


}

//    private void callRestFailure() throws Exception {
//        mvc.perform(post(URL)
//                .header("Origin", "*")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(gson.toJson(this.mountPayload(false))))
//                .andExpect(content().string(containsString("\"status\":401")));
//
//    }
//
//    private LoginDTO mountPayload(Boolean success) {
//        return LoginDTO.builder()
//                .dealership(success ? "ENERGISA" : "FLEXPAG")
//                .ni("24432296453")
//                .password("123456")
//                .build();
//
//    }
//   this.mockMvc.perform(get("/ponto/bater-ponto/1/FIRSTOUTYPE")
//           .contentType(MediaType.APPLICATION_JSON)
//           .content(String.valueOf(ResponseEntity.status(HttpStatus.CREATED))))
//           .andExpect((ResultMatcher) ResponseEntity.status(HttpStatus.CREATED));