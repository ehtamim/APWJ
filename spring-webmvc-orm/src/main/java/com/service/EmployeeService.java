package com.service;

import com.domain.Employee;
import com.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;

@Service
@Transactional

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public boolean insert(Employee employee) throws SQLException {
        employee.setFirstname(employee.getFirstname().toUpperCase());
        employee.setLastname(employee.getLastname().toUpperCase());
        employee.setGender(employee.getGender());
        employee.setJoiningDate(employee.getJoiningDate());
        employee.setEmployeeStatus(employee.getEmployeeStatus());
        return EmployeeRepository.create(employee);
    }
}
