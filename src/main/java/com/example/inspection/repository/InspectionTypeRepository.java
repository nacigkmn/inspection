package com.example.inspection.repository;

import com.example.inspection.entity.InspectionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionTypeRepository extends JpaRepository<InspectionType,Integer> {

}
