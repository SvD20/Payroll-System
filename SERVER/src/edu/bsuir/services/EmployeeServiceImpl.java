package edu.bsuir.services;

import edu.bsuir.dao.DAO;
import edu.bsuir.dao.EmployeeDAOImpl;
import edu.bsuir.entities.Employee;

import java.util.List;

public class EmployeeServiceImpl implements Service<Employee> {

    DAO daoService = new EmployeeDAOImpl();

    @Override
    public Employee findEntity(int id) {
        Employee employee = (Employee) daoService.findByid(id);
        return employee;
    }

    @Override
    public void saveEntity(Employee employee) {
        daoService.save(employee);
    }

    @Override
    public void deleteEntity(Employee employee) {
        daoService.delete(employee);
    }

    @Override
    public void updateEntity(Employee employee) {
        daoService.update(employee);
    }

    @Override
    public List<Employee> findAllEntities() {
        return daoService.findAll();
    }




}
