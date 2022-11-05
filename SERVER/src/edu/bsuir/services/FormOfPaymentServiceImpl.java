package edu.bsuir.services;

import edu.bsuir.dao.DAO;
import edu.bsuir.dao.FormOfPaymentDAOImpl;
import edu.bsuir.entities.Employee;
import edu.bsuir.entities.FormOfPayment;

import java.util.List;

public class FormOfPaymentServiceImpl implements Service<FormOfPayment>{

    DAO daoService = new FormOfPaymentDAOImpl();

    @Override
    public FormOfPayment findEntity(int id) {
        FormOfPayment formOfPayment = (FormOfPayment) daoService.findByid(id);
        return formOfPayment;
    }

    @Override
    public void saveEntity(FormOfPayment formOfPayment) {
        daoService.save(formOfPayment);
    }

    @Override
    public void deleteEntity(FormOfPayment formOfPayment) {
        daoService.delete(formOfPayment);
    }

    @Override
    public void updateEntity(FormOfPayment formOfPayment) {
        daoService.update(formOfPayment);
    }

    @Override
    public List<FormOfPayment> findAllEntities() {
        return daoService.findAll();
    }
}
