package ru.mocard.service;

import org.springframework.stereotype.Service;
import ru.mocard.employee.Employee;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    private static final int MAX_SIZE = 100;
    private final List<Employee> employees = new ArrayList<>(MAX_SIZE);

    public void add(String firstName,String lastName) {
        var employee = new Employee(firstName, lastName);

    }
    public void delete(String firstName,String lastName) {

    }
    public void find(String firstName,String lastName) {

    }
}
