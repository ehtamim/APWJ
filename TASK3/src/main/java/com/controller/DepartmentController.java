package com.controller;

import com.domain.Department;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    public DataSource dataSource;

    public DepartmentController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        List<Department> departments = new ArrayList<Department>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from departments");
        while (resultSet.next())
        {
            long i=resultSet.getLong(1);
            String n=resultSet.getString(2);
            String s=formatter.format(resultSet.getDate(3));
            Department d=new Department(i,n,s);
            departments.add(d);
        }

        model.addAttribute("departments", departments);
        return "department/list";
    }

    @RequestMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("department", new Department());
        return "department/create";
    }

    @RequestMapping("/create")
    public String create(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "department/create";
        }
        else
        {
            String name=department.getName();
            long millis=System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into departments(name, created_on) values (?, ?)");

            statement.setString(1, name);
            statement.setDate(2, date);

            statement.execute();
        }
        return "redirect:/departments/list";
    }
}
