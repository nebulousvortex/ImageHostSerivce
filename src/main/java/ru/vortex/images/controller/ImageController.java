package ru.vortex.images.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController()
@CrossOrigin(origins = {"http://localhost:3000" , "https://leafcity.vercel.app", "https://leafcity.ru"})
@RequestMapping("/images")
public class ImageController {

    @GetMapping("/{path}/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName, @PathVariable String path) throws IOException {

        var imgFile = new ClassPathResource("images/" + path +'/'+ imageName + ".webp");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }
    @GetMapping("/{path1}/{path2}/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName, @PathVariable String path1, @PathVariable String path2) throws IOException {

        var imgFile = new ClassPathResource("images/" + path1 +'/'+ path2 +'/'+ imageName + ".webp");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }
}
