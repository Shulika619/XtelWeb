package dev.shulika.xtelweb.repository;


import dev.shulika.xtelweb.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT COUNT(d) FROM Department d")
    long findTotalDepartmentsCount();
}