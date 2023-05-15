package dev.shulika.xtelweb.controller;

import dev.shulika.xtelweb.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public String findAllDepartments(
            Model model,
            @PageableDefault(size = 15) @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        log.info("+++++ IN DepartmentController :: findAllDepartments :: START +++++");
        var departments = departmentService.findAllPage(pageable);
        model.addAttribute("title", "Список отделов :: X-Tel");
        model.addAttribute("h1", "Список отделов");
        model.addAttribute("departments", departments);
        log.info("+++++ IN DepartmentController :: findAllDepartments :: COMPLETE +++++");
        return "departments";
    }

    @GetMapping("/departments/add")
    public String addDepartment(Model model) {
        log.info("+++++ IN DepartmentController :: addDepartment :: START +++++");
        model.addAttribute("title", "Добавить отдел :: X-Tel");
        model.addAttribute("h1", "Добавить отдел");


        log.info("+++++ IN DepartmentController :: addDepartment :: COMPLETE +++++");
        return "department-add";
    }

    @GetMapping("/departments/{id}/edit")
    public String editDepartment(
            Model model,
            @PathVariable("id") Long id
            ) {
        log.info("+++++ IN DepartmentController :: editDepartment :: START +++++");
        model.addAttribute("title", "Редактировать отдел :: X-Tel");
        model.addAttribute("h1", "Редактировать отдел");


        log.info("+++++ IN DepartmentController :: editDepartment :: COMPLETE +++++");
        return "department-edit";
    }
}
