package com.example.inspection.service;

import com.example.inspection.entity.Inspection;
import com.example.inspection.repository.InspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InspectionService {

    @Autowired
    private InspectionRepository inspectionRepository;

    public Inspection createInspection(Inspection inspection) {
        return inspectionRepository.save(inspection);
    }

    public Optional<Inspection> getInspectionById(int id) {
        return inspectionRepository.findById(id);
    }

    public void deleteInspection(int id) {
        inspectionRepository.deleteById(id);
    }

    public Inspection updateInspection(Inspection inspection) {
        return inspectionRepository.save(inspection);
    }
}
