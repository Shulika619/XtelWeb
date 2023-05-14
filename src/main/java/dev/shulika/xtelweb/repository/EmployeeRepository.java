package dev.shulika.xtelweb.repository;


import dev.shulika.xtelweb.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}