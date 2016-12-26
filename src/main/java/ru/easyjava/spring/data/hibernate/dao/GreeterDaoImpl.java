package ru.easyjava.spring.data.hibernate.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.easyjava.spring.data.hibernate.entity.Greeter;

/**
 * JPA based implementation of GreeterDao.
 */
@Repository
public class GreeterDaoImpl implements GreeterDao {
    /**
     * JPA EM factory, provided by Spring.
     */
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public final void addGreet(final Greeter g) {
        Session s = sessionFactory.openSession();
        s.getTransaction().begin();
        s.persist(g);
        s.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public final List<Greeter> getGreetings() {
        return sessionFactory.openSession()
                .createCriteria(Greeter.class)
                .list();
    }
}
