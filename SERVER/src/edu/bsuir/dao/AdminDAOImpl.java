package edu.bsuir.dao;

import edu.bsuir.entities.Admin;
import edu.bsuir.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class AdminDAOImpl implements DAO<Admin>{

    @Override
    public void save(Admin admin){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Admin admin){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(admin);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Admin admin){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(admin);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Admin findByid(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Admin admin = session.get(Admin.class,id);
        session.close();
        return admin;
    }

    @Override
    public List findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Admin> admins = (List<Admin>)session.createQuery("from Admin ").getResultList();
        session.close();
        return admins;
    }



}
