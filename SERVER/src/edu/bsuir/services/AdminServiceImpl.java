package edu.bsuir.services;

import edu.bsuir.dao.AdminDAOImpl;
import edu.bsuir.dao.DAO;
import edu.bsuir.entities.Admin;


import java.util.List;

public class AdminServiceImpl implements Service<Admin> {

    DAO daoService = new AdminDAOImpl();

    @Override
    public Admin findEntity(int id) {
        Admin admin = (Admin) daoService.findByid(id);
        return admin;
    }

    @Override
    public void saveEntity(Admin admin) {
        daoService.save(admin);
    }

    @Override
    public void deleteEntity(Admin admin) {
        daoService.delete(admin);
    }

    @Override
    public void updateEntity(Admin admin) {
        daoService.update(admin);
    }

    @Override
    public List<Admin> findAllEntities() {
        return daoService.findAll();
    }


}
