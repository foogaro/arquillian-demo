package it.redhat.arquillian.demo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by foogaro on 17/06/15.
 */
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private String mobile;

    public Person() {}

    public Person(String name, String lastname, String mobile) {
        this.name = name;
        this.lastname = lastname;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String cognome) {
        this.lastname = cognome;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String cellualre) {
        this.mobile = cellualre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
