package it.redhat.arquillian.demo.jpa;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by foogaro on 17/06/15.
 */
@RunWith(Arquillian.class)
public class PersonaDAOTest {

//    @EJB
//    PersonaDAO personaDAO;

    @Inject
    @PersistenceContext(unitName = "jpaDemoPU")
    EntityManager em;

    @Deployment
    public static Archive<?> createDeploymentPackage() {
        final WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Persona.class.getPackage())
                .addClass(Persona.class)
                .addClass(PersonaDAO.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
        System.out.println(webArchive.toString(true));
        return webArchive;
    }

    @Test
    public void insert() throws Exception {
        Persona persona = new Persona("Luigi", "Fugaro", "+393474244136");
//        persona.setId(new Long(1978));
        System.out.println(">>>>>>>>>>- INSERT: " + persona);
        //personaDAO.insert(persona);
        em.persist(persona);
        System.out.println(">>>>>>>>>>- INSERT: " + persona);
        Assert.assertNotNull(persona.getId());
    }

    @Test
    public void insertAndMerge() throws Exception {
        Persona persona = new Persona("Luigi", "Fugaro", "+393474244136");
        System.out.println(">>>>>>>>>>- I&U: " + persona);

        em.persist(persona);
        System.out.println(">>>>>>>>>>- I&U: " + persona);

        persona.setNome("Fabio");
        System.out.println(">>>>>>>>>>- I&U: " + persona);

        em.merge(persona);
        Persona wanted = em.find(Persona.class, new Long(2));
        System.out.println(">>>>>>>>>>- I&U: " + wanted);
        Assert.assertEquals(wanted.getNome(),persona.getNome());
    }

    @Test
    public void insertFindAndPersist() throws Exception {
        Persona persona = new Persona("Luigi", "Fugaro", "+393474244136");
        System.out.println(">>>>>>>>>>- I&U: " + persona);

        em.persist(persona);
        System.out.println(">>>>>>>>>>- I&U: " + persona);

        Persona updated = em.find(Persona.class, new Long(3));

        updated.setNome("Fabio");
        System.out.println(">>>>>>>>>>- I&U: " + updated);

        em.persist(updated);
        Persona wanted = em.find(Persona.class, new Long(3));
        System.out.println(">>>>>>>>>>- I&U: " + wanted);
        Assert.assertEquals(wanted.getNome(),updated.getNome());
    }

    @Test
    public void find() throws Exception {
        System.out.println(">>>>>>>>>>- FIND: [1]");
        Persona wanted = em.find(Persona.class, new Long(1));
        System.out.println(">>>>>>>>>>- FIND: " + wanted);
        Assert.assertNotNull(wanted);
    }

}
