package dev.shulika.xtelweb.service;

import dev.shulika.xtelweb.model.Department;
import dev.shulika.xtelweb.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        log.info("+++++ IN DepartmentService :: findAll :: START +++++");
        var departments = departmentRepository.findAll();
        log.info("+++++ IN DepartmentService :: findAll :: FINISHED SUCCESSFULLY +++++");
        return departments;
    }
    public Page<Department> findAllPage(Pageable pageable) {
        log.info("+++++ IN DepartmentService :: findAllPage :: START +++++");
        var departments = departmentRepository.findAll(pageable);
        log.info("+++++ IN DepartmentService :: findAllPage :: FINISHED SUCCESSFULLY +++++");
        return departments;
    }

    public Long countDepartments(){
        log.info("+++++ IN DepartmentService :: countDepartments :: START +++++");
        var count = departmentRepository.findTotalDepartmentsCount();
        log.info("+++++ IN DepartmentService :: countDepartments :: FINISHED SUCCESSFULLY +++++");
        return count;
    }
}