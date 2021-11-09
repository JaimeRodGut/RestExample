package org.iesfm.restexample.dao.inmemory;

import org.iesfm.restexample.Employee;
import org.iesfm.restexample.dao.EmployeeDAO;

import java.util.LinkedList;
import java.util.List;

public class inMemoryEmployeeDAO implements EmployeeDAO {

    private List<Employee> employees = new LinkedList<>();

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployee(String nif) {
        Employee employeeNif = null;
        for(Employee employee : employees){
            if(employee.getNif().equals(nif)){
                employeeNif = employee;
            }
        }
        return employeeNif;
    }

    @Override
    public void postEmployee() {
        Employee newEmployee = new Employee("123", "julian","fernandez","informatica","jefe");
        employees.add(newEmployee);
    }

    @Override
    public void deleteEmployee(String nif) {
        for(Employee employee : employees){
            if(employee.getNif().equals(nif)){
                employees.remove(employee);
            }
        }

    }

    @Override
    public List<Employee> getDepartmentEmployees(String departmentName) {
        List<Employee> departmentEmployees = new LinkedList<>();
        for (Employee employee : employees){
            if(employee.getDepartmentName().equals(departmentName)){
                departmentEmployees.add(employee);
            }
        }
        return departmentEmployees;
    }
}
