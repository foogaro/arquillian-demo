package it.redhat.arquillian.demo.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by foogaro on 17/06/15.
 */
@Stateless
public class PersonaDAO {

    @PersistenceContext(unitName = "jpaDemoPU")
    private EntityManager em;

    public void insert(Persona persona) {
        em.persist(persona);
    }

    public void update(Persona persona) {
        em.persist(persona);
    }

    public void merge(Persona persona) {
        em.merge(persona);
    }

    public Persona find(Long id) {
        return em.find(Persona.class,id);
    }




}
