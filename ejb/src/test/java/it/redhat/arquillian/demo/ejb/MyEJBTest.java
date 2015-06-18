package it.redhat.arquillian.demo.ejb;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by foogaro on 16/06/15.
 */
@RunWith(Arquillian.class)
public class MyEJBTest {

    @Inject
    private MyEJB myEJB;

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "MyEJB.jar")
                .addClasses(MyEJB.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void add() {
        int x = 3;
        int y = 2;
        int wanted = x+y;
        System.out.println(">>>>>>>>>>- ADD -<<<<<<<<<< - " + myEJB);
        Assert.assertEquals(wanted, myEJB.add(x, y));
    }

    @Test
    public void concat() {
        String begin = "JBoss";
        String delim = " ";
        String end = "EAP";
        System.out.println(">>>>>>>>>>- CONCAT -<<<<<<<<<< - " + myEJB);
        String wanted = new StringBuilder().append(begin).append(delim).append(end).toString();
        Assert.assertEquals(wanted, myEJB.concat(begin, delim, end));
    }

}
