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
}
