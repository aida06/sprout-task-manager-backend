package com.example.projectcoding0.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    // Register user
    @Test
    public void registerUserTest() throws Exception {
        String json = "{ \"username\": \"testuser2\", \"password\": \"12345678\" }";

        mockMvc.perform(post("/user/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("User registered successfully"));
    }

    // Login user
    @Test
    public void loginUserTest() throws Exception {
        String json = "{ \"username\": \"testuser123\", \"password\": \"12345678\" }";

        mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Login successful"));
    }

    // Retrieve user coins
    @Test
    public void retrieveUserCoinsTest() throws Exception {
        mockMvc.perform(get("/user/coins")
                        .param("userId", "8"))
                .andExpect(status().isOk());
    }

    // Update user coins
    @Test
    public void updateUserCoinsTest() throws Exception {
        String json = "{ \"userId\": 2, \"rewardCoins\": 10.0 }";

        mockMvc.perform(post("/user/updateCoins")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("User coins updated successfully"));
    }


}

