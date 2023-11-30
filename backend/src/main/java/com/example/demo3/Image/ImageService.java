package com.example.demo3.Image;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<String> getImageUrlsByPid(Long pid) {
        List<String> imageUrls = imageRepository.findUrlsByPid(pid);
        // Optionally, you can add additional logic or validation here.
        return imageUrls;
    }

    public void addNewImage(long pid, String url) {
        Images newImage = new Images();
        newImage.setPid(pid);
        newImage.setUrl(url);
        imageRepository.save(newImage);
    }
}
