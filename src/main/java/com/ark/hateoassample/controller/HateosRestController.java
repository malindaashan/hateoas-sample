package com.ark.hateoassample.controller;


import com.ark.hateoassample.model.Employee;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("employee")
public class HateosRestController {
    @GetMapping("/employee/all")
    public List<Employee> getAllEmployees() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Malinda", 1000));
        empList.add(new Employee(1, "Ashan", 2000));
        return empList;

    }

    @GetMapping("/hateos/all")
    public List<Employee> getAllWithHateosEmployees() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Malinda", 1000));
        empList.add(new Employee(1, "Ashan", 2000));

        for (Employee emp : empList) {
            Link selfLink = linkTo(HateosRestController.class).slash(emp.getId()).withSelfRel();
            emp.add(selfLink);
        }
        return empList;

    }
}