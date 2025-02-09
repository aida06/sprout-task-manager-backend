package com.example.projectcoding0.controller;

import com.example.projectcoding0.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ParamController {

    //http: //localhost:8080/hello
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    // 等价于GetMapping("/hello")
    public String get (String nickname, String age) {
        System.out.println(age);
        return "GET" + nickname + " " + age;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    public String post (String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return "POST";
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String post2 (User user) {
        System.out.println(user);
        return "POST";
    }

    //JSON
    @RequestMapping(value = "/hello4", method = RequestMethod.POST)
    public String post3 (@RequestBody User user) {
        System.out.println(user);
        return "POST";
    }

    @GetMapping("/test/**")
    public String test() {
        return "222";
    }

    @PostMapping("/upload")
    public String up(String username, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(username);
        System.out.println(photo.getOriginalFilename());
        System.out.println(photo.getContentType());
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(path);
        saveFile(photo, path);
        return "upload";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(path + File.separator + photo.getOriginalFilename());

        photo.transferTo(file);

//        // 获取文件名，确保不为空
//        String fileName = photo.getOriginalFilename();
//        if (fileName == null || fileName.isEmpty()) {
//            throw new IOException("Invalid file name.");
//        }
//
//        // 创建目标文件路径
//        Path filePath = new File(dir, fileName).toPath();
//
//        // 将文件保存到指定路径
//        Files.copy(photo.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

    }

}
