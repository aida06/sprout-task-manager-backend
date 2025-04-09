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
public class TaskTest {

    @Autowired
    private MockMvc mockMvc;

    // Create Task Test
    @Test
    public void createTaskTest() throws Exception {
        String newTaskJson = "{\n" +
                "  \"taskName\": \"Test Task\",\n" +
                "  \"importance\": 3,\n" +
                "  \"urgency\": 2,\n" +
                "  \"taskTag\": \"Test\",\n" +
                "  \"description\": \"JUnit test\",\n" +
                "  \"rewardCoins\": 5.0,\n" +
                "  \"focusTime\": 10,\n" +
                "  \"userId\": 2\n" +
                "}";

        mockMvc.perform(post("/task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTaskJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Task created successfully!"));
    }

    // Delete Task
    @Test
    public void deleteTaskTest() throws Exception {
        int taskId = 34;
        mockMvc.perform(delete("/task/delete")
                        .param("taskId", String.valueOf(taskId)))
                .andExpect(status().isOk())
                .andExpect(content().string("Task deleted successfully"));
    }

    // Retrieve Task
    @Test
    public void retrieveTaskTest() throws Exception {
        mockMvc.perform(get("/task/users/8")) // Ensure that userId=8 exists
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    // Update Task
    @Test
    public void updateTaskTest() throws Exception {
        String updatedTaskJson = "{\n" +
                "  \"taskId\": 1,\n" +
                "  \"taskName\": \"Updated Task\",\n" +
                "  \"importance\": 0,\n" +
                "  \"urgency\": 0,\n" +
                "  \"taskTag\": \"Test\",\n" +
                "  \"description\": \"Updated via JUnit\",\n" +
                "  \"rewardCoins\": 5.0,\n" +
                "  \"focusTime\": 20,\n" +
                "  \"userId\": 2\n" +
                "}";

        mockMvc.perform(put("/task/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedTaskJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Task updated successfully"));
    }

}

