package com.example.inspection.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data

public class InspectionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inspectionTypeId;
    private String inspectionName;

}
