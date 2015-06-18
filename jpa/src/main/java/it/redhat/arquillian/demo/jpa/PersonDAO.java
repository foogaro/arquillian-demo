package it.redhat.arquillian.demo.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by foogaro on 17/06/15.
 */
@Stateless
public class PersonDAO {

    @PersistenceContext(unitName = "jpaDemoPU")
    private EntityManager em;

    public void insert(Person person) {
        em.persist(person);
    }

    public void update(Person person) {
        em.persist(person);
    }

    public void merge(Person person) {
        em.merge(person);
    }

    public Person find(Long id) {
        return em.find(Person.class, id);
    }

}
