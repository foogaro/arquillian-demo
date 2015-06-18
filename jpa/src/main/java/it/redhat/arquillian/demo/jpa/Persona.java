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
public class Persona implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String cellualre;

    public Persona() {}

    public Persona(String nome, String cognome, String cellualre) {
        this.nome = nome;
        this.cognome = cognome;
        this.cellualre = cellualre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCellualre() {
        return cellualre;
    }

    public void setCellualre(String cellualre) {
        this.cellualre = cellualre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", cognome='").append(cognome).append('\'');
        sb.append(", cellualre='").append(cellualre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
