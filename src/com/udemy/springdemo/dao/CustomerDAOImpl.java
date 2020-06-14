package com.udemy.springdemo.dao;

import com.udemy.springdemo.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO{

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getCustomers() {
        // get the current hibernate session
        final Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        final Query theQuery = currentSession.createQuery("from Customer order by lastName",
                                                             Customer.class);
        // execute query and get result list
        return theQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {

        final Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int theId) {

        final Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Customer.class, theId);
    }

    @Override
    public void deleteCustomer(int theId) {

        final Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

        theQuery.setParameter("customerId", theId);

        theQuery.executeUpdate();
    }


}
