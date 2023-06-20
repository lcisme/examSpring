package com.example.examspring.controller;

import com.example.examspring.entity.Employee;
import com.example.examspring.respository.EmployeeRespository;
import com.example.examspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee/listEmployee";
    }

    @GetMapping("/new")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/createEmployee";
    }

    @PostMapping
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }
}