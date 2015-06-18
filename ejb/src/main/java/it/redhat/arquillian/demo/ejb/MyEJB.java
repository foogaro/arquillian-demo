package it.redhat.arquillian.demo.ejb;

import javax.ejb.Stateless;

/**
 * Created by foogaro on 16/06/15.
 */
@Stateless
public class MyEJB {

    public int add(int x, int y) { return x+y; }
    public String concat(String begin, String delim, String end) { return new StringBuilder().append(begin).append(delim).append(end).toString(); }

}
