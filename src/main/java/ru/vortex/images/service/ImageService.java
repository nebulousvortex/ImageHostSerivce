package ru.vortex.images.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import ru.vortex.images.model.response.ImageResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ImageService {

    @Autowired
    ResourcePatternResolver resourcePatternResolver;
    public byte[] getImage(String path, String imageName) throws IOException {
        var imgFile = new ClassPathResource("images/" + path +'/'+ imageName + ".webp");
        return StreamUtils.copyToByteArray(imgFile.getInputStream());
    }

    public List<ImageResponse> getAllImages(String path) throws IOException {
        String pattern = "classpath:images/" + path + "/*.webp";
        Resource[] resources = resourcePatternResolver.getResources(pattern);
        List<ImageResponse> images = new ArrayList<>();

        for (Resource resource : resources) {
            var fileName = Objects.requireNonNull(resource.getFilename()).replace(".webp", "");
            var filePath = "https://leafcity.ru/api/v1/fs/images/" + path + "/" + fileName;
            images.add(new ImageResponse(filePath, fileName.substring(0, fileName.indexOf('-'))));
        }
        return  images;
    }
}
