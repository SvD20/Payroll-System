package edu.bsuir.dao;


import edu.bsuir.entities.MySalary;
import edu.bsuir.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class MySalaryDAOImpl implements DAO <MySalary>{

    @Override
    public void save(MySalary mySalary){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(mySalary);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(MySalary mySalary){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(mySalary);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(MySalary mySalary){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(mySalary);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public MySalary findByid(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        MySalary mySalary = session.get(MySalary.class,id);
        session.close();
        return mySalary;
    }

    @Override
    public List findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<MySalary> mysalarys = (List<MySalary>)session.createQuery("from MySalary ").getResultList();
        session.close();
        return mysalarys;
    }

}


