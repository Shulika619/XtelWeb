package dev.shulika.xtelweb.repository;


import dev.shulika.xtelweb.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}