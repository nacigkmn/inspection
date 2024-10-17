package com.example.inspection.controller;

import com.example.inspection.entity.InspectionType;
import com.example.inspection.service.InspectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/inspection-types")
public class InspectionTypeController {

    @Autowired
    private InspectionTypeService inspectionTypeService;


    @PostMapping("/add")
    public ResponseEntity<InspectionType> addInspectionType(@RequestBody InspectionType inspectionType) {
        return new ResponseEntity<>(inspectionTypeService.createInspectionType(inspectionType), HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<InspectionType>> getAllInspectionTypes() {
        List<InspectionType> inspectionTypes = inspectionTypeService.getAllInspectionTypes();

        return ResponseEntity.ok(inspectionTypes);
    }


    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<InspectionType> getInspectionTypeById(@PathVariable int id) {
        return inspectionTypeService.getInspectionTypeById(id)
                .map(inspectionType -> ResponseEntity.ok().body(inspectionType))
                .orElseThrow(() -> new NoSuchElementException());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<InspectionType> updateInspectionType(@PathVariable int id,
                                                               @RequestBody InspectionType inspectionType) {

        InspectionType inspectionTypetuUpdate = inspectionTypeService.updateInspectionType(id, inspectionType);

        return ResponseEntity.ok(inspectionTypetuUpdate);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInspectionType(@PathVariable int id) {
        inspectionTypeService.deleteInspectionType(id);
        return ResponseEntity.noContent().build();
    }

}
