package com.example.inspection.service;


import com.example.inspection.entity.Inspection;
import com.example.inspection.entity.Photo;
import com.example.inspection.repository.InspectionRepository;
import com.example.inspection.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private InspectionRepository inspectionRepository;

    public Photo savePhoto(int inspectionId,Photo photo){

        Inspection inspection = inspectionRepository.findById(inspectionId)
                .orElseThrow(()-> new RuntimeException("Inspection not forun"));
        photo.setInspection(inspection);

        return photoRepository.save(photo);
    }

    public Photo updatePhoto(int id,Photo photo){
        if(photoRepository.existsById(id)){
            photo.setPhotoId(id);
            photoRepository.save(photo);
        }
        throw new RuntimeException("Photo not found");
    }

    // Delete a photo
    public void deletePhoto(int id) {
        if (photoRepository.existsById(id)) {
            photoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Photo not found");
        }
    }

    public  Photo getPhotoById(int id){
        Optional<Photo> optionalPhoto = photoRepository.findById(id);
        return optionalPhoto.orElseThrow(()-> new RuntimeException("Photo nor Found"));
    }

    // Get all photos
    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }


    public  List<Photo> getPhotosByInspection(int inspectionId){
        return photoRepository.findPhotosByInspectionId(inspectionId);
    }

}
