package com.example.inspection.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "inspector_id", nullable = false)
    private User inspector;

    @ManyToOne
    @JoinColumn(name = "status_status_id", nullable = false)
    private Status status;

    private String description;

    @OneToMany(mappedBy = "inspection",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Photo> photos = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "inspection_type_id", nullable = false)
    private InspectionType inspectionType;

    private LocalDate dateOfInspection;

}
