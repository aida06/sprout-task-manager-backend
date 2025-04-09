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
public class ScheduleTest {

    @Autowired
    private MockMvc mockMvc;

    // 创建提醒
    @Test
    public void createReminderTest() throws Exception {
        String json = "{\n" +
                "  \"title\": \"Test Reminder\",\n" +
                "  \"startTime\": \"2025-04-02T15:00:00+08:00\",\n" +
                "  \"duration\": 1800,\n" +
                "  \"remindBefore\": 0,\n" +
                "  \"userId\": 2\n" +
                "}";

        mockMvc.perform(post("/schedule/createReminder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Schedule created successfully!"));
    }

    // 更新提醒
    @Test
    public void updateReminderTest() throws Exception {
        String json = "{\n" +
                "  \"scheduleId\": 10,\n" +
                "  \"title\": \"Updated Reminder\",\n" +
                "  \"startTime\": \"2025-04-02T16:00:00+08:00\",\n" +
                "  \"duration\": 1500,\n" +
                "  \"remindBefore\": 5,\n" +
                "  \"userId\": 2\n" +
                "}";

        mockMvc.perform(put("/schedule/updateReminder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Schedule updated successfully!"));
    }

    // 删除提醒
    @Test
    public void deleteReminderTest() throws Exception {
        long id = 12;        //
        mockMvc.perform(delete("/schedule/deleteReminder/" + id))
                .andExpect(status().isOk())
                .andExpect(content().string("Schedule deleted successfully!"));
    }

    // 查询所有提醒
    @Test
    public void retrieveScheduleTest() throws Exception {
        mockMvc.perform(get("/schedule"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}


