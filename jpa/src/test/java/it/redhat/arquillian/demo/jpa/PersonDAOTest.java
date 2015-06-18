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

/**
 * Created by foogaro on 17/06/15.
 */
@RunWith(Arquillian.class)
public class PersonDAOTest {

    @EJB
    PersonDAO personDAO;

    @Deployment
    public static Archive<?> createDeploymentPackage() {
        final WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Person.class.getPackage())
                .addClass(Person.class)
                .addClass(PersonDAO.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
        System.out.println(webArchive.toString(true));
        return webArchive;
    }

    @Test
    public void insert() throws Exception {
        Person person = new Person("Luigi", "Fugaro", "+391234567");
        personDAO.insert(person);
        Assert.assertNotNull(person.getId());
    }

    @Test
    public void update() throws Exception {
        Person person = find(new Long(1));
        person.setLastname("Foogaro");
        personDAO.merge(person);
        Assert.assertEquals(person.getLastname(),find(new Long(1)).getLastname());
    }

    @Test
    public void merge() throws Exception {
        Person person = find(new Long(1));
        person.setLastname("Fugaro");
        personDAO.merge(person);
        Assert.assertEquals(person.getLastname(),find(new Long(1)).getLastname());
    }

    @Test
    public void find() throws Exception {
        Assert.assertNotNull(find(new Long(1)));
    }

    private Person find(Long id) {
        return personDAO.find(id);
    }

}
