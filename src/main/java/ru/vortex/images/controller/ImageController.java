package ru.vortex.images.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vortex.images.model.response.ImageResponse;
import ru.vortex.images.service.ImageService;

import java.io.IOException;
import java.util.List;

@RestController()
@CrossOrigin(origins = {"http://localhost:3000" , "https://leafcity.vercel.app", "https://leafcity.ru"})
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping("/{path}/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName, @PathVariable String path) throws IOException {
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageService.getImage(path, imageName));
    }
    @GetMapping("/{path1}/{path2}/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName, @PathVariable String path1, @PathVariable String path2) throws IOException {
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageService.getImage(path1 + "/" + path2, imageName));
    }
    @GetMapping("/{path}/all")
    @ResponseBody
    public ResponseEntity<List<ImageResponse>> getAllImage(@PathVariable String path) throws IOException {
        return ResponseEntity.ok().body(imageService.getAllImages(path));
    }
    @GetMapping("/{path1}/{path2}/all")
    @ResponseBody
    public ResponseEntity<List<ImageResponse>> getAllImage(@PathVariable String path1, @PathVariable String path2) throws IOException {
        return ResponseEntity.ok().body(imageService.getAllImages(path1 + "/"+ path2));
    }
}
