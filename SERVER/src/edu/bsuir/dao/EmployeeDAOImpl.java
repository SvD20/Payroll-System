package edu.bsuir.dao;

import edu.bsuir.entities.Employee;
import edu.bsuir.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDAOImpl implements DAO <Employee>{

    @Override
    public void save(Employee employee){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Employee employee){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Employee employee){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(employee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Employee findByid(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Employee employee = session.get(Employee.class,id);
        session.close();
        return employee;
    }

    @Override
    public List findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Employee> employees = (List<Employee>)session.createQuery("from Employee ").getResultList();
        session.close();
        return employees;
    }

}
