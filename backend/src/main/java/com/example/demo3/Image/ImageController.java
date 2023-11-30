package com.example.demo3.Image;

import com.example.demo3.Image.RequestClasses.AddImageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    // add new image
    @PostMapping(path = "/add")
    public void AddImage(@RequestBody AddImageRequest request){

        long pid = request.getPid();
        String url = request.getUrl();
        imageService.addNewImage(pid,url);

    }
    // get images by pid
    @PutMapping(path = "/getImages")
    public List<String> getImageByPid(@RequestBody Map<String,Long> requestBody) {
        Long pid = requestBody.get("pid");
        return imageService.getImageUrlsByPid(pid);
    }
}
