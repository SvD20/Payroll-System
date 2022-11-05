package edu.bsuir.services;

import edu.bsuir.dao.DAO;
import edu.bsuir.dao.MySalaryDAOImpl;
import edu.bsuir.entities.MySalary;

import java.util.List;

public class MySalaryServiceImpl implements Service<MySalary>{

    DAO daoService = new MySalaryDAOImpl();

    @Override
    public MySalary findEntity(int id) {
        MySalary mySalary = (MySalary) daoService.findByid(id);
        return mySalary;
    }

    @Override
    public void saveEntity(MySalary mySalary) {
        daoService.save(mySalary);
    }

    @Override
    public void deleteEntity(MySalary mySalary) {
        daoService.delete(mySalary);
    }

    @Override
    public void updateEntity(MySalary mySalary) {
        daoService.update(mySalary);
    }

    @Override
    public List<MySalary> findAllEntities() {
        return daoService.findAll();
    }
}
