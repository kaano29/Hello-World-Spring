package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void sayHello_noArgs_returnsHelloWorld() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void sayHello_withArgs_returnsHelloName() throws Exception {
        mockMvc.perform(get("/hello?name=Kaan"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Kaan"));
    }

    @Test
    void calculateAddition_withArgs_returnsComputedValue() throws Exception {
        mockMvc.perform(get("/calculate?numbers=5,5&operator=+"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    void calculateDivide_withArgs_returnsComputedValue() throws Exception {
        mockMvc.perform(get("/calculate?numbers=10,5&operator=/"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    void countVowels_ofArgs() throws Exception {
        mockMvc.perform(get("/vowels?word=Magermilchjoghurt"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void postSearchAndReplace() throws Exception {
        mockMvc.perform(post("/body?words=Magermilchjoghurt,Test")
                        .content(
                                "xxxMagermilchjoghurtxxx"
                        ))
                .andExpect(status().isOk())
                .andExpect(content().string("xxxTestxxx"));
    }


}
