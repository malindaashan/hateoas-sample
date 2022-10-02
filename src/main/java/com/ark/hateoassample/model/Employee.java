package com.ark.hateoassample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
public class Employee extends RepresentationModel<Employee> {

    private Integer id;
    private String name;
    private Integer salary;


}
