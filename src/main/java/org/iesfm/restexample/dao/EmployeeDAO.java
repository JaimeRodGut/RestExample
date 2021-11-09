package org.iesfm.restexample.dao;

import org.iesfm.restexample.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();
    Employee getEmployee(String nif);
    void postEmployee();
    void deleteEmployee(String nif);
    List<Employee> getDepartmentEmployees(String departmentName);
}
