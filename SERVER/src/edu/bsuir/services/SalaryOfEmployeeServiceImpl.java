package edu.bsuir.services;

import edu.bsuir.dao.DAO;
import edu.bsuir.dao.FormOfPaymentDAOImpl;
import edu.bsuir.dao.SalaryOfEmployeeDAOImpl;
import edu.bsuir.entities.SalaryOfEmployee;

import java.util.List;

public class SalaryOfEmployeeServiceImpl implements Service<SalaryOfEmployee>{

    DAO daoService = new SalaryOfEmployeeDAOImpl();

    @Override
    public SalaryOfEmployee findEntity(int id) {
        SalaryOfEmployee salaryOfEmployee = (SalaryOfEmployee) daoService.findByid(id);
        return salaryOfEmployee;
    }

    @Override
    public void saveEntity(SalaryOfEmployee salaryOfEmployee) {
         daoService.save(salaryOfEmployee);
    }

    @Override
    public void deleteEntity(SalaryOfEmployee salaryOfEmployee) {
         daoService.delete(salaryOfEmployee);
    }

    @Override
    public void updateEntity(SalaryOfEmployee salaryOfEmployee) {
         daoService.update(salaryOfEmployee);
    }

    @Override
    public List<SalaryOfEmployee> findAllEntities() {
        return daoService.findAll();
    }
}
