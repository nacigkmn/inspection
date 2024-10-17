package com.example.inspection.controller;

import com.example.inspection.entity.Inspection;
import com.example.inspection.entity.Photo;
import com.example.inspection.service.InspectionService;
import com.example.inspection.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inspections")
public class InspectionController {

    @Autowired
    private InspectionService inspectionService;

    @Autowired
    private PhotoService photoService;


    @PostMapping
    public ResponseEntity<Inspection> createOrSaveInspetion(@RequestBody Inspection inspection) {
        return new ResponseEntity<>(inspectionService.createInspection(inspection), HttpStatus.OK);
    }

    // Get an inspection by ID
    @GetMapping("/{id}")
    public Optional<Inspection> getInspectionById(@PathVariable int id) {
        return inspectionService.getInspectionById(id);
    }

    // Delete an inspection by ID
    @DeleteMapping("/{id}")
    public void deleteInspection(@PathVariable int id) {
        inspectionService.deleteInspection(id);
    }

    @PostMapping("/{inspectionId}/photos")
    public void addPhotoToInspection(@PathVariable int inspectionId, @RequestBody Photo photo) {
        Optional<Inspection> optionalInspection = inspectionService.getInspectionById(inspectionId);
        if (optionalInspection.isPresent()) {
            Inspection inspection = optionalInspection.get();
            photo.setInspection(inspection);
            photoService.savePhoto(inspectionId,photo);
        }
        throw new RuntimeException("Inspection with id {} not found" + inspectionId);
    }


    @GetMapping("/{inspectionId}/photos")
    public  List<Photo> getPhotosForInspection(@PathVariable int inspectionId){
        Optional<Inspection> optionalInspection = inspectionService.getInspectionById(inspectionId);

        if(optionalInspection.isPresent()){
            optionalInspection.get();
        }
        throw new RuntimeException("Inspection not found");
    }
}
