package com.example.inspection.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int photoId;
    private  String photoURL;

    @ManyToOne
    private Inspection inspection;
}
