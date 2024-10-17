package com.example.inspection.repository;

import com.example.inspection.entity.Role;
import com.example.inspection.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
