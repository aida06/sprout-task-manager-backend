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
public class SproutIslandTest {

    @Autowired
    private MockMvc mockMvc;

    // ---------- StoreItems ----------
    @Test
    public void retrieveStoreItemsTest() throws Exception {
        mockMvc.perform(get("/storeItems"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void retrieveItemSpriteMapTest() throws Exception {
        mockMvc.perform(get("/storeItems/itemSpriteMap"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap());
    }

    @Test
    public void retrieveItemPriceMapTest() throws Exception {
        mockMvc.perform(get("/storeItems/itemPriceMap"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap());
    }

    @Test
    public void retrieveFrameIndexMapTest() throws Exception {
        mockMvc.perform(get("/storeItems/frameIndexMap"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap());
    }


    // ---------- UserBelongings ----------
    @Test
    public void retrieveUserBelongingsTest() throws Exception {
        mockMvc.perform(get("/userBelongings/users/8")) // 请确认 userId 存在
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void addNewBelongingTest() throws Exception {
        String newBelongingJson = "{\n" +
                "  \"userId\": 2,\n" +
                "  \"itemId\": 1,\n" +
                "  \"locationX\": 5,\n" +
                "  \"locationY\": 8\n" +
                "}";

        mockMvc.perform(post("/userBelongings/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newBelongingJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Item placed successfully!"));
    }

    @Test
    public void updateBelongingTest() throws Exception {
        long belongingId = 126;
        String updateJson = "{ \"locationX\": 10, \"locationY\": 12 }";

        mockMvc.perform(put("/userBelongings/update/" + belongingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Belonging updated successfully!"));
    }

    @Test
    public void deleteBelongingTest() throws Exception {
        long belongingId = 126;

        mockMvc.perform(delete("/userBelongings/delete/" + belongingId))
                .andExpect(status().isOk())
                .andExpect(content().string("Item deleted successfully!"));
    }


}


