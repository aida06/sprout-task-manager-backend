package com.example.projectcoding0.test;

import com.example.projectcoding0.ProjectCoding0Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ProjectCoding0Application.class)
@AutoConfigureMockMvc
public class FocusTimerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveFocusTimerTest() throws Exception {
        String focusTimerJson = "{\n" +
                "  \"userId\": 2,\n" +
                "  \"taskName\": \"Write Report\",\n" +
                "  \"duration\": 25,\n" +
                "  \"successful\": true,\n" +
                "  \"startTime\": \"2025-04-02T10:00:00\",\n" +
                "  \"endTime\": \"2025-04-02T10:25:00\"\n" +
                "}";

        mockMvc.perform(post("/focusTimer/saveFocus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(focusTimerJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Focus timer saved successfully"));
    }

    @Test
    public void retrieveFocusTimerTest() throws Exception {
        mockMvc.perform(get("/focusTimer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}

