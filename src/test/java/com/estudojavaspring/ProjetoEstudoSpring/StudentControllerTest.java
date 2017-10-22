package com.estudojavaspring.ProjetoEstudoSpring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Crisley on 20/09/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listagem() throws Exception {
        this.mockMvc.perform(get("/students")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Autowired
    ObjectMapper objectMapper;

//    @Test
//    public void insertStudent() throws Exception {
//
////        Student found = new Student(1,"João","Sistemas");
////
////        this.mockMvc.perform(post("/students/insert/")
////                .content(objectMapper.writeValueAsString(found))
////                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
////                .andExpect(status().isOk())
////                .andExpect(content().string(containsString("foi")));
//
//    }
//
//    @Test
//    public void updateStudent() throws Exception {
//
////        Student found = new Student(1,"João","Sistemas");
////        Gson gson = new Gson();
////
////        this.mockMvc.perform(put("/students/update/")
////                .content(objectMapper.writeValueAsString(found))
////                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
////                .andExpect(status().isOk())
////                .andExpect(content().string(containsString("foi")));
//
//    }
//
//    @Test
//    public void getStudentById() throws Exception {
//
////        Student found = new Student(1,"João","Sistemas");
//
////        this.mockMvc.perform(get("/students/{id}", found.getId())
////                .contentType(MediaType.APPLICATION_JSON_UTF8))
////                .andExpect(status().isOk())
////                .andExpect(content().string(containsString("id")))
////                .andExpect(content().string(containsString("nome")))
////                .andExpect(content().string(containsString("course")));
////    }
//
//    @Test
//    public void deleteStudentById() throws Exception {
////        Student found = new Student(1,"João","Sistemas");
////        this.mockMvc.perform(delete("/students/remove/{id}", found.getId())
////                .contentType(MediaType.APPLICATION_JSON_UTF8))
////                .andExpect(status().isOk());
////    }


}
