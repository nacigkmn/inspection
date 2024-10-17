package com.example.inspection.controller;

import com.example.inspection.entity.Photo;
import com.example.inspection.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/addPhoto")
    public ResponseEntity<Photo> savePhoto(@RequestBody Photo photo, @RequestParam int inspectionId){
        Photo savedPhoto = photoService.savePhoto(inspectionId,photo);
        return  ResponseEntity.ok(savedPhoto);
    }
}
