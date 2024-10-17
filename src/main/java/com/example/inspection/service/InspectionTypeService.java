package com.example.inspection.service;


import com.example.inspection.entity.InspectionType;
import com.example.inspection.repository.InspectionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InspectionTypeService {

    @Autowired
    private InspectionTypeRepository inspectionTypeRepository;

    public InspectionType createInspectionType(InspectionType inspectionType) {
        return inspectionTypeRepository.save(inspectionType);
    }

    public List<InspectionType> getAllInspectionTypes() {
        return inspectionTypeRepository.findAll();
    }

    public Optional<InspectionType> getInspectionTypeById(int id) {
        return inspectionTypeRepository.findById(id);
    }

    public InspectionType updateInspectionType(int id, InspectionType updatedInspectionType) {
        return inspectionTypeRepository.findById(id)
                .map(inspectionType -> {
                    inspectionType.setInspectionName(updatedInspectionType.getInspectionName());
                    return inspectionTypeRepository.save(inspectionType);
                })
                .orElseThrow(()-> new IllegalArgumentException("Inspection type with id {} not found"+id));
    }

    public void deleteInspectionType(int id) {
        inspectionTypeRepository.deleteById(id);
    }



}
