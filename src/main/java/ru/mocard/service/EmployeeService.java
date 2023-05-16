package ru.mocard.service;

import org.springframework.stereotype.Service;
import ru.mocard.employee.Employee;
import ru.mocard.exception.EmployeeAlreadyAddedException;
import ru.mocard.exception.EmployeeNotFoundException;
import ru.mocard.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    private static final int MAX_SIZE = 100;
    private final List<Employee> employees = new ArrayList<>(MAX_SIZE);

    public Employee add(String firstName, String lastName) {
        if(employees.size() > MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;

    }
    public void delete(String firstName,String lastName) {
        var employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
        }
        throw new EmployeeNotFoundException();

    }
    public Employee find(String firstName,String lastName) {
        var employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();

    }
}
