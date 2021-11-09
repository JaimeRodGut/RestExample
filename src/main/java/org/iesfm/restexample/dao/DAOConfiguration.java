package org.iesfm.restexample.dao;

import org.iesfm.restexample.Department;
import org.iesfm.restexample.dao.inmemory.InMemoryDepartmentDAO;
import org.iesfm.restexample.dao.inmemory.inMemoryEmployeeDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DAOConfiguration {

    @Bean
    public DepartmentDAO departmentDAO() {
        return new InMemoryDepartmentDAO();
    }

    @Bean
    public EmployeeDAO employeeDAO() {
        return new inMemoryEmployeeDAO();
    }
}
