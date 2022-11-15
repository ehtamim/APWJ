package com.controller;

import com.domain.Employee;
import com.service.EmployeeService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/employee")

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("employee") Employee employee,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else {
            employeeService.insert(employee);
            return "confirmation";
        }
    }
}
