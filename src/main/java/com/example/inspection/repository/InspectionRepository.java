package com.example.inspection.repository;

import com.example.inspection.entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<Inspection,Integer> {
}
