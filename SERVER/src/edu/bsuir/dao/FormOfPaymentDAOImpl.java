package edu.bsuir.dao;


import edu.bsuir.entities.FormOfPayment;
import edu.bsuir.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class FormOfPaymentDAOImpl implements DAO <FormOfPayment>{

    @Override
    public void save(FormOfPayment formOfPayment){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(formOfPayment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(FormOfPayment formOfPayment){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(formOfPayment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(FormOfPayment formOfPayment){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(formOfPayment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public FormOfPayment findByid(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        FormOfPayment formOfPayment = session.get(FormOfPayment.class,id);
        session.close();
        return formOfPayment;
    }

    @Override
    public List findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<FormOfPayment> formsofpayment = (List<FormOfPayment>)session.createQuery("from FormOfPayment ").getResultList();
        session.close();
        return formsofpayment;
    }

}
