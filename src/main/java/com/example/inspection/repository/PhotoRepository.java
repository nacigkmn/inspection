package com.example.inspection.repository;

import com.example.inspection.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo,Integer> {


    List<Photo> findPhotosByInspectionId(int inspectionId);
}
