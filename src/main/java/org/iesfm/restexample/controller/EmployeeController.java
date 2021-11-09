package org.iesfm.restexample.controller;

import org.iesfm.restexample.Employee;
import org.iesfm.restexample.dao.EmployeeDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


public class EmployeeController {

    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "employees")
    public List<Employee> get() {
        return employeeDAO.getEmployees();
    }

    @RequestMapping(method = RequestMethod.GET, path = "employees/{nif}")
    public Employee get(@PathVariable("nif") String nif) {
        Employee nifEmployee = employeeDAO.getEmployee(nif);
        if(nifEmployee == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "department not found"
            );
        } else {
            return nifEmployee;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "employees")
    public void post(@RequestBody Employee employee) {
        employeeDAO.postEmployee();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/employees/{nif}")
    public void delete(@PathVariable("nif") String nif) {
        employeeDAO.deleteEmployee(nif);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/departments/{departmentName}/employees")
    public List<Employee> getDepartmentEmployees(@PathVariable("departmentName") String departmentName) {
        List<Employee> departmentEmployees = employeeDAO.getDepartmentEmployees(departmentName);
        if(departmentEmployees == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "department not found"
            );
        } else {
            return departmentEmployees;
        }
    }
}
