package edu.bsuir.dao;

import edu.bsuir.entities.SalaryOfEmployee;
import edu.bsuir.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class SalaryOfEmployeeDAOImpl implements DAO <SalaryOfEmployee>{

    @Override
    public void save(SalaryOfEmployee salaryOfEmployee){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(salaryOfEmployee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(SalaryOfEmployee salaryOfEmployee){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(salaryOfEmployee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(SalaryOfEmployee salaryOfEmployee){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(salaryOfEmployee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public SalaryOfEmployee findByid(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        SalaryOfEmployee salaryOfEmployee = session.get(SalaryOfEmployee.class,id);
        session.close();
        return salaryOfEmployee;
    }

    @Override
    public List findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<SalaryOfEmployee> salarysofemployee = (List<SalaryOfEmployee>)session.createQuery("from SalaryOfEmployee ").getResultList();
        session.close();
        return salarysofemployee;
    }


}
